package com.yf.bx.tms.adapter;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
/**
 * Created by 123 on 2016/10/26.
 */

public class XxbgFramentPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public XxbgFramentPagerAdapter(android.support.v4.app.FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
