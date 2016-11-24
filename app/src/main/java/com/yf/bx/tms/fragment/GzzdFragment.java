package com.yf.bx.tms.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.text.style.ReplacementSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.yf.bx.tms.R;
import com.yf.bx.tms.activity.TxxjActivity;
import com.yf.bx.tms.adapter.GzzdAdapter;
import com.yf.bx.tms.bean.GzzdBean;
import com.yf.bx.tms.customview.CustomRoundProcessbar;
import com.yf.bx.tms.utils.DownloadFileUtils;
import com.yf.bx.tms.utils.OpenFileUtils;

import org.xutils.x;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**规章制度和标准规范
 * Created by 123 on 2016/11/7.
 */

public class GzzdFragment extends CommonFra {

    private final static String TAG ="GzzdFragment";
    private View view;
    private RadioButton tv_gzzd,tv_bzgf;
    private RadioGroup rg;
    private ImageButton ib_search;
    private SearchView searchView;
    private ListView lv;
    private List<GzzdBean> list_gzzd,list_bzgf;
    private GzzdAdapter gzzdAdapter;
    private int progress = 0;//下载进度
    private String src;
    private String floder;
    private OpenFileUtils openFileUtils;
    public GzzdFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_gzzd,null);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_gzzd = (RadioButton) view.findViewById(R.id.tv_gzzd);
        tv_bzgf = (RadioButton) view.findViewById(R.id.tv_bzgf);
        rg = (RadioGroup) view.findViewById(R.id.rg_gzzd);
        searchView = (SearchView) view.findViewById(R.id.searchview_gzzd);
        ib_search = (ImageButton) view.findViewById(R.id.ib_gzzd_search_inner);
        lv = (ListView) view.findViewById(R.id.lv_gzzd);
        list_gzzd = new ArrayList<>();
        list_bzgf = new ArrayList<>();
        GzzdBean gzzdBean1 = new GzzdBean();
        gzzdBean1.setIsGzzd("true");
        gzzdBean1.setFileName("国家电网公司机动应急通信系统管理细则");
        GzzdBean gzzdBean2 = new GzzdBean();
        gzzdBean2.setFileName("国家电网公司通信安全管理办法");
        GzzdBean gzzdBean3 = new GzzdBean();
        gzzdBean3.setFileName("国家电网公司通信检修管理办法");
        GzzdBean gzzdBean4 = new GzzdBean();
        gzzdBean4.setFileName("国家电网公司通信设备及资产管理细则");


        GzzdBean gzzdBean5 = new GzzdBean();
        gzzdBean5.setIsGzzd("false");
        gzzdBean5.setFileName("电力数字调度交换机测试方法");
        GzzdBean gzzdBean6 = new GzzdBean();
        gzzdBean6.setFileName("电力系统复用调制解调器600bits移频键控调制解调器技术要求");
        GzzdBean gzzdBean7 = new GzzdBean();
        gzzdBean7.setFileName("电力系统调度通信交换网设计技术规程");
        GzzdBean gzzdBean8 = new GzzdBean();
        gzzdBean8.setFileName("微波电路传输继电保护信息设计技术规定");

        list_gzzd.add(gzzdBean1);
        list_gzzd.add(gzzdBean2);
        list_gzzd.add(gzzdBean3);
        list_gzzd.add(gzzdBean4);

        list_bzgf.add(gzzdBean5);
        list_bzgf.add(gzzdBean6);
        list_bzgf.add(gzzdBean7);
        list_bzgf.add(gzzdBean8);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.tv_gzzd:
                        gzzdAdapter = new GzzdAdapter(getActivity(),list_gzzd);
                        break;
                    case R.id.tv_bzgf:
                        gzzdAdapter = new GzzdAdapter(getActivity(),list_bzgf);
                        break;
                }
                lv.setAdapter(gzzdAdapter);
            }
        });
        tv_gzzd.setChecked(true);

        openFileUtils = new OpenFileUtils(getActivity());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                      @Override
                                      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                          if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
                                              src = Environment.getExternalStorageDirectory()
                                                      .getAbsolutePath();
                                              String filename = gzzdAdapter.list.get(position).getFileName();
                                              Log.i(TAG, "onItemClick: filename:"+filename);
                                              floder = src+filename;
                                              // 这里区分本地是否存在
                                              if (isState(filename)) {
                                                  openFileUtils.openFile(new File(floder + filename));
                                              } else {
                                                  final CustomRoundProcessbar bar = ((GzzdAdapter.ViewHolderGzzd) (view.getTag())).bar;
                                                  File file = new File(floder);
                                                  if (!file.exists()) {
                                                      file.mkdirs();
                                                  }
                                                  bar.setVisibility(View.VISIBLE);
                                                  final String fileUrl = "";
                                                  final String address = "";
                                                  new Thread(new Runnable() {
                                                      @Override
                                                      public void run() {
                                                          DownloadFileUtils.downLoadFile(fileUrl, address, bar);
                                                      }
                                                  }).start();

                                              }
                                          } else {
                                              Toast.makeText(getActivity(), "请插入SD卡", Toast.LENGTH_SHORT).show();
                                              return;
                                          }
                                      }
                                  });
    }

    // 判断本地文件是否存在
    boolean isState(String filename){
        boolean isS = false;
        String filePath = floder + filename;
        File fileFile = new File(filePath);
        if (fileFile.exists()) {
            isS = true;
        }
        return isS;
    }

}