package com.lw.headlinenews.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lw on 17-12-2.
 */

public class NewsArticleDataBean {

    /**
     * abstract : 侯勇是一个不善言谈的人，他心地善良，乐于助人，他周围的邻居都很喜欢他。也是因为他的善良，加上他不善言谈，他总是常常被人误会，但他对这些误会总是不愿做过多的解释。用他自己的话说就是理解你的人你不需要向他们解释，那些不理解你的人你解释了也没用。
     * action_extra : {"channel_id": 3189398998}
     * action_list : [{"action":1,"desc":"","extra":{}},{"action":3,"desc":"","extra":{}},{"action":7,"desc":"","extra":{}},{"action":9,"desc":"","extra":{}}]
     * aggr_type : 1
     * allow_download : false
     * article_sub_type : 0
     * article_type : 0
     * article_url : http://toutiao.com/group/6494789423077523982/
     * ban_comment : 0
     * behot_time : 1512205944
     * bury_count : 0
     * cell_flag : 11
     * cell_layout_style : 1
     * cell_type : 0
     * comment_count : 1
     * cursor : 1512205944999
     * digg_count : 0
     * display_url : http://toutiao.com/group/6494789423077523982/
     * filter_words : [{"id":"8:0","is_selected":false,"name":"看过了"},{"id":"9:1","is_selected":false,"name":"内容太水"},{"id":"5:1830707885","is_selected":false,"name":"拉黑作者:功夫电影迷"}]
     * forward_info : {"forward_count":16}
     * gallary_image_count : 3
     * group_id : 6494789423077523982
     * has_image : true
     * has_m3u8_video : false
     * has_mp4_video : 0
     * has_video : false
     * hot : 0
     * ignore_web_transform : 1
     * image_list : [{"height":720,"uri":"list/47260004665c59efb7ab","url":"http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb3.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb9.pstatp.com/list/300x196/47260004665c59efb7ab.webp"}],"width":1280},{"height":720,"uri":"list/472a0002cb8d714df989","url":"http://p3.pstatp.com/list/300x196/472a0002cb8d714df989.webp","url_list":[{"url":"http://p3.pstatp.com/list/300x196/472a0002cb8d714df989.webp"},{"url":"http://pb9.pstatp.com/list/300x196/472a0002cb8d714df989.webp"},{"url":"http://pb1.pstatp.com/list/300x196/472a0002cb8d714df989.webp"}],"width":1280},{"height":720,"uri":"list/47260004679cd59c8671","url":"http://p3.pstatp.com/list/300x196/47260004679cd59c8671.webp","url_list":[{"url":"http://p3.pstatp.com/list/300x196/47260004679cd59c8671.webp"},{"url":"http://pb9.pstatp.com/list/300x196/47260004679cd59c8671.webp"},{"url":"http://pb1.pstatp.com/list/300x196/47260004679cd59c8671.webp"}],"width":1280}]
     * is_subject : false
     * item_id : 6494789423077523982
     * item_version : 0
     * keywords : 侯勇,孕妇,小伙子,让座,大妈
     * level : 0
     * log_pb : {"impr_id":"20171202171224010011061075204CC4"}
     * media_info : {"avatar_url":"http://p9.pstatp.com/large/432f0002893d425f0041","follow":false,"is_star_user":false,"media_id":1582291488186381,"name":"功夫电影迷","recommend_reason":"","recommend_type":0,"user_id":67352760545,"user_verified":false,"verified_content":""}
     * media_name : 功夫电影迷
     * middle_image : {"height":720,"uri":"list/47260004665c59efb7ab","url":"http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp","url_list":[{"url":"http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb3.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb9.pstatp.com/list/300x196/47260004665c59efb7ab.webp"}],"width":1280}
     * publish_time : 1512194865
     * read_count : 2272
     * repin_count : 6
     * rid : 20171202171224010011061075204CC4
     * share_count : 0
     * share_url : http://m.toutiao.com/a6494789423077523982/?iid=12507202490&app=news_article
     * show_portrait : false
     * show_portrait_article : false
     * source : 功夫电影迷
     * source_icon_style : 4
     * source_open_url : sslocal://profile?uid=67352760545
     * tag : news_society
     * tag_id : 6494789423077523982
     * tip : 0
     * title : 无知老人指责年轻小伙不给自己让座，小伙离开之后她才后悔莫及
     * ugc_recommend : {"activity":"","reason":""}
     * url : http://toutiao.com/group/6494789423077523982/
     * user_info : {"avatar_url":"http://p9.pstatp.com/thumb/432f0002893d425f0041","description":"每天分享一些功夫和动作电影。喜欢就关注哦。","follow":false,"follower_count":0,"name":"功夫电影迷","user_id":67352760545,"user_verified":false}
     * user_repin : 0
     * user_verified : 0
     * verified_content :
     * video_style : 0
     */

