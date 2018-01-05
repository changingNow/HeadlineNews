package com.lw.headlinenews.module.news.content;


import com.lw.commonUtils.RetrofitUtils;
import com.lw.commonUtils.StringUtils;
import com.lw.headlinenews.HNApplication;
import com.lw.headlinenews.api.NewsApi;
import com.lw.headlinenews.bean.NewsContentBean;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by lw on 17-12-20.
 */

public class NewsContentPresenter extends NewsContentContact.Presenter {
    @Override
    void doLoadData(final String displayUrl) {
        Observable
                .create(new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> e) throws Exception {
                        try {
                            Response<ResponseBody> response = RetrofitUtils.getInstance().getRetrofit(HNApplication.getAppContext(), NewsApi.HOST)
                                    .create(NewsApi.class)
                                    .getNewsContentRedirectUrl(displayUrl) //displayUrl   http://toutiao.com/group/6501573221412766221/
                                    .execute();
                            if (response.isSuccessful()) {
                                String urlBase = response.raw().request().url().toString(); // TODO: 17-12-21 why need do this to get url
                                if (!StringUtils.isNullOrEmpty(urlBase) && urlBase.contains("toutiao")) {
                                    String api = urlBase + "info/";  // api    https://m.toutiao.com/i6501793382992445965/info/
                                    e.onNext(api);
                                } else {
                                    e.onError(new Throwable());
                                }
                            } else {
                                e.onError(new Throwable());
                            }
                        } catch (Exception e1) {
                            e.onComplete();
                            e1.printStackTrace();
                        }
                    }
                })
                .subscribeOn(Schedulers.io())
                .switchMap(new Function<String, ObservableSource<NewsContentBean>>() {
                    @Override
                    public ObservableSource<NewsContentBean> apply(String s) throws Exception {
                        return RetrofitUtils.getInstance().getRetrofit(HNApplication.getAppContext(), NewsApi.HOST).create(NewsApi.class).getContentBean(s);
                    }
                })
                .observeOn(Schedulers.newThread())
                .map(new Function<NewsContentBean, String>() {
                    @Override
                    public String apply(NewsContentBean bean) throws Exception {
                        return getHtmlContent(bean);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        getView().setWebViewContent(s, true);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        getView().setWebViewContent(null, false);
                    }
                });
    }

    private String getHtmlContent(NewsContentBean bean) {
        NewsContentBean.DataBean beanData = bean.getData();
        String title = beanData.getTitle();
        String content = beanData.getContent();

        // TODO: 17-12-21 add change style css
        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/toutiao_light.css\" type=\"text/css\">";

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
//                "<head>\n" +
//                "    <meta charset=\"UTF-8\">" +
//                css +
                "<body>\n" +
                "<article class=\"article-container\">\n" +
                "    <div class=\"article__content article-content\">" +
                "<h1 class=\"article-title\">" +
                title +
                "</h1>" +
                content +
                "    </div>\n" +
                "</article>\n" +
                "</body>\n" +
                "</html>";

        return html;
    }
}
