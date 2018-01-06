package com.lw.headlinenews.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lw on 17-12-21.
 */

public class NewsArticleParcelableBean implements Parcelable {
    private String shareUrl;
    private String displayUrl;
    private String articleTitle;
    private String mediaName;
    private long mediaId;
    private long groupId;
    private long itemId;
    private boolean hasVideo;
    private NewsArticleDataBean.VideoDetailInfoBean videoInfo;

    public NewsArticleParcelableBean() {
    }

    protected NewsArticleParcelableBean(Parcel in) {
        shareUrl = in.readString();
        displayUrl = in.readString();
        articleTitle = in.readString();
        mediaName = in.readString();
        mediaId = in.readLong();
        groupId = in.readLong();
        itemId = in.readLong();
        hasVideo = in.readByte() != 0;
        videoInfo = in.readParcelable(NewsArticleDataBean.VideoDetailInfoBean.class.getClassLoader());
    }

    public static final Creator<NewsArticleParcelableBean> CREATOR = new Creator<NewsArticleParcelableBean>() {
        @Override
        public NewsArticleParcelableBean createFromParcel(Parcel in) {
            return new NewsArticleParcelableBean(in);
        }

        @Override
        public NewsArticleParcelableBean[] newArray(int size) {
            return new NewsArticleParcelableBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(shareUrl);
        parcel.writeString(displayUrl);
        parcel.writeString(articleTitle);
        parcel.writeString(mediaName);
        parcel.writeLong(mediaId);
        parcel.writeLong(groupId);
        parcel.writeLong(itemId);
        parcel.writeByte((byte) (hasVideo ? 1 : 0));
        parcel.writeParcelable(videoInfo, i);
    }


    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public NewsArticleDataBean.VideoDetailInfoBean getVideoInfo() {
        return videoInfo;
    }

    public void setVideoInfo(NewsArticleDataBean.VideoDetailInfoBean videoInfo) {
        this.videoInfo = videoInfo;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }
}
