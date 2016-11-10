package com.yf.bx.tms.view;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.yf.bx.tms.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 洋 on 2016/11/9.
 */

public class ZengjiaJianShaoGridView extends GridView {
    private final List<GridItem> mList = new ArrayList<>();

    public ZengjiaJianShaoGridView(Context context) {
        super(context);
    }

    public ZengjiaJianShaoGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ZengjiaJianShaoGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public ZengjiaJianShaoGridView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }

    public void setList(List<? extends GridItem> list) {
        mList.clear();
        mList.addAll(list);
        setNumColumns(3);
        GridAdapter gridAdapter = new GridAdapter();
        setAdapter(gridAdapter);
    }

    public class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder = null;
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.view_add_minuse,
                        parent, false);
                viewHolder = new ViewHolder();
                ButterKnife.bind(viewHolder, convertView);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            final ViewHolder vh = viewHolder;
            final GridItem gridItem = mList.get(position);
            viewHolder.title.setText(gridItem.getTitle());
            viewHolder.count.setText(gridItem.getDefaultCount() + "");
            viewHolder.add.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = gridItem.getCount();
                    if (count >= gridItem.getMax()) {
                        return;
                    }
                    count++;
                    gridItem.setCount(count);
                    vh.count.setText(count + "");
                }
            });
            viewHolder.minus.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    int count = gridItem.getCount();
                    if (count <= gridItem.getMin()) {
                        return;
                    }
                    count--;
                    gridItem.setCount(count);
                    vh.count.setText(count + "");
                }
            });
            return convertView;
        }
    }

    public static class ViewHolder {
        @Bind(R.id.title)
        TextView title;
        @Bind(R.id.add)
        TextView add;
        @Bind(R.id.minus)
        TextView minus;
        @Bind(R.id.count)
        TextView count;
    }

    public interface GridItem {
        String getId();//获取id

        int getDefaultCount();//默认数量

        String getTitle();//标题

        void setCount(int count);//设置数量

        int getCount();//获取数量

        int getMax();//最大值

        int getMin();//最小值
    }
}
