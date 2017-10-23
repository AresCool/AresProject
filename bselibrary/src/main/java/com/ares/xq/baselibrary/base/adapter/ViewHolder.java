package com.ares.xq.baselibrary.base.adapter;

import android.content.Context;
import android.text.Spanned;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * @author Ares
 * @ClassName: ViewHolder
 * @Description: 通用ViewHolder
 * @date 2017-4-25 下午3:59:14
 */
public class ViewHolder {
    private SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;
    private Context context;

    public View getConvertView() {
        return mConvertView;
    }

    public ViewHolder(Context context, ViewGroup parent, int layoutId,
                      int position) {
        this.mViews = new SparseArray<View>();
        this.mPosition = position;
        this.context = context;
        this.mConvertView = LayoutInflater.from(context).inflate(layoutId,
                parent, false);
        this.mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (null == convertView) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;

            return holder;
        }
    }

    /**
     * @param @param  viewId
     * @param @return
     * @return T
     * @throws
     * @Title: getView
     * @Description: 通过viewId获取控件
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);

        if (null == view) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }

        return (T) view;
    }


    /**
     * 给ID为viewId的TextView设置文字text，并返回this
     *
     * @param viewId
     * @param text
     * @return ViewHolder
     * @author Yann
     * @date 2015-8-5 11:05:17
     */
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);

        return this;
    }

    public ViewHolder setText(int viewId, Spanned fromHtml) {
        TextView tv = getView(viewId);
        tv.setText(fromHtml);
        return this;
    }
}