    @SerializedName("abstract")
    private String description;

    @SerializedName("action_extra")
    private String actionExtra;

    @SerializedName("aggr_type")
    private int aggrType;

    @SerializedName("allow_download")
    private boolean allowDownload;

    @SerializedName("article_sub_type")
    private int articleSubType;

    @SerializedName("article_type")
    private int articleType;

    @SerializedName("article_url")
    private String articleUrl;

    @SerializedName("ban_comment")
    private int banComment;

    @SerializedName("behot_time")
    private int behotTime;

    @SerializedName("bury_count")
    private int buryCount;

    @SerializedName("cell_flag")
    private int cellFlag;

    @SerializedName("cell_layout_style")
    private int cellLayoutStyle;

    @SerializedName("cell_type")
    private int cellType;

    @SerializedName("comment_count")
    private int commentCount;

    private long cursor;
    @SerializedName("digg_count")
    private int diggCount;

    @SerializedName("display_url")
    private String displayUrl;

    @SerializedName("forward_info")
    private ForwardInfoBean forwardInfo;

    @SerializedName("gallary_image_count")
    private int gallaryImageCount;

    @SerializedName("group_id")
    private long groupId;

    @SerializedName("has_image")
    private boolean hasImage;

    @SerializedName("has_m3u8_video")
    private boolean hasM3u8Video;

    @SerializedName("has_mp4_video")
    private int hasMp4Video;

    @SerializedName("has_video")
    private boolean hasVideo;
    private int hot;
    @SerializedName("ignore_web_transform")
    private int ignoreWebTransform;

    @SerializedName("is_subject")
    private boolean isSubject;

    @SerializedName("item_id")
    private long itemId;

    @SerializedName("item_version")
    private int itemVersion;

    private String keywords;
    private int level;

    @SerializedName("log_pb")
    private LogPbBean logPb;

    @SerializedName("media_info")
    private MediaInfoBean mediaInfo;

    @SerializedName("media_name")
    private String mediaName;

    @SerializedName("middle_image")
    private MiddleImageBean middleImage;

    @SerializedName("publish_time")
    private int publishTime;

    @SerializedName("read_count")
    private int readCount;

    @SerializedName("repin_count")
    private int repinCount;
    private String rid;

    @SerializedName("share_count")
    private int shareCount;

    @SerializedName("share_url")
    private String shareUrl;

    @SerializedName("show_portrait")
    private boolean showPortrait;

    @SerializedName("show_portrait_article")
    private boolean showPortraitArticle;
    private String source;

    @SerializedName("source_icon_style")
    private int sourceIconStyle;

    @SerializedName("source_open_url")
    private String sourceOpenUrl;
    private String tag;

    @SerializedName("tag_id")
    private long tagId;

    private int tip;
    private String title;

    @SerializedName("ugc_recommend")
    private UgcRecommendBean ugcRecommend;
    private String url;

    @SerializedName("user_info")
    private UserInfoBean userInfo;

    @SerializedName("user_repin")
    private int userRepin;

    @SerializedName("user_verified")
    private int userVerified;

    @SerializedName("verified_content")
    private String verifiedContent;

    @SerializedName("video_style")
    private int videoStyle;

    @SerializedName("action_list")
    private List<ActionListBean> actionList;

