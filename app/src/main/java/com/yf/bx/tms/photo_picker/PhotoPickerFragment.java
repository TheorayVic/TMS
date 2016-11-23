package com.yf.bx.tms.photo_picker;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yf.bx.tms.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.iwf.photopicker.adapter.PopupDirectoryListAdapter;
import me.iwf.photopicker.entity.Photo;
import me.iwf.photopicker.entity.PhotoDirectory;
import me.iwf.photopicker.event.OnPhotoClickListener;
import me.iwf.photopicker.fragment.ImagePagerFragment;
import me.iwf.photopicker.utils.AndroidLifecycleUtils;
import me.iwf.photopicker.utils.ImageCaptureManager;
import me.iwf.photopicker.utils.MediaStoreHelper;

/**
 * Created by bai on 2016/11/14.
 */

public class PhotoPickerFragment extends Fragment {
    private ImageCaptureManager captureManager;
    private PhotoGridAdapter photoGridAdapter;
    private PopupDirectoryListAdapter listAdapter;
    private List<PhotoDirectory> directories;
    private ArrayList<String> originalPhotos;
    private int SCROLL_THRESHOLD = 30;
    int column;
    public static int COUNT_MAX = 4;
    private static final String EXTRA_CAMERA = "camera";
    private static final String EXTRA_COLUMN = "column";
    private static final String EXTRA_COUNT = "count";
    private static final String EXTRA_GIF = "gif";
    private static final String EXTRA_ORIGIN = "origin";
    private ListPopupWindow listPopupWindow;
    private RequestManager mGlideRequestManager;

    public PhotoPickerFragment() {
    }

