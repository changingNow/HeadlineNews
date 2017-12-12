package com.lw.headlinenews.event;

import com.lw.headlinenews.bean.NewsArticleDataBean;

/**
 * Created by lw on 17-12-12.
 */

public class NewsItemShareClickEvent {
    private NewsArticleDataBean bean;

    public NewsItemShareClickEvent(NewsArticleDataBean bean) {
        this.bean = bean;
    }

    public NewsArticleDataBean getBean() {
        return bean;
    }
}
