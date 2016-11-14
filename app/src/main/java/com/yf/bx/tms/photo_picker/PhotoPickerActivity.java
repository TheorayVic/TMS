package com.yf.bx.tms.photo_picker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.zhy.autolayout.AutoLayoutActivity;

import java.util.ArrayList;
import java.util.List;

import me.iwf.photopicker.entity.Photo;
import me.iwf.photopicker.event.OnItemCheckListener;
import me.iwf.photopicker.fragment.ImagePagerFragment;

/**
 * Created by bai on 2016/11/13.
 */

public class PhotoPickerActivity extends AutoLayoutActivity implements View.OnClickListener,
        View.OnLongClickListener {
    private PhotoPickerFragment pickerFragment;
    private ImagePagerFragment imagePagerFragment;
    private int maxCount = 9;
    private boolean menuIsInflated = false;
    private boolean showGif = false;
    private int columnNumber = 4;
    private ArrayList<String> originalPhotos = null;
    private ImageButton ib_back;
    private Button btn_save;

    public PhotoPickerActivity() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean showCamera = this.getIntent().getBooleanExtra("SHOW_CAMERA", true);
        boolean showGif = this.getIntent().getBooleanExtra("SHOW_GIF", false);
        boolean previewEnabled = this.getIntent().getBooleanExtra("PREVIEW_ENABLED", true);
        this.setShowGif(showGif);
        this.setContentView(R.layout.activity_photopicker);
//        Toolbar mToolbar = (Toolbar)this.findViewById(me.iwf.photopicker.R.id.toolbar);
//        this.setSupportActionBar(mToolbar);
//        this.setTitle(me.iwf.photopicker.R.string.__picker_title);
//        ActionBar actionBar = this.getSupportActionBar();
//
//        assert actionBar != null;
//
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        if(Build.VERSION.SDK_INT >= 21) {
//            actionBar.setElevation(25.0F);
//        }

        ib_back = (ImageButton) findViewById(R.id.ib_ksxj_photo_back);
        btn_save = (Button) findViewById(R.id.btn_ksxj_photo_save);
        ib_back.setOnClickListener(this);
        btn_save.setOnClickListener(this);

        this.maxCount = this.getIntent().getIntExtra("MAX_COUNT", 9);
        this.columnNumber = this.getIntent().getIntExtra("column", 4);
        this.originalPhotos = this.getIntent().getStringArrayListExtra("ORIGINAL_PHOTOS");
        this.pickerFragment = (PhotoPickerFragment) this.getSupportFragmentManager().findFragmentByTag("tag");
        if (this.pickerFragment == null) {
            this.pickerFragment = PhotoPickerFragment.newInstance(showCamera, showGif, previewEnabled, this.columnNumber, this.maxCount, this.originalPhotos);
            this.getSupportFragmentManager().beginTransaction().replace(R.id.container, this.pickerFragment, "tag").commit();
            this.getSupportFragmentManager().executePendingTransactions();
        }

        this.pickerFragment.getPhotoGridAdapter().setOnItemCheckListener(new OnItemCheckListener() {
            public boolean OnItemCheck(int position, Photo photo, boolean isCheck, int selectedItemCount) {
                int total = selectedItemCount + (isCheck ? -1 : 1);
//                PhotoPickerActivity.this.menuDoneItem.setEnabled(total > 0);
                if (PhotoPickerActivity.this.maxCount <= 1) {
                    List photos = PhotoPickerActivity.this.pickerFragment.getPhotoGridAdapter().getSelectedPhotos();
                    if (!photos.contains(photo.getPath())) {
                        photos.clear();
                        PhotoPickerActivity.this.pickerFragment.getPhotoGridAdapter().notifyDataSetChanged();
                    }

                    return true;
                } else if (total > PhotoPickerActivity.this.maxCount) {
                    Toast.makeText(PhotoPickerActivity.this.getActivity(), "最多只能选择9张图片", Toast.LENGTH_SHORT).show();
                    return false;
                } else {
                    // PhotoPickerActivity.this.menuDoneItem.setTitle(PhotoPickerActivity.this.getString(me.iwf.photopicker.R.string.__picker_done_with_count, new Object[]{Integer.valueOf(total), Integer.valueOf(PhotoPickerActivity.this.maxCount)}));
                    return true;
                }
            }
        });

    }

    public void onBackPressed() {
        if (this.imagePagerFragment != null && this.imagePagerFragment.isVisible()) {
            this.imagePagerFragment.runExitAnimation(new Runnable() {
                public void run() {
                    if (PhotoPickerActivity.this.getSupportFragmentManager().getBackStackEntryCount() > 0) {
                        PhotoPickerActivity.this.getSupportFragmentManager().popBackStack();
                    }

                }
            });
        } else {
            super.onBackPressed();
        }

    }

    public void addImagePagerFragment(ImagePagerFragment imagePagerFragment) {
        this.imagePagerFragment = imagePagerFragment;
        this.getSupportFragmentManager().beginTransaction().replace(me.iwf.photopicker.R.id.container, this.imagePagerFragment).addToBackStack((String) null).commit();
    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        if(this.menuIsInflated) {
//            return false;
//        } else {
//            this.getMenuInflater().inflate(R.menu.photopicker_menu, menu);
//            this.menuDoneItem = menu.findItem(R.id.done);
//            if(this.originalPhotos != null && this.originalPhotos.size() > 0) {
//                this.menuDoneItem.setEnabled(true);
//                this.menuDoneItem.setTitle(this.getString(me.iwf.photopicker.R.string.__picker_done_with_count, new Object[]{Integer.valueOf(this.originalPhotos.size()), Integer.valueOf(this.maxCount)}));
//            } else {
//                this.menuDoneItem.setEnabled(false);
//            }
//
//            this.menuIsInflated = true;
//            return true;
//        }
//    }

//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(item.getItemId() == 16908332) {
//            super.onBackPressed();
//            return true;
//        } else if(item.getItemId() == me.iwf.photopicker.R.id.done) {
//            Intent intent = new Intent();
//            ArrayList selectedPhotos = this.pickerFragment.getPhotoGridAdapter().getSelectedPhotoPaths();
//            intent.putStringArrayListExtra("SELECTED_PHOTOS", selectedPhotos);
//            this.setResult(-1, intent);
//            this.finish();
//            return true;
//        } else {
//            return super.onOptionsItemSelected(item);
//        }
//   }

    public PhotoPickerActivity getActivity() {
        return this;
    }

    public boolean isShowGif() {
        return this.showGif;
    }

    public void setShowGif(boolean showGif) {
        this.showGif = showGif;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ib_ksxj_photo_back:
                finish();
                break;
            case R.id.btn_ksxj_photo_save:
                finish();
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}
