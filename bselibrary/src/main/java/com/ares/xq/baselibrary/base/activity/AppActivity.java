package com.ares.xq.baselibrary.base.activity;

import android.os.Bundle;

/**
 * Created by yinyinchuan on 2017/9/24.
 */

public abstract class AppActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getContentViewId() > 0)
            setContentView(getContentViewId());
        initGui();
        initAction();
        initData();

    }

}
