package com.ares.xq.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ares.xq.R;


/**
 * 主页适配器
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {


    private String[] itemList = null;

    private Context mContext;

    private MainAdapterListener mMainAdapterListener;

    public MainAdapter(String[] itemList,Context context){
        this.itemList = itemList;
        this.mContext = context;
    }



    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainViewHolder holder = new MainViewHolder(LayoutInflater.from(
                mContext).inflate(R.layout.adapter_main, parent,
                false));
        return holder;

    }

    @Override
    public void onBindViewHolder(MainViewHolder holder,final int position) {
        holder.tvTitle.setText(itemList[position]);
        holder.itemRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mMainAdapterListener!=null){
                    mMainAdapterListener.onMainItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return (itemList!=null && itemList.length>0)?itemList.length:0;
    }

    public void setMainAdapterListener(MainAdapterListener mainAdapterListener) {
        this.mMainAdapterListener = mainAdapterListener;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;

        LinearLayout itemRootView;

        public MainViewHolder(View view){
            super(view);
            this.tvTitle = (TextView) view.findViewById(R.id.textView);
            this.itemRootView = (LinearLayout) view.findViewById(R.id.ll_main_item_rootView);
        }
    }

    public interface  MainAdapterListener{
        void onMainItemClick(int position);
    }

}
