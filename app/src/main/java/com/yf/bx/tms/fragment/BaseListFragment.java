package com.yf.bx.tms.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yf.bx.tms.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 列表基类
 * Created by 洋 on 2016/11/10.
 */

public abstract class BaseListFragment<T> extends CommonFra {

    public ListView onCreateListView() {
        return (ListView) getView().findViewById(R.id.listview);
    }

    public ListView mListView;
    public final List<T> mList = new ArrayList<>();
    ListViewAdapter mListViewAdapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListView = onCreateListView();
        if (mListView != null) {
            mListView.setAdapter(mListViewAdapter = new ListViewAdapter());
        }
    }

    /**
     * 增加单行
     *
     * @param t
     */
    public void addLine(T t) {
        mList.add(t);
        notifyDataSetChanged();
    }

    //增加指定的行数
    public void addLines(List<T> list) {
        mList.addAll(list);
        notifyDataSetChanged();
    }

    //增加指定的行数
    public void addLines(int lines, @NonNull ObjectCreator<T> creator) {
        for (int i = 0; i < lines; i++) {
            mList.add(creator.createObject(i));
        }
        notifyDataSetChanged();
    }

    /**
     * 返回每一行所在的view
     *
     * @param viewType
     * @param parent
     * @return
     */
    public abstract View getView(int viewType, ViewGroup parent);

    /**
     * 将object转换成view
     *
     * @param position
     * @param holder
     * @param t
     */
    public abstract void convertObject2View(int position, ViewHolder holder, T t);

    //封装ViewHolder
    public final View getConvertView(int position, View convertView, ViewGroup parent) {
        ViewHolder v;
        if (convertView == null) {
            convertView = getView(getItemViewType(position), parent);
            v = new ViewHolder(convertView);
            convertView.setTag(v);
        } else {
            v = (ViewHolder) convertView.getTag();
        }
        convertObject2View(position, v, mList.get(position));
        return convertView;
    }

    public int getCount() {
        return mList.size();
    }

    public int getViewTypeCount() {
        return 1;
    }

    public int getItemViewType(int position) {
        return 0;
    }

    public void notifyDataSetChanged() {
        mListViewAdapter.notifyDataSetChanged();
    }

    /**
     * 主要是提供添加行的Object
     *
     * @param <T>
     */
    public interface ObjectCreator<T> {
        T createObject(int position);
    }

    /**
     * 封装ViewHolder，类似RecyclerView
     */
    public static class ViewHolder {
        public View mItemView;
        SparseArray<View> mViews;

        public ViewHolder(View itemView) {
            mItemView = itemView;
            mViews = new SparseArray<>();
        }

        public <T extends View> T getView(int id) {
            View v = mViews.get(id);
            if (v == null) {
                v = mItemView.findViewById(id);
                mViews.put(id, v);
            }
            return (T) v;
        }

        public void setText(int textViewId, String text) {
            TextView tv = getView(textViewId);
            if (tv != null) {
                tv.setText(text);
            }
        }
    }

    class ListViewAdapter extends BaseAdapter {

        @Override
        public int getItemViewType(int position) {
            return BaseListFragment.this.getItemViewType(position);
        }

        @Override
        public int getViewTypeCount() {
            return BaseListFragment.this.getViewTypeCount();
        }

        @Override
        public int getCount() {
            return BaseListFragment.this.getCount();
        }

        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return BaseListFragment.this.getConvertView(position, convertView, parent);
        }
    }
}
