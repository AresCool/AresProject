package com.ares.xq.baselibrary.base.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author：Ares
 * @time：2017/10/23 17:24
 * @className：com.ares.xq.baselibrary.base.adapter.RecyclerAdatper
 * @desc:
 */
public abstract class RecyclerAdatper<T> extends RecyclerView.Adapter<RecyclerHolder> {

    private Context mContext;
    private List<T> mList;
    private OnItemClickListener mOnItemClickListener;

    public RecyclerAdatper(Context context) {
        this(context, new ArrayList<T>());
    }

    public RecyclerAdatper(Context context, List<T> list) {
        mContext = context;
        mList = list;
    }

    public Context getContext() {
        return mContext;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new RecyclerHolder(getLayoutInflater().inflate(getContentView(viewType), parent,
                false));
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onBindViewHolder(final RecyclerHolder holder, final int position) {
        onInitView(holder, getItem(position), position);
        if (null != mOnItemClickListener) { // 实现item点击事件回调
            holder.getView().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder, position);
                }
            });
        }
    }


    @Override
    public int getItemCount() {
        if (null != mList) {
            return mList.size();
        }
        return 0;
    }

    //---------------------------------abstract--------------------------------

    /**
     * item布局ID
     *
     * @param viewType 类别
     * @return item布局ID
     */
    public abstract int getContentView(int viewType);

    /**
     * item刷新的回调
     *
     * @param holder   ViewHolder
     * @param object   Item数据对象
     * @param position 刷新的位置
     */
    public abstract void onInitView(RecyclerHolder holder, T object, int position);


    //---------------------------------List--------------------------------
    public List<T> getList() {
        return mList;
    }

    public void setList(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public void clear() {
        this.mList.clear();
        notifyDataSetChanged();
    }

    public void remove(int location) {
        if (location >= 0 && mList.size() > location) {
            this.mList.remove(location);
            notifyDataSetChanged();
        }
    }

    public void add(int location, T object) {
        if (object != null) {
            this.mList.add(location, object);
            notifyDataSetChanged();
        }
    }

    public void addLast(T object) {
        if (object != null) {
            this.mList.add(object);
            notifyDataSetChanged();
        }
    }

    public void addHead(T object) {
        if (object != null) {
            this.mList.add(0, object);
            notifyDataSetChanged();
        }
    }

    public void addAll(List<T> list) {
        if (list != null) {
            this.mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    public T getItem(int position) {
        return mList.get(position);
    }


    //---------------------------------other--------------------------------
    protected LayoutInflater getLayoutInflater() {
        return (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    protected int getColor(int id) {
        return ContextCompat.getColor(getContext(), id);
    }

    protected String getString(int id) {
        return getContext().getResources().getString(id);
    }

    protected float getDimension(int id) {
        return getContext().getResources().getDimension(id);
    }

    protected Drawable getDrawable(int id) {
        return ContextCompat.getDrawable(getContext(), id);
    }

}


