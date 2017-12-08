package com.lw.headlinenews.module.news.article;


import com.google.gson.Gson;
import com.lw.commonUtils.RetrofitUtils;
import com.lw.commonUtils.StringUtils;
import com.lw.headlinenews.HNApplication;
import com.lw.headlinenews.api.NewsApi;
import com.lw.headlinenews.bean.NewsArticleBean;
import com.lw.headlinenews.bean.NewsArticleDataBean;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by lw on 17-12-2.
 */

public class NewsArticlePresenter extends NewsContact.Presenter<NewsContact.View> {

    private Gson gson = new Gson();

    @Override
    public void getNewsArticleList(String category) {
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        RetrofitUtils.getInstance().getRetrofit(HNApplication.getAppContext(), NewsApi.HOST)
                .create(NewsApi.class)
                .getNews(category, time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .switchMap(new Function<NewsArticleBean, Observable<NewsArticleDataBean>>() {
                    @Override
                    public Observable<NewsArticleDataBean> apply(NewsArticleBean newsArticleBean) throws Exception {
                        List<NewsArticleBean.DataBean> data = newsArticleBean.getData();
                        List<NewsArticleDataBean> dataBeanList = new ArrayList<>();
                        for (NewsArticleBean.DataBean bean : data) {
                            NewsArticleDataBean newsArticleDataBean = gson.fromJson(bean.getContent(), NewsArticleDataBean.class);
                            dataBeanList.add(newsArticleDataBean);
                        }
                        return Observable.fromIterable(dataBeanList);
                    }

                })
                .filter(new Predicate<NewsArticleDataBean>() {
                    @Override
                    public boolean test(NewsArticleDataBean bean) throws Exception {
                        if (StringUtils.isNullOrEmpty(bean.getSource())) {
                            return false;
                        }

                        if (bean.getSource().contains("头条问答") || bean.getSource().contains("悟空问答")) {
                            return false;
                        }
                        return true;
                    }
                })
                .toList()
                .subscribe(new Consumer<List<NewsArticleDataBean>>() {
                    @Override
                    public void accept(List<NewsArticleDataBean> newsArticleDataBeans) throws Exception {
                        NewsContact.View view = getView();
                        if (view != null) {
                            view.onLoadData(newsArticleDataBeans);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        NewsContact.View view = getView();
                        if (view != null) {
                            view.onShowNetError();
                        }
                    }
                });

    }


    @Override
    public void doRefresh() {
        NewsContact.View view = getView();

    }

    @Override
    public void doLoadMore() {

    }
}
