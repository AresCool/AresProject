/*
 * @Title CommonAdapter.java
 * @Copyright Copyright 2010-2015 Yann Software Co,.Ltd All Rights Reserved.
 * @Description��
 * @author Yann
 * @date 2015-8-5 ����10:39:05
 * @version 1.0
 */
package com.ares.xq.baselibrary.base.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.Collections;
import java.util.List;

/**
 * @param <T>
 * @author Ares
 * @ClassName: CommonAdapter
 * @Description: 通用Adapter 类
 * @date 2017-4-25 下午3:58:38
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;

    public CommonAdapter(Context context, List<T> datas) {
        this.mContext = context;
        this.mDatas = datas;
        mInflater = LayoutInflater.from(context);
    }

    public abstract int getLayoutRes();

    /**
     * @see android.widget.Adapter#getCount()
     */
    @Override
    public int getCount() {
        if (mDatas == null || mDatas.size() <= 0) {
            return 0;
        }
        return mDatas.size();
    }

    /**
     * @see android.widget.Adapter#getItem(int)
     */
    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    public List<T> getListData() {
        if (this.mDatas == null)
            return Collections.emptyList();
        return this.mDatas;
    }

    /**
     * @param @param listData 设定文件
     * @return void 返回类型
     * @throws
     * @Title: initListData
     * @Description: 初始化list集合数据
     */
    public void initListData(List<T> listData) {
        mDatas.clear();
        mDatas.addAll(listData);
        this.notifyDataSetChanged();
    }

    /**
     * @param @param listData 设定文件
     * @return void 返回类型
     * @throws
     * @Title: addListData
     * @Description: 添加数据
     */
    public void addListData(List<T> listData) {
        mDatas.addAll(listData);
        this.notifyDataSetChanged();
    }

    /**
     * @see android.widget.Adapter#getItemId(int)
     */
    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getLayoutRes() > 0) {
            ViewHolder holder = ViewHolder.get(mContext, convertView, parent,
                    getLayoutRes(), position);
            convert(holder, getItem(position), position);

            return holder.getConvertView();
        } else {
            return convertView;
        }
    }

    public abstract void convert(ViewHolder holder, T t, int position);
}
