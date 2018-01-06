package com.lw.headlinenews.module.news.content;

import com.lw.headlinenews.base.IBasePresenter;
import com.lw.headlinenews.base.IBaseView;

/**
 * Created by lw on 18-1-6.
 */

public class NewsVideoContentContact {
    interface View extends IBaseView{

    }

    abstract static class Presenter extends IBasePresenter<View>{
        void getVideoContentUrl(String videoId){};
    }
}
