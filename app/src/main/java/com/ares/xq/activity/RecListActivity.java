package com.ares.xq.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ares.xq.R;
import com.ares.xq.adapter.DataAdapter;
import com.ares.xq.baselibrary.base.activity.AppActivity;
import com.ares.xq.baselibrary.base.adapter.OnItemClickListener;
import com.ares.xq.baselibrary.base.adapter.RecyclerHolder;
import com.ares.xq.baselibrary.base.adapter.RecyclerViewDivider;
import com.ares.xq.bean.ItemBean;

import java.util.ArrayList;
import java.util.List;


/**
 * 列表类
 */
public class RecListActivity extends AppActivity {


    private RecyclerView rvHorizontal;
    private RecyclerView rvVertical;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_rec_list;
    }

    @Override
    protected void initGui() {
        rvHorizontal = (RecyclerView) findViewById(R.id.rv_main_horizontal);
        rvVertical = (RecyclerView) findViewById(R.id.rv_main_vertical);
    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initData() {
        List<ItemBean> list = new ArrayList<>();
        ItemBean bean;
        for (int i = 0; i < 20; i++) {
            bean = new ItemBean();
            bean.setName("当前i="+i);
            list.add(bean);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvHorizontal.setLayoutManager(layoutManager);
        RecyclerViewDivider divder = new RecyclerViewDivider(false); // 创业分割，false为HORIZONTAL
        divder.setColor(0xff5ED0F2); // 分割线颜色
        divder.setMargin(this, 0, 15, 0, 15);  // 分割线边距
        divder.setDividerHeight(this, 1);// 分割线宽度
        rvHorizontal.addItemDecoration(divder);
        DataAdapter dataAdapter = new DataAdapter(this,list);
        rvHorizontal.setAdapter(dataAdapter);

        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvVertical.setLayoutManager(layoutManager);
        divder = new RecyclerViewDivider(true);// 创业分割，true为VERTICAL
        divder.setMargin(10, 10, 10, 10); // 分割线边距
        divder.setDividerHeight(50);// 分割线宽度 50要大于（10+10）
        // 分割线Drawable
        divder.setDrawable(ContextCompat.getDrawable(this, R.drawable.circle_bg));
        rvVertical.addItemDecoration(divder);
        DataAdapter dataAdapter1 = new DataAdapter(this,list);
        rvVertical.setAdapter(dataAdapter1);

        OnItemClickListener listener = new OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerHolder holder, int position) {
                Toast.makeText(RecListActivity.this, String.valueOf(position), Toast.LENGTH_LONG).show();
            }
        };
        // 设置监听
        dataAdapter.setOnItemClickListener(listener);
        dataAdapter1.setOnItemClickListener(listener);
    }
}
