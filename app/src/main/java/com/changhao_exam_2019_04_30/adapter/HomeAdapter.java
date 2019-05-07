package com.changhao_exam_2019_04_30.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.changhao_exam_2019_04_30.R;
import com.changhao_exam_2019_04_30.entity.HomeBean;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private List<List<HomeBean.ResultBean.VideoBean>> homeBean;

    public HomeAdapter(Context context) {
        homeBean = new ArrayList<>();
        this.context = context;
    }

    public void setHomeBean(List<List<HomeBean.ResultBean.VideoBean>> homeBean) {
        if (homeBean != null) {
            this.homeBean = homeBean;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_rv, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(homeBean.get(0).get(i).coverImgUrl).into(viewHolder.iv_icon);
        viewHolder.tv_title.setText(homeBean.get(0).get(i).title);
        viewHolder.tv_time.setText(homeBean.get(0).get(i).createTime + "");
    }


    @Override
    public int getItemCount() {
        return homeBean.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView iv_icon;
        private final TextView tv_title;
        private final TextView tv_time;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_icon = itemView.findViewById(R.id.iv_icon);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_time = itemView.findViewById(R.id.tv_time);
        }
    }
}