    public static PhotoPickerFragment newInstance(boolean showCamera, boolean showGif, boolean previewEnable, int column, int maxCount, ArrayList<String> originalPhotos) {
        Bundle args = new Bundle();
        args.putBoolean("camera", showCamera);
        args.putBoolean("gif", showGif);
        args.putBoolean("PREVIEW_ENABLED", previewEnable);
        args.putInt("column", column);
        args.putInt("count", maxCount);
        args.putStringArrayList("origin", originalPhotos);
        PhotoPickerFragment fragment = new PhotoPickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRetainInstance(true);
        this.mGlideRequestManager = Glide.with(this);
        this.directories = new ArrayList();
        this.originalPhotos = this.getArguments().getStringArrayList("origin");
        this.column = this.getArguments().getInt("column", 4);
        boolean showCamera = this.getArguments().getBoolean("camera", true);
        boolean previewEnable = this.getArguments().getBoolean("PREVIEW_ENABLED", true);
        this.photoGridAdapter = new PhotoGridAdapter(getActivity(), this.mGlideRequestManager, this.directories, this.originalPhotos, this.column);
        this.photoGridAdapter.setShowCamera(showCamera);
        this.photoGridAdapter.setPreviewEnable(previewEnable);
        Bundle mediaStoreArgs = new Bundle();
        boolean showGif = this.getArguments().getBoolean("gif");
        mediaStoreArgs.putBoolean("SHOW_GIF", showGif);
        MediaStoreHelper.getPhotoDirs(this.getActivity(), mediaStoreArgs, new MediaStoreHelper.PhotosResultCallback() {
            public void onResultCallback(List<PhotoDirectory> dirs) {
                PhotoPickerFragment.this.directories.clear();
                PhotoPickerFragment.this.directories.addAll(dirs);
                PhotoPickerFragment.this.photoGridAdapter.notifyDataSetChanged();
                PhotoPickerFragment.this.listAdapter.notifyDataSetChanged();
                PhotoPickerFragment.this.adjustHeight();
            }
        });
        this.captureManager = new ImageCaptureManager(this.getActivity());
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(me.iwf.photopicker.R.layout.__picker_fragment_photo_picker, container, false);
        this.listAdapter = new PopupDirectoryListAdapter(this.mGlideRequestManager, this.directories);
        RecyclerView recyclerView = (RecyclerView)rootView.findViewById(me.iwf.photopicker.R.id.rv_photos);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(this.column, 1);
       // GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),4);
        layoutManager.setGapStrategy(2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this.photoGridAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        final Button btSwitchDirectory = (Button)rootView.findViewById(me.iwf.photopicker.R.id.button);
        this.listPopupWindow = new ListPopupWindow(this.getActivity());
        this.listPopupWindow.setWidth(-1);
        this.listPopupWindow.setAnchorView(btSwitchDirectory);
        this.listPopupWindow.setAdapter(this.listAdapter);
        this.listPopupWindow.setModal(true);
        this.listPopupWindow.setDropDownGravity(80);
        this.listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PhotoPickerFragment.this.listPopupWindow.dismiss();
                PhotoDirectory directory = (PhotoDirectory) PhotoPickerFragment.this.directories.get(position);
                btSwitchDirectory.setText(directory.getName());
                PhotoPickerFragment.this.photoGridAdapter.setCurrentDirectoryIndex(position);
                PhotoPickerFragment.this.photoGridAdapter.notifyDataSetChanged();
            }
        });
        this.photoGridAdapter.setOnPhotoClickListener(new OnPhotoClickListener() {
            public void onClick(View v, int position, boolean showCamera) {
                int index = showCamera?position - 1:position;
                List photos = PhotoPickerFragment.this.photoGridAdapter.getCurrentPhotoPaths();
                int[] screenLocation = new int[2];
                v.getLocationOnScreen(screenLocation);
                ImagePagerFragment imagePagerFragment = ImagePagerFragment.newInstance(photos, index, screenLocation, v.getWidth(), v.getHeight());
                ((com.yf.bx.tms.photo_picker.PhotoPickerActivity) PhotoPickerFragment.this.getActivity()).addImagePagerFragment
                        (imagePagerFragment);
            }
        });
        this.photoGridAdapter.setOnCameraClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(me.iwf.photopicker.utils.PermissionsUtils.checkCameraPermission(PhotoPickerFragment.this)) {
                    if(me.iwf.photopicker.utils.PermissionsUtils.checkWriteStoragePermission(PhotoPickerFragment.this)) {
                        PhotoPickerFragment.this.openCamera();
                    }
                }
            }
        });
        btSwitchDirectory.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(PhotoPickerFragment.this.listPopupWindow.isShowing()) {
                    PhotoPickerFragment.this.listPopupWindow.dismiss();
                } else if(!PhotoPickerFragment.this.getActivity().isFinishing()) {
                    PhotoPickerFragment.this.adjustHeight();
                    PhotoPickerFragment.this.listPopupWindow.show();
                }

            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(Math.abs(dy) > PhotoPickerFragment.this.SCROLL_THRESHOLD) {
                    PhotoPickerFragment.this.mGlideRequestManager.pauseRequests();
                } else {
                    PhotoPickerFragment.this.resumeRequestsIfNotDestroyed();
                }

            }

            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if(newState == 0) {
                    PhotoPickerFragment.this.resumeRequestsIfNotDestroyed();
                }

            }
        });
        return rootView;
    }

    private void openCamera() {
        try {
            Intent e = this.captureManager.dispatchTakePictureIntent();
            this.startActivityForResult(e, 1);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 1 && resultCode == -1) {
            if(this.captureManager == null) {
                FragmentActivity path = this.getActivity();
                this.captureManager = new ImageCaptureManager(path);
            }

            this.captureManager.galleryAddPic();
            if(this.directories.size() > 0) {
                String path1 = this.captureManager.getCurrentPhotoPath();
                PhotoDirectory directory = (PhotoDirectory)this.directories.get(0);
                directory.getPhotos().add(0, new Photo(path1.hashCode(), path1));
                directory.setCoverPath(path1);
                this.photoGridAdapter.notifyDataSetChanged();
            }
        }

    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(grantResults.length > 0 && grantResults[0] == 0) {
            switch(requestCode) {
                case 1:
                case 3:
                    if(me.iwf.photopicker.utils.PermissionsUtils.checkWriteStoragePermission(this) && me.iwf.photopicker.utils.PermissionsUtils.checkCameraPermission(this)) {
                        this.openCamera();
                    }
            }
        }

    }

    public PhotoGridAdapter getPhotoGridAdapter() {
        return this.photoGridAdapter;
    }

    public void onSaveInstanceState(Bundle outState) {
        this.captureManager.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
        this.captureManager.onRestoreInstanceState(savedInstanceState);
        super.onViewStateRestored(savedInstanceState);
    }

    public ArrayList<String> getSelectedPhotoPaths() {
        return this.photoGridAdapter.getSelectedPhotoPaths();
    }

    public void adjustHeight() {
        if(this.listAdapter != null) {
            int count = this.listAdapter.getCount();
            count = count < COUNT_MAX?count:COUNT_MAX;
            if(this.listPopupWindow != null) {
                this.listPopupWindow.setHeight(count * this.getResources().getDimensionPixelOffset(me.iwf.photopicker.R.dimen.__picker_item_directory_height));
            }

        }
    }

    public void onDestroy() {
        super.onDestroy();
        if(this.directories != null) {
            Iterator var1 = this.directories.iterator();

            while(var1.hasNext()) {
                PhotoDirectory directory = (PhotoDirectory)var1.next();
                directory.getPhotoPaths().clear();
                directory.getPhotos().clear();
                directory.setPhotos((List)null);
            }

            this.directories.clear();
            this.directories = null;
        }
    }

    private void resumeRequestsIfNotDestroyed() {
        if(AndroidLifecycleUtils.canLoadImage(this)) {
            this.mGlideRequestManager.resumeRequests();
        }
    }
}
