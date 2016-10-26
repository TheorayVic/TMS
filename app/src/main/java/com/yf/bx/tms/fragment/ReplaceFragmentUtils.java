package com.yf.bx.tms.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * 切换fragment
 * Created by 123 on 2016/10/26.
 */

public class ReplaceFragmentUtils {

    public static void replaceFragmentUtil(FragmentActivity activity, Fragment fragment, boolean popBackStack, int layoutFragment) {
        if(popBackStack)
            activity.getFragmentManager().popBackStack();

        FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager()
                .beginTransaction();
        fragmentTransaction.replace(layoutFragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
