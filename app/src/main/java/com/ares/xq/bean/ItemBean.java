package com.ares.xq.bean;


import com.ares.xq.baselibrary.base.bean.BaseDataBean;

/**
 * @author：Ares
 * @time：2017/10/23 17:02
 * @className：com.ares.xq.bean.ItemBean
 * @desc:
 */
public class ItemBean extends BaseDataBean<ItemBean> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}