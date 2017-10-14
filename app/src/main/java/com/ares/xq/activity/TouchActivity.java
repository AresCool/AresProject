package com.ares.xq.activity;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ares.xq.R;
import com.ares.xq.adapter.MessageListAdapter;
import com.ares.xq.baselibrary.base.AppActivity;
import com.ares.xq.itemtouchlibrary.ItemTouchHelper;
import com.ares.xq.itemtouchlibrary.ItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/14.
 */

public class TouchActivity extends AppActivity{

    @Override
    protected int getContentViewId() {
        return R.layout.activity_touch;
    }

    @Override
    protected void initGui() {

    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initData() {
        RecyclerView recyler = (RecyclerView) findViewById(R.id.recylerView_touch);
        List<String> list = initList();
        MessageListAdapter adapter = new MessageListAdapter(this, list);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        recyler.addItemDecoration(new DividerItemDecoration(this,1));
        recyler.setAdapter(adapter);

        ItemTouchHelperCallback callback = new ItemTouchHelperCallback(ItemTouchHelperCallback.DRAG_FLAGS_VERTICAL,adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyler);
    }

    private List<String> initList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("itemtouchhelper_" + i);
        }
        return list;
    }
}
