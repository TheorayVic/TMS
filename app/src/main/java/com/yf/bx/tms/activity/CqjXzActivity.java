package com.yf.bx.tms.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.yf.bx.tms.R;
import com.yf.bx.tms.fragment.CqjywFragment;
import com.yf.bx.tms.fragment.cqjxz.ADSSGuangLanFragment;
import com.yf.bx.tms.fragment.cqjxz.BeiYongQianXinFragment;
import com.yf.bx.tms.fragment.cqjxz.GuangChuanShuFragment;
import com.yf.bx.tms.fragment.cqjxz.JiaoHuanSheBeiFragment;
import com.yf.bx.tms.fragment.cqjxz.OPGLGuangLan;
import com.yf.bx.tms.fragment.cqjxz.PTGuangLanFragment;
import com.yf.bx.tms.fragment.cqjxz.ShuJuWangSheBeiFragment;
import com.yf.bx.tms.fragment.cqjxz.TongBuSheBeiFragment;
import com.yf.bx.tms.fragment.cqjxz.TongXinDianYuanXiTongFragment;
import com.yf.bx.tms.fragment.cqjxz.TongXinFangShiFragment;
import com.yf.bx.tms.fragment.cqjxz.TongXinXuDianChiFragment;
import com.yf.bx.tms.fragment.cqjxz.WangGuanXiTongFragment;
import com.yf.bx.tms.fragment.cqjxz.WeiBoSheBeiFragment;
import com.yf.bx.tms.fragment.cqjxz.ZnglFragment;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

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
        TextView textView = (TextView) findViewById(R.id.tv_txxj_top);
        textView.setText("通信站");
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
                final int h = mCQJItemList.size() - 1;
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

    @OnClick({R.id.ib_ksxj_wwyt,R.id.ib_txxj_back})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ib_ksxj_wwyt:
                Intent intent = new Intent(this, XjywWwytActivity.class);
                startActivity(intent);
                break;
            case R.id.ib_txxj_back:
                finish();
                break;
        }
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            CqjywFragment.CQJItem cqjItem = mCQJItemList.get(position);
            switch (cqjItem.getId()) {
//                case 0:
//                    return  new Tong
                case "1":
                    return new ZnglFragment();
                case "2":
                    return new ADSSGuangLanFragment();
                case "3":
                    return new OPGLGuangLan();
                case "4":
                    return new PTGuangLanFragment();
                case "5":
                    return new BeiYongQianXinFragment();
                case "6":
                    return new TongXinDianYuanXiTongFragment();
                case "7":
                    return new TongXinXuDianChiFragment();
                case "8":
                    return new WeiBoSheBeiFragment();
                case "9":
                    return new GuangChuanShuFragment();
                case "10":
                    return new JiaoHuanSheBeiFragment();
                case "11":
                    return new ShuJuWangSheBeiFragment();
                case "12":
                    return new TongBuSheBeiFragment();
                case "13":
                    return new WangGuanXiTongFragment();
                case "14":
                    return new TongXinFangShiFragment();
            }
            return new ZnglFragment();
        }

        @Override
        public int getCount() {
            return mCQJItemList.size();
        }
    }
}
