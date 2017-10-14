package com.ares.xq.baselibrary.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;

import com.ares.xq.baselibrary.utils.AppManager;

/**
 * @author hades
 * @描述：基础类activity
 * @Time 2017/9/24 上午11:39
 * @CLASSNAME BaseActivity
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
    }


    //activity布局
    protected abstract int getContentViewId();

    protected abstract void initGui();

    protected abstract void initAction();

    protected abstract void initData();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().popActivity(this);
    }
}
