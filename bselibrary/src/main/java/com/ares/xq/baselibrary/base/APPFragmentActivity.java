package com.ares.xq.baselibrary.base;

import android.content.Intent;
import android.os.Bundle;

import com.ares.xq.baselibrary.utils.AppManager;

/**
 * Created by yinyinchuan on 2017/9/24.
 */

public  abstract  class APPFragmentActivity extends  BaseActivity{


    //获取第一个fragment
    protected abstract BaseFragment getFirstFragment();

    //获取Intent
    protected void handleIntent(Intent intent) {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getContentViewId()>0)
            setContentView(getContentViewId());
        if (null != getIntent()) {
            handleIntent(getIntent());
        }
        //避免重复添加Fragment
        if (null == getSupportFragmentManager().getFragments()) {
            BaseFragment firstFragment = getFirstFragment();
            if (null != firstFragment) {
                addFragment(firstFragment);
            }
        }
        initGui();
        initAction();
        initData();
    }
}
