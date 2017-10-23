package com.ares.xq.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.ares.xq.R;
import com.ares.xq.baselibrary.utils.bit.ImageUtils;

public class GlideActivity extends AppCompatActivity {

    private ImageView iv_glide,iv_gif;
    private String url = "http://img1.zfwimg.com/display/d00163e873fd58532ca85427ff6fd00d.jpg";
    private String gofPath = "file:///android_asset/leida.gif";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        iv_glide = findViewById(R.id.iv_glide);
        iv_gif = findViewById(R.id.iv_gif);
        ImageUtils.showImageView(this, url, R.mipmap.ic_launcher, iv_glide);
        ImageUtils.showImageView(this, gofPath,iv_gif);
    }
}
