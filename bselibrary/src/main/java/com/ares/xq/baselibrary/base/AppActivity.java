package com.ares.xq.baselibrary.base;

import android.content.Intent;
import android.os.Bundle;

import com.ares.xq.baselibrary.utils.AppManager;

/**
 * Created by yinyinchuan on 2017/9/24.
 */

public abstract class AppActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getContentViewId()>0)
            setContentView(getContentViewId());
        getContentViewId();
        initGui();
        initAction();
        initData();

    }

}
