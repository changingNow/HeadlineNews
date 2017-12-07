package com.lw.headlinenews.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lw.headlinenews.R;
import com.lw.headlinenews.bean.NewsArticleDataBean;
import com.lw.headlinenews.viewHolder.BaseDataBindingViewHolder;

import java.util.List;

/**
 * Created by lw on 17-12-6.
 */

public class NewsArticleAdapter extends RecyclerView.Adapter<BaseDataBindingViewHolder> {
    List<NewsArticleDataBean> list;

    public NewsArticleAdapter(List<NewsArticleDataBean> list) {
        this.list = list;
    }

    @Override
    public BaseDataBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext().getApplicationContext()).inflate(R.layout.news_article_item_layout, parent, false);
        BaseDataBindingViewHolder viewHolder = new BaseDataBindingViewHolder(DataBindingUtil.bind(view));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseDataBindingViewHolder holder, int position) {
        NewsArticleDataBean articleDataBean = list.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
