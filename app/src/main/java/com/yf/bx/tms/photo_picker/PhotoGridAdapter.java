package com.yf.bx.tms.photo_picker;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.yf.bx.tms.R;
import com.yf.bx.tms.utils.PhotoUtils1;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import me.iwf.photopicker.adapter.SelectableAdapter;
import me.iwf.photopicker.entity.Photo;
import me.iwf.photopicker.entity.PhotoDirectory;
import me.iwf.photopicker.event.OnItemCheckListener;
import me.iwf.photopicker.event.OnPhotoClickListener;
import me.iwf.photopicker.utils.AndroidLifecycleUtils;

/**
 * Created by bai on 2016/11/14.
 */

public class PhotoGridAdapter extends SelectableAdapter<PhotoGridAdapter.PhotoViewHolder> {

    private final static String TAG = "PhotoGridAdapter";
    private LayoutInflater inflater;
    private RequestManager glide;
    private OnItemCheckListener onItemCheckListener;
    private OnPhotoClickListener onPhotoClickListener;
    private View.OnClickListener onCameraClickListener;
    public static final int ITEM_TYPE_CAMERA = 100;
    public static final int ITEM_TYPE_PHOTO = 101;
    private static final int COL_NUMBER_DEFAULT = 3;
    private boolean hasCamera;
    private boolean previewEnable;
    private int imageSize;
    private int columnNumber;
    private View itemView;
    private View.OnClickListener listener;
    private Context context;
    private View popupView;
    private PhotoUtils1 mPopupwindow;

    public PhotoGridAdapter(Context context, RequestManager requestManager, List<PhotoDirectory> photoDirectories) {
        this.onItemCheckListener = null;
        this.onPhotoClickListener = null;
        this.onCameraClickListener = null;
        this.hasCamera = true;
        this.previewEnable = true;
        this.columnNumber = 4;
        this.photoDirectories = photoDirectories;
        this.glide = requestManager;
        this.inflater = LayoutInflater.from(context);
        this.setColumnNumber(context, this.columnNumber);
        this.context = context;
        popupView = inflater.inflate(R.layout.pickerpopupwindow,null);
    }

    public PhotoGridAdapter(Context context, RequestManager requestManager, List<PhotoDirectory> photoDirectories, ArrayList<String> orginalPhotos, int colNum) {
        this(context, requestManager, photoDirectories);
        this.setColumnNumber(context, colNum);
        this.selectedPhotos = new ArrayList();
        if(orginalPhotos != null) {
            this.selectedPhotos.addAll(orginalPhotos);
        }

    }

    private void setColumnNumber(Context context, int columnNumber) {
        this.columnNumber = columnNumber;
        WindowManager wm = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        int widthPixels = metrics.widthPixels;
        this.imageSize = widthPixels / columnNumber;
    }

    public int getItemViewType(int position) {
        return this.showCamera() && position == 0?100:101;
    }

