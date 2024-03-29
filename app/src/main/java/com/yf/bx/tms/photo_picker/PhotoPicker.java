package com.yf.bx.tms.photo_picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import java.util.ArrayList;

/**
 * Created by bai on 2016/11/13.
 */

public class PhotoPicker {
    public static final int REQUEST_CODE = 233;
    public static final int DEFAULT_MAX_COUNT = 9;
    public static final int DEFAULT_COLUMN_NUMBER = 4;
    public static final String KEY_SELECTED_PHOTOS = "SELECTED_PHOTOS";
    public static final String EXTRA_MAX_COUNT = "MAX_COUNT";
    public static final String EXTRA_SHOW_CAMERA = "SHOW_CAMERA";
    public static final String EXTRA_SHOW_GIF = "SHOW_GIF";
    public static final String EXTRA_GRID_COLUMN = "column";
    public static final String EXTRA_ORIGINAL_PHOTOS = "ORIGINAL_PHOTOS";
    public static final String EXTRA_PREVIEW_ENABLED = "PREVIEW_ENABLED";

    public PhotoPicker() {
    }

    public static PhotoPicker.PhotoPickerBuilder builder() {
        return new PhotoPicker.PhotoPickerBuilder();
    }

    public static class PhotoPickerBuilder {
        private Bundle mPickerOptionsBundle = new Bundle();
        private Intent mPickerIntent = new Intent();

        public PhotoPickerBuilder() {
        }

        public void start(@NonNull Activity activity, int requestCode) {
            if(PermissionsUtils.checkReadStoragePermission(activity)) {
                activity.startActivityForResult(this.getIntent(activity), requestCode);
            }

        }

        public void start(@NonNull Context context, @NonNull Fragment fragment, int requestCode) {
            if(PermissionsUtils.checkReadStoragePermission(fragment.getActivity())) {
                fragment.startActivityForResult(this.getIntent(context), requestCode);
            }

        }

        public void start(@NonNull Context context, @NonNull Fragment fragment) {
            if(PermissionsUtils.checkReadStoragePermission(fragment.getActivity())) {
                fragment.startActivityForResult(this.getIntent(context), 233);
            }

        }

        public Intent getIntent(@NonNull Context context) {
            this.mPickerIntent.setClass(context, PhotoPickerActivity.class);
            this.mPickerIntent.putExtras(this.mPickerOptionsBundle);
            return this.mPickerIntent;
        }

        public void start(@NonNull Activity activity) {
            this.start(activity, 233);
        }

        public PhotoPicker.PhotoPickerBuilder setPhotoCount(int photoCount) {
            this.mPickerOptionsBundle.putInt("MAX_COUNT", photoCount);
            return this;
        }

        public PhotoPicker.PhotoPickerBuilder setGridColumnCount(int columnCount) {
            this.mPickerOptionsBundle.putInt("column", columnCount);
            return this;
        }

        public PhotoPicker.PhotoPickerBuilder setShowGif(boolean showGif) {
            this.mPickerOptionsBundle.putBoolean("SHOW_GIF", showGif);
            return this;
        }

        public PhotoPicker.PhotoPickerBuilder setShowCamera(boolean showCamera) {
            this.mPickerOptionsBundle.putBoolean("SHOW_CAMERA", showCamera);
            return this;
        }

        public PhotoPicker.PhotoPickerBuilder setSelected(ArrayList<String> imagesUri) {
            this.mPickerOptionsBundle.putStringArrayList("ORIGINAL_PHOTOS", imagesUri);
            return this;
        }

        public PhotoPickerBuilder setPreviewEnabled(boolean previewEnabled) {
            this.mPickerOptionsBundle.putBoolean("PREVIEW_ENABLED", previewEnabled);
            return this;
        }
    }
}
