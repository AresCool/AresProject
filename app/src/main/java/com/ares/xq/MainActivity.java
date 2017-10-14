package com.ares.xq;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ares.xq.activity.TouchActivity;
import com.ares.xq.adapter.MainAdapter;
import com.ares.xq.baselibrary.base.AppActivity;

/**
 * @author hades
 * @描述：
 * @Time 2017/9/24 下午4:05
 * @CLASSNAME MainActivity
 */
public class MainActivity extends AppActivity implements MainAdapter.MainAdapterListener {

    private String[] itemList = null;

    private RecyclerView recylerView;

    private MainAdapter mAdapter;


    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }


    @Override
    protected void initGui() {
        recylerView = (RecyclerView) findViewById(R.id.recylerView);
    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initData() {
        itemList = getResources().getStringArray(R.array.itemName);
        if (itemList != null && itemList.length > 0) {
            mAdapter = new MainAdapter(itemList, this);
            recylerView.setLayoutManager(new LinearLayoutManager(this));
            recylerView.setAdapter(mAdapter);
            mAdapter.setMainAdapterListener(this);
        }
    }


    @Override
    public void onMainItemClick(int position) {
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent.setClass(this,TouchActivity.class);
                break;
            default:
                break;
        }
        startActivity(intent);
    }
}
