package com.lw.headlinenews.module.news.content;

import com.lw.headlinenews.base.IBasePresenter;
import com.lw.headlinenews.base.IBaseView;

/**
 * Created by lw on 17-12-20.
 */

public class NewsContentContact {
    interface View extends IBaseView {
        void setWebViewContent(String url, boolean isText);
    }

    abstract static class Presenter extends IBasePresenter<View> {
        void doLoadData(String url) {
        }
    }
}