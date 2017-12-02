package com.lw.headlinenews.module.news;

import com.lw.commonUtils.LogUtils;
import com.lw.headlinenews.api.NewsApi;
import com.lw.headlinenews.utils.RetrofitFactory;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lw on 17-12-2.
 */

public class NewsArticlePresenter implements NewsContact.Presenter{

    @Override
    public void doRefresh() {

    }

    @Override
    public void doShowNetError() {

    }

    @Override
    public List<NewsArticleBean> getNewsArticleList() {
        String time = String.valueOf(System.currentTimeMillis()/1000);
        RetrofitFactory.getRetrofit(NewsApi.HOST)
                .create(NewsApi.class)
                .getNews("news_society", time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsArticleBean>() {
                    @Override
                    public void accept(NewsArticleBean newsArticleBean) throws Exception {
                        LogUtils.d("test", newsArticleBean.getData().get(1).getContent());
                    }
                });
        return null;
    }
}
