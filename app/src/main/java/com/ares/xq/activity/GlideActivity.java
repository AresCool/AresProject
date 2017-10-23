package com.ares.xq.activity;

import android.widget.ImageView;

import com.ares.xq.R;
import com.ares.xq.baselibrary.base.activity.AppActivity;
import com.ares.xq.baselibrary.utils.bit.ImageUtils;

public class GlideActivity extends AppActivity {

    private ImageView iv_glide,iv_gif;
    private String url = "http://img1.zfwimg.com/display/d00163e873fd58532ca85427ff6fd00d.jpg";
    private String gofPath = "file:///android_asset/leida.gif";

    @Override
    protected int getContentViewId() {
        return R.layout.activity_glide;
    }

    @Override
    protected void initGui() {

    }

    @Override
    protected void initAction() {

    }

    @Override
    protected void initData() {
        iv_glide = findViewById(R.id.iv_glide);
        iv_gif = findViewById(R.id.iv_gif);
        ImageUtils.showImageView(this, url, R.mipmap.ic_launcher, iv_glide);
        ImageUtils.showImageView(this, gofPath,iv_gif);
    }
}
