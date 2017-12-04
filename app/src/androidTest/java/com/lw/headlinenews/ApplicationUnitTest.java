package com.lw.headlinenews;

import android.test.ActivityInstrumentationTestCase2;

import com.google.gson.Gson;
import com.lw.commonUtils.LogUtils;
import com.lw.commonUtils.RetrofitUtils;
import com.lw.commonUtils.TestUtils;
import com.lw.headlinenews.api.NewsApi;
import com.lw.headlinenews.bean.NewsArticleBean;
import com.lw.headlinenews.bean.NewsArticleDataBean;

import java.util.List;
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
        String time = String.valueOf(System.currentTimeMillis() / 1000);
        String[] idArray = getActivity().getResources().getStringArray(R.array.news_id);
        int index = TestUtils.randInt(0, idArray.length - 1);
        LogUtils.d(TAG, idArray[index]);
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        RetrofitUtils.getInstance()
                .getRetrofit(HNApplication.getAppContext(), NewsApi.HOST)
                .create(NewsApi.class)
                .getNews(idArray[index], time)
                .observeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<NewsArticleBean>() {
                    @Override
                    public void accept(NewsArticleBean newsArticleBean) throws Exception {
                        List<NewsArticleBean.DataBean> beanList = newsArticleBean.getData();
                        int i = TestUtils.randInt(0, beanList.size() - 1);
                        assertNotNull(newsArticleBean);
                        assertTrue(beanList.size() > 0);
                        Gson gson = new Gson();
                        NewsArticleDataBean articleDataBean = gson.fromJson(beanList.get(i).getContent(), NewsArticleDataBean.class);
                        assertNotNull(articleDataBean);
                        LogUtils.d(TAG, articleDataBean.getArticleUrl());
                        LogUtils.d(TAG, articleDataBean.getShareUrl());
                        LogUtils.d(TAG, articleDataBean.getDescription());
                        countDownLatch.countDown();
                    }
                });
        countDownLatch.await();
    }
}

