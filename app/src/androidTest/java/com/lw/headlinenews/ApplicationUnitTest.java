package com.lw.headlinenews;

import android.test.ActivityInstrumentationTestCase2;

import com.lw.commonUtils.LogUtils;
import com.lw.headlinenews.api.NewsApi;
import com.lw.headlinenews.module.news.NewsArticleBean;
import com.lw.headlinenews.utils.RetrofitFactory;

import java.util.concurrent.CountDownLatch;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lw on 17-12-2.
 */

public class ApplicationUnitTest extends ActivityInstrumentationTestCase2<TestActivity> {

    private String TAG = "ApplicationUnitTest";

    public ApplicationUnitTest() {
        super(TestActivity.class);
    }
    
    public void testGetNewsArticle() throws InterruptedException {
        String time = String.valueOf(System.currentTimeMillis()/1000);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        RetrofitFactory.getRetrofit(NewsApi.HOST)
                .create(NewsApi.class)
                .getNews("news_society", time)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsArticleBean>() {
                    @Override
                    public void accept(NewsArticleBean newsArticleBean) throws Exception {
                        LogUtils.d(TAG, newsArticleBean.getData().get(0).getContent());
                        assertNotNull(newsArticleBean);
                        assertTrue(newsArticleBean.getMessage().equals("success"));
                        countDownLatch.countDown();
                    }
                });
        countDownLatch.await();
    }
    
}

