package com.lw.headlinenews.event;

import com.lw.headlinenews.bean.NewsArticleDataBean;

/**
 * Created by lw on 17-12-12.
 */

public class NewsItemClickEvent {
    private NewsArticleDataBean bean;

    public NewsItemClickEvent(NewsArticleDataBean bean) {
        this.bean = bean;
    }

    public NewsArticleDataBean getDataBean(){
        return bean;
    }
}
