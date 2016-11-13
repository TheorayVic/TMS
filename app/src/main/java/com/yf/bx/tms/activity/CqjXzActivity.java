package com.yf.bx.tms.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.fragment.CqjywFragment;
import com.yf.bx.tms.fragment.cqjxz.ZnglFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * 新增春秋检
 */
public class CqjXzActivity extends BaseActivity {

    private static final String TAG = "Cqj";
    @Bind(R.id.viewPager)
    ViewPager mViewPager;
    private List<CqjywFragment.CQJItem> mCQJItemList = new ArrayList<>();
    @Bind(R.id.scroll)
    HorizontalScrollView mHorizontalScrollView;
    ViewGroup viewGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cqj_xz);
        viewGroup = (ViewGroup) findViewById(R.id.radio_button_area);
        List<CqjywFragment.CQJItem> list = CqjywFragment.list;
        for (int i = 0; i < list.size(); i++) {
            int size = list.get(i).getCount();
            for (int j = 0; j < size; j++) {
                View view = getLayoutInflater().inflate(R.layout.view_select, viewGroup, false);
                TextView title = (TextView) view.findViewById(R.id.title);
                title.setText(list.get(i).getTitle());
                viewGroup.addView(view);
                ImageView imageView = (ImageView) view.findViewById(R.id.icon);
                if (mCQJItemList.isEmpty()) {
                    imageView.setVisibility(View.VISIBLE);
                }
                try {
                    mCQJItemList.add((CqjywFragment.CQJItem) list.get(i).clone());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
                final int h  =mCQJItemList.size()-1;
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(h);
                    }
                });
            }
        }
        mViewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mHorizontalScrollView.scrollTo((int) viewGroup.getChildAt(position).getX(),
                        (int) viewGroup.getChildAt(position).getY());
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    if (position == i) {
                        viewGroup.getChildAt(i).findViewById(R.id.icon).setVisibility
                                (View.VISIBLE);
                    } else {
                        viewGroup.getChildAt(i).findViewById(R.id.icon).setVisibility
                                (View.INVISIBLE);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new ZnglFragment();
        }

        @Override
        public int getCount() {
            return mCQJItemList.size();
        }
    }
}
