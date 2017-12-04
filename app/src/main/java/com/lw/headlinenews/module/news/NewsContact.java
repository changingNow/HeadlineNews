package com.lw.headlinenews.module.news;

import com.lw.headlinenews.base.IBasePresenter;
import com.lw.headlinenews.base.IBaseView;
import com.lw.headlinenews.bean.NewsArticleBean;

import java.util.List;

/**
 * Created by lw on 17-12-2.
 */

public class NewsContact {
     interface Presenter extends IBasePresenter {
        List<NewsArticleBean> getNewsArticleList();
    }

    interface View extends IBaseView<Presenter> {

    }
}
