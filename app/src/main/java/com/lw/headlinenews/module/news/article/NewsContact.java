package com.lw.headlinenews.module.news.article;

import com.lw.headlinenews.base.IBaseListPresenter;
import com.lw.headlinenews.base.IBaseListView;
import com.lw.headlinenews.bean.NewsArticleDataBean;

import java.util.List;

/**
 * Created by lw on 17-12-2.
 */

public class NewsContact {
    abstract static class Presenter extends IBaseListPresenter<View> {
        public abstract void getNewsArticleList(String category);
    }

    interface View extends IBaseListView {
        void onLoadData(List<NewsArticleDataBean> list);
    }
}