    @SerializedName("filter_words")
    private List<FilterWordsBean> filterWords;

    @SerializedName("image_list")
    private List<ImageListBean> imageList;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActionExtra() {
        return actionExtra;
    }

    public void setActionExtra(String actionExtra) {
        this.actionExtra = actionExtra;
    }

    public int getAggrType() {
        return aggrType;
    }

    public void setAggrType(int aggrType) {
        this.aggrType = aggrType;
    }

    public boolean isAllowDownload() {
        return allowDownload;
    }

    public void setAllowDownload(boolean allowDownload) {
        this.allowDownload = allowDownload;
    }

    public int getArticleSubType() {
        return articleSubType;
    }

    public void setArticleSubType(int articleSubType) {
        this.articleSubType = articleSubType;
    }

    public int getArticleType() {
        return articleType;
    }

    public void setArticleType(int articleType) {
        this.articleType = articleType;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public int getBanComment() {
        return banComment;
    }

    public void setBanComment(int banComment) {
        this.banComment = banComment;
    }

    public int getBehotTime() {
        return behotTime;
    }

    public void setBehotTime(int behotTime) {
        this.behotTime = behotTime;
    }

    public int getBuryCount() {
        return buryCount;
    }

    public void setBuryCount(int buryCount) {
        this.buryCount = buryCount;
    }

    public int getCellFlag() {
        return cellFlag;
    }

    public void setCellFlag(int cellFlag) {
        this.cellFlag = cellFlag;
    }

    public int getCellLayoutStyle() {
        return cellLayoutStyle;
    }

    public void setCellLayoutStyle(int cellLayoutStyle) {
        this.cellLayoutStyle = cellLayoutStyle;
    }

    public int getCellType() {
        return cellType;
    }

    public void setCellType(int cellType) {
        this.cellType = cellType;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public int getDiggCount() {
        return diggCount;
    }

    public void setDiggCount(int diggCount) {
        this.diggCount = diggCount;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public ForwardInfoBean getForwardInfo() {
        return forwardInfo;
    }

    public void setForwardInfo(ForwardInfoBean forwardInfo) {
        this.forwardInfo = forwardInfo;
    }

    public int getGallaryImageCount() {
        return gallaryImageCount;
    }

    public void setGallaryImageCount(int gallaryImageCount) {
        this.gallaryImageCount = gallaryImageCount;
    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public boolean isHasImage() {
        return hasImage;
    }

    public void setHasImage(boolean hasImage) {
        this.hasImage = hasImage;
    }

    public boolean isHasM3u8Video() {
        return hasM3u8Video;
    }

    public void setHasM3u8Video(boolean hasM3u8Video) {
        this.hasM3u8Video = hasM3u8Video;
    }

    public int getHasMp4Video() {
        return hasMp4Video;
    }

    public void setHasMp4Video(int hasMp4Video) {
        this.hasMp4Video = hasMp4Video;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getIgnoreWebTransform() {
        return ignoreWebTransform;
    }

    public void setIgnoreWebTransform(int ignoreWebTransform) {
        this.ignoreWebTransform = ignoreWebTransform;
    }

    public boolean isSubject() {
        return isSubject;
    }

    public void setSubject(boolean subject) {
        isSubject = subject;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getItemVersion() {
        return itemVersion;
    }

    public void setItemVersion(int itemVersion) {
        this.itemVersion = itemVersion;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public LogPbBean getLogPb() {
        return logPb;
    }

    public void setLogPb(LogPbBean logPb) {
        this.logPb = logPb;
    }

    public MediaInfoBean getMediaInfo() {
        return mediaInfo;
    }

    public void setMediaInfo(MediaInfoBean mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public MiddleImageBean getMiddleImage() {
        return middleImage;
    }

    public void setMiddleImage(MiddleImageBean middleImage) {
        this.middleImage = middleImage;
    }

    public int getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(int publishTime) {
        this.publishTime = publishTime;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public int getRepinCount() {
        return repinCount;
    }

    public void setRepinCount(int repinCount) {
        this.repinCount = repinCount;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public boolean isShowPortrait() {
        return showPortrait;
    }

    public void setShowPortrait(boolean showPortrait) {
        this.showPortrait = showPortrait;
    }

    public boolean isShowPortraitArticle() {
        return showPortraitArticle;
    }

    public void setShowPortraitArticle(boolean showPortraitArticle) {
        this.showPortraitArticle = showPortraitArticle;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getSourceIconStyle() {
        return sourceIconStyle;
    }

    public void setSourceIconStyle(int sourceIconStyle) {
        this.sourceIconStyle = sourceIconStyle;
    }

    public String getSourceOpenUrl() {
        return sourceOpenUrl;
    }

    public void setSourceOpenUrl(String sourceOpenUrl) {
        this.sourceOpenUrl = sourceOpenUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public long getTagId() {
        return tagId;
    }

    public void setTagId(long tagId) {
        this.tagId = tagId;
    }

    public int getTip() {
        return tip;
    }

    public void setTip(int tip) {
        this.tip = tip;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UgcRecommendBean getUgcRecommend() {
        return ugcRecommend;
    }

    public void setUgcRecommend(UgcRecommendBean ugcRecommend) {
        this.ugcRecommend = ugcRecommend;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public int getUserRepin() {
        return userRepin;
    }

    public void setUserRepin(int userRepin) {
        this.userRepin = userRepin;
    }

    public int getUserVerified() {
        return userVerified;
    }

    public void setUserVerified(int userVerified) {
        this.userVerified = userVerified;
    }

    public String getVerifiedContent() {
        return verifiedContent;
    }

    public void setVerifiedContent(String verifiedContent) {
        this.verifiedContent = verifiedContent;
    }

    public int getVideoStyle() {
        return videoStyle;
    }

    public void setVideoStyle(int videoStyle) {
        this.videoStyle = videoStyle;
    }

    public List<ActionListBean> getActionList() {
        return actionList;
    }

    public void setActionList(List<ActionListBean> actionList) {
        this.actionList = actionList;
    }

    public List<FilterWordsBean> getFilterWords() {
        return filterWords;
    }

    public void setFilterWords(List<FilterWordsBean> filterWords) {
        this.filterWords = filterWords;
    }

    public List<ImageListBean> getImageList() {
        return imageList;
    }

    public void setImageList(List<ImageListBean> imageList) {
        this.imageList = imageList;
    }

    public static class ForwardInfoBean {
        /**
         * forward_count : 16
         */
        @SerializedName("forward_count")
        private int forwardCount;

        public int getForwardCount() {
            return forwardCount;
        }

        public void setForwardCount(int forwardCount) {
            this.forwardCount = forwardCount;
        }
    }

    public static class LogPbBean {
        /**
         * impr_id : 20171202171224010011061075204CC4
         */

        @SerializedName("impr_id")
        private String imprId;

        public String getImprId() {
            return imprId;
        }

        public void setImprId(String imprId) {
            this.imprId = imprId;
        }
    }

    public static class MediaInfoBean {
        /**
         * avatar_url : http://p9.pstatp.com/large/432f0002893d425f0041
         * follow : false
         * is_star_user : false
         * media_id : 1582291488186381
         * name : 功夫电影迷
         * recommend_reason :
         * recommend_type : 0
         * user_id : 67352760545
         * user_verified : false
         * verified_content :
         */

        @SerializedName("avatar_url")
        private String avatarUrl;

        private boolean follow;

        @SerializedName("is_star_user")
        private boolean isStarUser;

        @SerializedName("media_id")
        private long mediaId;

        private String name;

        @SerializedName("recommend_reason")
        private String recommendReason;

        @SerializedName("recommend_type")
        private int recommendType;

        @SerializedName("user_id")
        private long userId;

        @SerializedName("user_verified")
        private boolean userVerified;

        @SerializedName("verified_content")
        private String verifiedContent;

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public boolean isStarUser() {
            return isStarUser;
        }

        public void setStarUser(boolean starUser) {
            isStarUser = starUser;
        }

        public long getMediaId() {
            return mediaId;
        }

        public void setMediaId(long mediaId) {
            this.mediaId = mediaId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRecommendReason() {
            return recommendReason;
        }

        public void setRecommendReason(String recommendReason) {
            this.recommendReason = recommendReason;
        }

        public int getRecommendType() {
            return recommendType;
        }

        public void setRecommendType(int recommendType) {
            this.recommendType = recommendType;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public boolean isUserVerified() {
            return userVerified;
        }

        public void setUserVerified(boolean userVerified) {
            this.userVerified = userVerified;
        }

        public String getVerifiedContent() {
            return verifiedContent;
        }

        public void setVerifiedContent(String verifiedContent) {
            this.verifiedContent = verifiedContent;
        }
    }

    public static class MiddleImageBean {
        /**
         * height : 720
         * uri : list/47260004665c59efb7ab
         * url : http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp
         * url_list : [{"url":"http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb3.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb9.pstatp.com/list/300x196/47260004665c59efb7ab.webp"}]
         * width : 1280
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        @SerializedName("url_list")
        private List<UrlListBean> urlList;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBean> getUrlList() {
            return urlList;
        }

        public void setUrlList(List<UrlListBean> urlList) {
            this.urlList = urlList;
        }

        public static class UrlListBean {
            /**
             * url : http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }

    public static class UgcRecommendBean {
        /**
         * activity :
         * reason :
         */

        private String activity;
        private String reason;

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }

    public static class UserInfoBean {
        /**
         * avatar_url : http://p9.pstatp.com/thumb/432f0002893d425f0041
         * description : 每天分享一些功夫和动作电影。喜欢就关注哦。
         * follow : false
         * follower_count : 0
         * name : 功夫电影迷
         * user_id : 67352760545
         * user_verified : false
         */
        @SerializedName("avatar_url")
        private String avatarUrl;
        private String description;
        private boolean follow;

        @SerializedName("follower_count")
        private int followerCount;
        private String name;

        @SerializedName("user_id")
        private long userId;

        @SerializedName("user_verified")
        private boolean userVerified;

        public String getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(String avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isFollow() {
            return follow;
        }

        public void setFollow(boolean follow) {
            this.follow = follow;
        }

        public int getFollowerCount() {
            return followerCount;
        }

        public void setFollowerCount(int followerCount) {
            this.followerCount = followerCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getUserId() {
            return userId;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }

        public boolean isUserVerified() {
            return userVerified;
        }

        public void setUserVerified(boolean userVerified) {
            this.userVerified = userVerified;
        }
    }

    public static class ActionListBean {
        /**
         * action : 1
         * desc :
         * extra : {}
         */

        private int action;
        private String desc;
        private ExtraBean extra;

        public int getAction() {
            return action;
        }

        public void setAction(int action) {
            this.action = action;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public ExtraBean getExtra() {
            return extra;
        }

        public void setExtra(ExtraBean extra) {
            this.extra = extra;
        }

        public static class ExtraBean {
        }
    }

    public static class FilterWordsBean {
        /**
         * id : 8:0
         * is_selected : false
         * name : 看过了
         */

        private String id;
        private boolean is_selected;
        private String name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isIs_selected() {
            return is_selected;
        }

        public void setIs_selected(boolean is_selected) {
            this.is_selected = is_selected;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class ImageListBean {
        /**
         * height : 720
         * uri : list/47260004665c59efb7ab
         * url : http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp
         * url_list : [{"url":"http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb3.pstatp.com/list/300x196/47260004665c59efb7ab.webp"},{"url":"http://pb9.pstatp.com/list/300x196/47260004665c59efb7ab.webp"}]
         * width : 1280
         */

        private int height;
        private String uri;
        private String url;
        private int width;
        @SerializedName("url_list")
        private List<UrlListBeanX> urlList;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public List<UrlListBeanX> getUrlList() {
            return urlList;
        }

        public void setUrlList(List<UrlListBeanX> urlList) {
            this.urlList = urlList;
        }

        public static class UrlListBeanX {
            /**
             * url : http://p1.pstatp.com/list/300x196/47260004665c59efb7ab.webp
             */

            private String url;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
