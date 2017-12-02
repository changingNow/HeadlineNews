package com.lw.headlinenews.utils;

import com.franmontiel.persistentcookiejar.ClearableCookieJar;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lw.commonUtils.NetWorkUtils;
import com.lw.headlinenews.HNApplication;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lw on 17-12-1.
 * <p>
 * base on those dependence
 * // retrofit 2
 * implementation 'com.squareup.retrofit2:retrofit:2.3.0'
 * implementation 'com.squareup.retrofit2:converter-gson:2.3.0'
 * implementation 'com.squareup.retrofit2:adapter-rxjava2:2.3.0'
 * <p>
 * compile 'com.squareup.okhttp3:logging-interceptor:3.8.1'
 * // 持久化 Cookie
 * implementation 'com.github.franmontiel:PersistentCookieJar:v1.0.1'
 */


public class RetrofitFactory {
    public static final long DEFAULT_TIMEOUT = 20000;
    public static final long CACHE_SIZE = 1024 * 1024 * 100;  //100Mb
    public static final String CACHE_DIR_NAME = "cache";

    private static OkHttpClient client = null;

    public static Retrofit getRetrofit(String baseUrl) {

        // Cookie 持久化
        ClearableCookieJar cookieJar =
                new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(HNApplication.getAppContext()));

        File cacheFile = new File(HNApplication.getAppContext().getCacheDir(), CACHE_DIR_NAME);
        Cache cache = new Cache(cacheFile, CACHE_SIZE);

        //这里可以添加一个HttpLoggingInterceptor，因为Retrofit封装好了从Http请求到解析，
        //出了bug很难找出来问题，添加HttpLoggingInterceptor拦截器方便调试接口
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                try {
                    String text = URLDecoder.decode(message, "utf-8");

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });

        if (client == null) {
            client = new OkHttpClient.Builder()
                    .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .readTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS)
                    .addNetworkInterceptor(new NetWorkInterceptor())
                    .addInterceptor(interceptor)
                    .cookieJar(cookieJar)
                    .cache(cache)
                    .build();
        }

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").serializeNulls().create();

        return new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
    }

    /**
     * 缓存机制
     * 在响应请求之后在 data/data/<包名>/cache 下建立一个response 文件夹，保持缓存数据。
     * 这样我们就可以在请求的时候，如果判断到没有网络，自动读取缓存的数据。
     * 同样这也可以实现，在我们没有网络的情况下，重新打开App可以浏览的之前显示过的内容。
     * 也就是：判断网络，有网络，则从网络获取，并保存到缓存中，无网络，则从缓存中获取。
     * https://werb.github.io/2016/07/29/%E4%BD%BF%E7%94%A8Retrofit2+OkHttp3%E5%AE%9E%E7%8E%B0%E7%BC%93%E5%AD%98%E5%A4%84%E7%90%86/
     */
    static class NetWorkInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!NetWorkUtils.isNetWorkEnable(HNApplication.getAppContext())) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE).build();
            }

            Response originalResponse = chain.proceed(request);
            if (NetWorkUtils.isNetWorkEnable(HNApplication.getAppContext())) {
                // 有网络时 设置缓存为默认值
                String cacheControl = request.cacheControl().toString();
                return originalResponse.newBuilder()
                        .header("Cache-Control", cacheControl)
                        .removeHeader("Pragma") // 清除头信息，因为服务器如果不支持，会返回一些干扰信息，不清除下面无法生效
                        .build();
            } else {
                // 无网络时 设置超时为1周
                int maxStale = 60 * 60 * 24 * 7;
                return originalResponse.newBuilder()
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .removeHeader("Pragma")
                        .build();
            }
        }
    }
}
