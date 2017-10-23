package com.ares.xq.baselibrary.base.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lenovo on 2017/6/16.
 * 通用viewholder
 */

public abstract class BasisBaseViewHolder {
    private Context mContext;
    /**
     * 当前项的view
     */
    private View mItemView;
    /**
     * 用来零时存储ViewHolder的子View和初始化它们
     */
    private BasisViewHolderHelper mHolderHelper;
    /**
     * 用来加载ViewHolder的视图View，根据layoutId
     */
    public View viewInflate(Context context, ViewGroup parent, boolean attachToRoot) {
        mContext = context;
        mItemView = LayoutInflater.from(mContext).inflate(getItemLayout(), parent, attachToRoot);
        mItemView.setTag(this);
        mHolderHelper = new BasisViewHolderHelper(mItemView);
        initItemView();
        return mItemView;
    }

    /**
     * 根据layoutI找到ItemView,这个工作只在这里声明，然后在viewInflaite里面调用，具体的实现工作交给子类去完成
     *
     * @return  发挥当前ViewHolder所需的布局或者是视图
     */
    public abstract int getItemLayout();
    /**
     * 初始化item的子View
     */
    public abstract void  initItemView();
    /**
     * 初始化View根据layoutId
     * @param layoutId  需要初始化的View的id
     * @return
     */
    public <T extends View> T findViewById(int layoutId) {
        return mHolderHelper.findViewById(layoutId);
    }

    private class BasisViewHolderHelper {
        /**
         * 用来装ViewHolder的View的容器
         */
        private SparseArray<View> mViewArray = new SparseArray<View>();
        /**
         * ViewHolder的布局
         */
        private View mConvertView;

        public BasisViewHolderHelper(View view) {
            mConvertView = view;
        }

        public View getView() {
            return mConvertView;
        }

        /**
         * 从SparseArray找出子View根据id
         *
         * @param layoutId 返回itemview中子控件时所需的layoutid
         * @return
         */
        public <T extends View> T findViewById(int layoutId) {
            View view = mViewArray.get(layoutId);
            if (view == null) {
                view = mConvertView.findViewById(layoutId);
                if (view != null) {
                    mViewArray.put(layoutId, view);
                }
            }
            return view == null ? null : (T) view;
        }
    }
}