    public PhotoGridAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = this.inflater.inflate(R.layout.gridview_pickerphoto_item, parent, false);
        PhotoGridAdapter.PhotoViewHolder holder = new PhotoGridAdapter.PhotoViewHolder(itemView);
        if(viewType == 100) {
            holder.vSelected.setVisibility(View.INVISIBLE);
            holder.ivPhoto.setScaleType(ImageView.ScaleType.CENTER);
            holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(PhotoGridAdapter.this.onCameraClickListener != null) {
                        PhotoGridAdapter.this.onCameraClickListener.onClick(view);
                    }

                }
            });
        }

        return holder;
    }

    public void onBindViewHolder(final PhotoGridAdapter.PhotoViewHolder holder, int position) {
        if(this.getItemViewType(position) == 101) {
            List photos = this.getCurrentPhotos();
            final Photo photo;
            if(this.showCamera()) {
                photo = (Photo)photos.get(position - 1);
            } else {
                photo = (Photo)photos.get(position);
            }

            final boolean canLoadImage = AndroidLifecycleUtils.canLoadImage(holder.ivPhoto.getContext());
            if(canLoadImage) {
                this.glide.load(new File(photo.getPath())).centerCrop().dontAnimate().thumbnail(0.5F).override(this.imageSize, this.imageSize).placeholder(me.iwf.photopicker.R.drawable.__picker_ic_photo_black_48dp).error(me.iwf.photopicker.R.drawable.__picker_ic_broken_image_black_48dp).into(holder.ivPhoto);
            }

            final boolean isChecked = this.isSelected(photo);
            holder.vSelected.setSelected(isChecked);
            holder.ivPhoto.setSelected(isChecked);
            holder.ivPhoto.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if(PhotoGridAdapter.this.onPhotoClickListener != null) {
                        int pos = holder.getAdapterPosition();
                        if(PhotoGridAdapter.this.previewEnable) {
                            PhotoGridAdapter.this.onPhotoClickListener.onClick(view, pos, PhotoGridAdapter.this.showCamera());
                        } else {
                            holder.vSelected.performClick();
                        }
                    }

                }
            });
            holder.vSelected.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int pos = holder.getAdapterPosition();
                    boolean isEnable = true;
                    if(PhotoGridAdapter.this.onItemCheckListener != null) {
                        isEnable = PhotoGridAdapter.this.onItemCheckListener.OnItemCheck(pos, photo, isChecked, PhotoGridAdapter.this.getSelectedPhotos().size());
                    }

                    if(isEnable) {
                        PhotoGridAdapter.this.toggleSelection(photo);
                        PhotoGridAdapter.this.notifyItemChanged(pos);
                    }

                }
            });

            listener = new View.OnClickListener(){
                @Override
                public void onClick(View view) {

                    switch (view.getId()){
                        case R.id.picker_edit:
                            Toast.makeText(context, "编辑", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.picker_del:
                            break;
                    }

                }
            };
            holder.ivPhoto.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int[] arrayOfInt = new int[2];
                 //   获取点击图片的坐标
                    v.getLocationOnScreen(arrayOfInt);
                    int x = arrayOfInt[0];
                    int y = arrayOfInt[1];

                    mPopupwindow = new PhotoUtils1(context,popupView,holder.ivPhoto,listener);
                    mPopupwindow.showAtLocation(holder.ivPhoto,0,x,y);
                    return true;
                }
            });
        } else {
            holder.ivPhoto.setImageResource(R.drawable.__picker_camera);
        }

    }

    public int getItemCount() {
        int photosCount = this.photoDirectories.size() == 0?0:this.getCurrentPhotos().size();
        return this.showCamera()?photosCount + 1:photosCount;
    }

    public void setOnItemCheckListener(OnItemCheckListener onItemCheckListener) {
        this.onItemCheckListener = onItemCheckListener;
    }

    public void setOnPhotoClickListener(OnPhotoClickListener onPhotoClickListener) {
        this.onPhotoClickListener = onPhotoClickListener;
    }

    public void setOnCameraClickListener(View.OnClickListener onCameraClickListener) {
        this.onCameraClickListener = onCameraClickListener;
    }

    public ArrayList<String> getSelectedPhotoPaths() {
        ArrayList selectedPhotoPaths = new ArrayList(this.getSelectedItemCount());
        Iterator var2 = this.selectedPhotos.iterator();

        while(var2.hasNext()) {
            String photo = (String)var2.next();
            selectedPhotoPaths.add(photo);
        }

        return selectedPhotoPaths;
    }

    public void setShowCamera(boolean hasCamera) {
        this.hasCamera = hasCamera;
    }

    public void setPreviewEnable(boolean previewEnable) {
        this.previewEnable = previewEnable;
    }

    public boolean showCamera() {
        return this.hasCamera && this.currentDirectoryIndex == 0;
    }

    public void onViewRecycled(PhotoGridAdapter.PhotoViewHolder holder) {
        Glide.clear(holder.ivPhoto);
        super.onViewRecycled(holder);
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private View vSelected;

        public PhotoViewHolder(View itemView) {
            super(itemView);
            this.ivPhoto = (ImageView)itemView.findViewById(R.id.iv_photo);
            this.vSelected = itemView.findViewById(R.id.v_selected);
        }
    }


    class PhotoUtils1 extends PopupWindow {


        private ImageView iv_del,iv_edit;


        public PhotoUtils1() {
        }

        public PhotoUtils1(Context context, View menuView, View view,View.OnClickListener onClickListener) {
            super(context);
            iv_edit = (ImageView) menuView.findViewById(R.id.picker_edit);
            iv_del = (ImageView) menuView.findViewById(R.id.picker_del);

            iv_edit.setOnClickListener(onClickListener);
            iv_del.setOnClickListener(onClickListener);

            //设置显示内容的属性
            this.setContentView(menuView);
            //设置弹出的宽和高
            this.setWidth(view.getWidth());
            this.setHeight(view.getHeight());
            //设置可以获得焦点
            this.setFocusable(true);
            //添加背景颜色
            //     this.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffcc")));
            //设置弹出框外围不能被点击
            this.setOutsideTouchable(true);
        }
    }
}
