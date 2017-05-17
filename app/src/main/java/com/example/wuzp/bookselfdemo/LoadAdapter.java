package com.example.wuzp.bookselfdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;

/**
 * Created by wuzp on 2017/5/16.
 * 最基本的recyclerView的adapter
 */
public class LoadAdapter extends RecyclerView.Adapter<LoadAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<LoadBean> mData;
    private LayoutInflater inflater;


    public LoadAdapter(Context context, ArrayList<LoadBean> data) {
        mContext = context;
        inflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_shelf, null));
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textName.setText(mData.get(position).getName());
        //holder.imgCover.setImageDrawable(mContext.getResources().getDrawable(mData.get(position).getImg()));
        //使用glide 不使用图片的缓存策略
        Glide.with(mContext)
                .load(mData.get(position).getUrl())
                .placeholder(R.drawable.icon_local0)
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(holder.imgCover);
        //不能在子线程中更新 UI ，这里很显然是子线程操作UI。不崩溃才怪
        //使用picasso 的图片处理框架来展示图片
       /* Picasso.with(mContext)
                .load(mData.get(position).getUrl())
                .placeholder(R.drawable.icon_local0)
                .centerCrop() //需要设置大小
                .resize(88,166)//设置大小之后 看看内存波动的情况（图片在设置大小之后 内存稳定，使用在8M左右）
                //.centerInside()//需要设置大小
                .into(holder.imgCover);*/
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgCover;
        private TextView textName;

        public ViewHolder(View view) {
            super(view);
            imgCover = (ImageView) view.findViewById(R.id.img_cover);
            textName = (TextView) view.findViewById(R.id.text_name);
        }
    }
}
