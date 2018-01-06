package com.lw.headlinenews.module.news.content;


import android.util.Base64;

import com.lw.commonUtils.LogUtils;
import com.lw.commonUtils.RetrofitUtils;
import com.lw.headlinenews.HNApplication;
import com.lw.headlinenews.api.NewsApi;
import com.lw.headlinenews.bean.VideoContentBean;

import java.util.Random;
import java.util.zip.CRC32;

import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lw on 18-1-6.
 */

public class NewsVideoContentPresenter extends NewsVideoContentContact.Presenter {

    private static final String TAG = "NewsVideoContentPresenter";
    private static String getVideoContentApi(String videoid) {
        String VIDEO_HOST = "http://ib.365yg.com";
        String VIDEO_URL = "/video/urls/v/1/toutiao/mp4/%s?r=%s";
        String r = getRandom();
        String s = String.format(VIDEO_URL, videoid, r);
        // 将/video/urls/v/1/toutiao/mp4/{videoid}?r={Math.random()} 进行crc32加密
        CRC32 crc32 = new CRC32();
        crc32.update(s.getBytes());
        String crcString = crc32.getValue() + "";
        String url = VIDEO_HOST + s + "&s=" + crcString;
        return url;
    }

    private static String getRandom() {
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 16; i++) {
            buffer.append(random.nextInt(10));
        }
        return buffer.toString();
    }

    @Override
    public void getVideoContentUrl(final String videoId) {
        RetrofitUtils.getInstance()
                .getRetrofit(HNApplication.getAppContext(), NewsApi.HOST)
                .create(NewsApi.class)
                .getVideoNewsContentBean(getVideoContentApi(videoId))
                .subscribeOn(Schedulers.io())
                .map(new Function<VideoContentBean, String>() {
                    @Override
                    public String apply(VideoContentBean videoContentBean) throws Exception {
                        VideoContentBean.DataBean.VideoListBean video_list = videoContentBean.getData().getVideo_list();
                        VideoContentBean.DataBean.VideoListBean.Video3Bean video3 = video_list.getVideo_3();
                        VideoContentBean.DataBean.VideoListBean.Video2Bean video2 = video_list.getVideo_2();
                        VideoContentBean.DataBean.VideoListBean.Video1Bean video1 = video_list.getVideo_1();
                        String url = null;
                        if (video3 != null){
                            String mainUrl = video3.getMain_url();
                            url = new String(Base64.decode(mainUrl.getBytes(), Base64.DEFAULT));
                        }
                        if (video2 != null){
                            String mainUrl = video2.getMain_url();
                            url = new String(Base64.decode(mainUrl.getBytes(), Base64.DEFAULT));
                        }
                        if (video1 != null){
                            String mainUrl = video1.getMain_url();
                            url = new String(Base64.decode(mainUrl.getBytes(), Base64.DEFAULT));
                        }
                        LogUtils.d(TAG, "The url is:"+url);
                        return url;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        LogUtils.d(TAG, "====subscribe========="+s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
