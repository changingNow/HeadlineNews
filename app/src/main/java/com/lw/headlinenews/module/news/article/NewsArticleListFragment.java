package com.lw.headlinenews.module.news.article;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.lw.commonUtils.CollectionUtils;
import com.lw.commonUtils.LogUtils;
import com.lw.headlinenews.adapter.NewsArticleAdapter;
import com.lw.headlinenews.base.BaseListFragment;
import com.lw.headlinenews.bean.NewsArticleDataBean;

import java.util.List;

/**
 * Created by lw on 17-12-5.
 */

public class NewsArticleListFragment extends BaseListFragment<NewsContact.View, NewsArticlePresenter> implements NewsContact.View {
    private static final String BUNDLE_KEY = "category";
    private static final String TAG = "NewsArticleListFragment";

    @SuppressLint("ValidFragment")
    private NewsArticleListFragment() {
    }

    public static NewsArticleListFragment getInstance(String categoryId) {
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY, categoryId);
        NewsArticleListFragment view = new NewsArticleListFragment();
        view.setArguments(bundle);
        return view;
    }

    @Override
    protected void initData() throws NullPointerException {
        String category = getArguments().getString(BUNDLE_KEY);
        presenter.getNewsArticleList(category);
    }

    @Override
    protected NewsArticlePresenter createPresenter() {
        return new NewsArticlePresenter();
    }

    @Override
    public void onLoadData(List<NewsArticleDataBean> list) {
        if (!CollectionUtils.isNullOrEmpty(list)) {
            LogUtils.d(TAG, "============" + list.get(0).getDescription());
            NewsArticleAdapter adapter = new NewsArticleAdapter(list);
            recycleView.setAdapter(adapter);
        }

    }


}
