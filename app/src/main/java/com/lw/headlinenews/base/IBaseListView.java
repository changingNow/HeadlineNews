package com.lw.headlinenews.base;

/**
 * Created by lw on 17-12-4.
 */

public interface IBaseListView extends IBaseView {
    /**
     * 显示网络错误
     */
    void onShowNetError();

    /**
     *  loading finish
     */
    void onLoadingFinish();
}
