package com.lw.headlinenews.module.news.article;

import com.lw.headlinenews.base.IBasePresenter;
import com.lw.headlinenews.base.IBaseView;

/**
 * Created by lw on 17-12-20.
 */

public class NewsDetailContact {
    interface View extends IBaseView {
        void setWebViewContent(String url, boolean isText);
    }

    abstract static class Presenter extends IBasePresenter<View> {
        void doLoadData(String url) {
        }
    }
}
