package com.yf.bx.tms.fragment.xjyw_wwyt;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yf.bx.tms.R;

/**五位一体 流程
 * Created by 123 on 2016/11/10.
 */

public class LcFragment extends Fragment {
    private View view;
    private ImageView iv1,iv2;
    public LcFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lc,null);
        iv1 = (ImageView) view.findViewById(R.id.iv_xjyw_wwyt_lc1);
        iv2 = (ImageView) view.findViewById(R.id.iv_xjyw_wwyt_lc2);
        Bundle bundle = getArguments();
        if (null!=bundle){
            int currentItem = bundle.getInt("currentItem");
            switch (currentItem){
                case 0:
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_jfhj1));
                    iv2.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_jfhj2));
                    break;
                case 1:
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_txdy11));
                    iv2.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_txdy12));
                    break;
                case 2:
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_txdy21));
                    iv2.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_txdy22));
                    break;
                case 3:
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_cssb1));
                    iv2.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_cssb2));
                    break;
                case 4:
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_jhsb1));
                    iv2.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_jhsb2));
                    break;
                case 5:
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_pxsb1));
                    iv2.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_pxsb2));
                    break;
                case 6:
                    iv1.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_mxjgl1));
                    iv2.setImageDrawable(getResources().getDrawable(R.drawable.wwyt_mxjgl2));
                    break;
            }
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
