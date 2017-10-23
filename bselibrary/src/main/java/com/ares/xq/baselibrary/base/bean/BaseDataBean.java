package com.ares.xq.baselibrary.base.bean;

/**
 * @author：Ares
 * @time：2017/10/23 16:53
 * @className：com.ares.xq.baselibrary.base.bean.BaseDataBean
 * @desc:
 */
public abstract class BaseDataBean<T> extends BaseBean{

    protected T data;

    public String msg;

    private int code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}