package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.yf.bx.tms.R;

/**用户评价的评价页面
 * Created by 123 on 2016/11/2.
 */

public class PjYhpjFragment extends Fragment {
    private final static String TAG = "PjYhpjFragment";
    private View view;
    private EditText et_gdbh,et_wtms,et_pj;
    private LinearLayout ll_commit;
    private RatingBar rb_xysj,rb_fwtd,rb_cljg;
    private OnAddClick onAddClick;

    public PjYhpjFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pjyhpj,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        et_gdbh = (EditText) view.findViewById(R.id.tv_pjyhpj_gdbh);
        et_wtms = (EditText) view.findViewById(R.id.tv_pjyhpj_wtms);
        et_pj = (EditText) view.findViewById(R.id.tv_pjyhpj_pj12);
        rb_xysj = (RatingBar) view.findViewById(R.id.ratingbar_pjyhpj_xysj);
        rb_fwtd = (RatingBar) view.findViewById(R.id.ratingbar_pjyhpj_fwtd);
        rb_cljg = (RatingBar) view.findViewById(R.id.ratingbar_pjyhpj_cljg);
        ll_commit = (LinearLayout) view.findViewById(R.id.ll_pjyhpj_pj_commit);
        //rb_xysj.getRating() :返回星星的个数

        ll_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null!=onAddClick){
                    //带数据进入
                    onAddClick.onClick(ll_commit);
                }
            }
        });
    }


    //定义接口变量的get方法
    public OnAddClick getOnButtonClick() {
        return onAddClick;
    }
    //定义接口变量的set方法
    public void setOnButtonClick(OnAddClick onButtonClick) {
        this.onAddClick = onButtonClick;
    }
    //1、定义接口
    public interface OnAddClick{
        void onClick(View view);
    }
}
