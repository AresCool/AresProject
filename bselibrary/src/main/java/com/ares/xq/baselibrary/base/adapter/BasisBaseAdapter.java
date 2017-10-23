package com.ares.xq.baselibrary.base.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by lenovo on 2017/6/17.
 * 通用适配器
 */

public abstract class BasisBaseAdapter<T, H extends BasisBaseViewHolder> extends BaseAdapter {
    private Context mContext;
    /**
     * 用来存储adapter数据的List
     */
    protected List<T> mList;
    public BasisBaseAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mList = list;
    }
    public void setData(List<T> list) {
        mList = list;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mList.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup group) {
        if (convertView == null) {
            convertView = ViewHolder().viewInflate(mContext, group, false);
        }
        H h = (H) convertView.getTag();
        initItemData(position, h, convertView);
        return convertView;
    }
    /**
     * 返回ViewHolder子视图的抽象方法，在getView中调用，然后在子类中具体实现
     * @return 返回ViewHolder
     */
    protected abstract H ViewHolder();
    /**
     * 设置Item中的数据，抽象的方法，在getView中调调用，然后在子类中初始化
     * @param position
     *            itemview的索引
     * @param holder
     *            实现的ViewHolder子类
     * @param root
     *            itemview 的子视图
     */
    protected abstract void initItemData(int position, H holder, View root);
}
