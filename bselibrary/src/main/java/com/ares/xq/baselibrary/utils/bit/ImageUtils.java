package com.ares.xq.baselibrary.utils.bit;

import android.content.Context;
import android.widget.ImageView;

import com.ares.xq.baselibrary.GlideApp;
import com.bumptech.glide.Priority;

/**
 * @author：Ares
 * @time：2017/10/23 14:54
 * @className：com.ares.xq.baselibrary.utils.bit.ImageUtils
 * @desc: glide 图片加载
 */
public class ImageUtils {


    /**
     * 显示图片Imageview
     *
     * @param context     上下文
     * @param placeholder 占位图
     * @param url         图片链接
     * @param imageView   组件
     */
    public static void showImageView(Context context, String url, int placeholder, ImageView imageView) {
        GlideApp.with(context).load(url).placeholder(placeholder).thumbnail(1.0f).priority(Priority.HIGH).into(imageView);

    }

    /**
     * 显示图片Imageview
     *
     * @param context     上下文
     * @param placeholder 占位图
     * @param error       错误图
     * @param url         图片链接
     * @param imageView   组件
     */
    public static void showImageView(Context context, String url, int placeholder, int error, ImageView imageView) {
        GlideApp
                .with(context)
                .load(url)
                .error(error)
                .placeholder(placeholder)
                .into(imageView);

    }

    public static void showImageView(Context context, String url, ImageView imageView) {
        GlideApp
                .with(context).load(url).thumbnail(1.0f)
                .into(imageView);

    }

}