package com.lw.headlinenews.utils;

import com.lw.headlinenews.bean.NewsArticleDataBean;
import com.lw.headlinenews.bean.NewsArticleParcelableBean;

/**
 * Created by lw on 17-12-21.
 */

public class BeanFormate {
    public static void formateToParcelableArticleBean(NewsArticleDataBean dataBean, NewsArticleParcelableBean parcelableBean) {
        parcelableBean.setArticleTitle(dataBean.getTitle());
        parcelableBean.setGroupId(dataBean.getGroupId());
        parcelableBean.setItemId(dataBean.getItemId());
        parcelableBean.setMediaId(dataBean.getMediaInfo().getMediaId());
        parcelableBean.setShareUrl(dataBean.getShareUrl());
        parcelableBean.setDisplayUrl(dataBean.getDisplayUrl());
        parcelableBean.setMediaName(dataBean.getMediaName());
        parcelableBean.setVideoInfo(dataBean.getVideoDetailInfo());
        parcelableBean.setHasVideo(dataBean.isHasVideo());
    }
}
