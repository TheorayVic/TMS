package com.yf.bx.tms.photo_picker;

import android.app.Activity;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;


/**
 * Created by bai on 2016/11/13.
 */

public class PermissionsUtils {
    public PermissionsUtils() {
    }

    public static boolean checkReadStoragePermission(Activity activity) {
        if(Build.VERSION.SDK_INT < 16) {
            return true;
        } else {
            int readStoragePermissionState = ContextCompat.checkSelfPermission(activity, "android.permission.READ_EXTERNAL_STORAGE");
            boolean readStoragePermissionGranted = readStoragePermissionState == 0;
            if(!readStoragePermissionGranted) {
                ActivityCompat.requestPermissions(activity, PermissionsConstant.PERMISSIONS_EXTERNAL_READ, 2);
            }

            return readStoragePermissionGranted;
        }
    }

    public static boolean checkWriteStoragePermission(Fragment fragment) {
        int writeStoragePermissionState = ContextCompat.checkSelfPermission(fragment.getContext(), "android.permission.WRITE_EXTERNAL_STORAGE");
        boolean writeStoragePermissionGranted = writeStoragePermissionState == 0;
        if(!writeStoragePermissionGranted) {
            fragment.requestPermissions(PermissionsConstant.PERMISSIONS_EXTERNAL_WRITE, 3);
        }

        return writeStoragePermissionGranted;
    }

    public static boolean checkCameraPermission(Fragment fragment) {
        int cameraPermissionState = ContextCompat.checkSelfPermission(fragment.getContext(), "android.permission.CAMERA");
        boolean cameraPermissionGranted = cameraPermissionState == 0;
        if(!cameraPermissionGranted) {
            fragment.requestPermissions(PermissionsConstant.PERMISSIONS_CAMERA, 1);
        }

        return cameraPermissionGranted;
    }
}
