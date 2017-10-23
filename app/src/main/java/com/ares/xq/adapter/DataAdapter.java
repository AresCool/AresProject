package com.ares.xq.adapter;

import android.content.Context;

import com.ares.xq.R;
import com.ares.xq.baselibrary.base.adapter.RecyclerAdatper;
import com.ares.xq.baselibrary.base.adapter.RecyclerHolder;
import com.ares.xq.bean.ItemBean;

import java.util.List;

/**
 * @author：Ares
 * @time：2017/10/23 17:38
 * @className：com.ares.xq.adapter.DataAdapter
 * @desc:
 */
public class DataAdapter extends RecyclerAdatper<ItemBean> {

    public DataAdapter(Context context, List<ItemBean> list) {
        super(context, list);
    }

    @Override
    public int getContentView(int viewType) {
        return R.layout.item_main_data;
    }

    @Override
    public void onInitView(RecyclerHolder holder, ItemBean object, int position) {
        holder.setText(R.id.tv_item_main_name, object.getName());
    }
}