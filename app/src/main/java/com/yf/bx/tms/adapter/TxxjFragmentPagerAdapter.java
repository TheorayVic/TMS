package com.yf.bx.tms.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 123 on 2016/11/7.
 */

public class TxxjFragmentPagerAdapter extends FragmentPagerAdapter {

    private final static String TAG = "TxxjFragmentPagerAdapter";
    private List<Fragment> fragments;

    public TxxjFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
        //防止来回切换时销毁 造成空白页面
    }

    @Override
    public Fragment getItem(int position) {
        Log.i(TAG, "getItem,position:"+position);
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
