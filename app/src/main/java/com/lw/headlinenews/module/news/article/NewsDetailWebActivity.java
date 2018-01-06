package com.lw.headlinenews.module.news.article;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lw.headlinenews.R;
import com.lw.headlinenews.base.BaseActivity;
import com.lw.headlinenews.bean.NewsArticleParcelableBean;
import com.lw.headlinenews.module.news.content.NewsContentFragment;
import com.lw.headlinenews.module.news.content.NewsVideoContentFragment;
import com.lw.headlinenews.utils.AppConstant;

public class NewsDetailWebActivity extends BaseActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail_web);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    protected void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(AppConstant.NEWS_INTENT_BUNDLE_KEY);
        NewsArticleParcelableBean parcelable = bundle.getParcelable(AppConstant.NEWS_ARTICLE_PARCEABLE_BEAN_KEY);
        NewsContentFragment newsContentFragment = NewsContentFragment.getInstance(parcelable);
        NewsVideoContentFragment videoContentFragment = NewsVideoContentFragment.getInstance(parcelable);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content_container, parcelable.isHasVideo() ? videoContentFragment : newsContentFragment)
                .commit();
    }

}
