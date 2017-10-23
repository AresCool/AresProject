package com.ares.xq.baselibrary.base.adapter;

/**
 * @author：Ares
 * @time：2017/10/23 17:31
 * @className：com.ares.xq.baselibrary.base.adapter.OnItemClickListener
 * @desc:
 */
public interface OnItemClickListener {
    /**
     * @param holder 操作的ViewHolder
     * @param position 点击item的位置
     */
    void onItemClick(RecyclerHolder holder, int position);
}