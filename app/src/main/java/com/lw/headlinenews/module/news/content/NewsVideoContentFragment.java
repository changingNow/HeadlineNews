package com.lw.headlinenews.module.news.content;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import com.lw.headlinenews.R;
import com.lw.headlinenews.base.BaseFragment;
import com.lw.headlinenews.bean.NewsArticleParcelableBean;

/**
 * Created by lw on 18-1-6.
 */

public class NewsVideoContentFragment extends BaseFragment<NewsVideoContentContact.View, NewsVideoContentPresenter> {

    @SuppressLint("ValidFragment")
    private NewsVideoContentFragment() {
    }

    private static final String TAG = "NewsVideoContentFragment";

    public static NewsVideoContentFragment getInstance(NewsArticleParcelableBean parcelableBean) {
        NewsVideoContentFragment fragment = new NewsVideoContentFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TAG, parcelableBean);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    protected int attachLayoutId() {
        return R.layout.news_video_content_fragment;
    }

    @Override
    protected NewsVideoContentPresenter createPresenter() {
        return new NewsVideoContentPresenter();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() throws NullPointerException {
        Bundle arguments = getArguments();
        NewsArticleParcelableBean parcelable = arguments.getParcelable(TAG);
        presenter.getVideoContentUrl(parcelable.getVideoInfo().getVideo_id());
    }
}
