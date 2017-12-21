package com.lw.headlinenews.api;

import com.lw.headlinenews.bean.NewsArticleBean;
import com.lw.headlinenews.bean.NewsContentBean;
import com.lw.headlinenews.utils.AppConstant;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by lw on 17-11-30.
 */

public interface NewsApi {
    //news model, change category for different type which is from news_id in string-array
    //http://lf.snssdk.com/api/news/feed/v62/?iid=12507202490&device_id=37487219424&refer=1&count=20&aid=13&category=news_society
    //http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13&category=news_society
    String HOST = "http://toutiao.com/";

    @GET("http://is.snssdk.com/api/news/feed/v62/?iid=5034850950&device_id=6096495334&refer=1&count=20&aid=13")
    Observable<NewsArticleBean> getNews(@Query("category") String category, @Query("max_behot_time") String currentTime);

    /**
     * return  https://m.toutiao.com/i6501793382992445965/info/
     */
    @GET
    @Headers("User-Agent:" + AppConstant.LW_MODEL)
    Call<ResponseBody> getNewsContentRedirectUrl(@Url String url);

    /**
     * 获取新闻HTML内容
     * http://m.toutiao.com/i6364969235889783298/info/
     */
    @GET
    Observable<NewsContentBean> getContentBean(@Url String url);
}
