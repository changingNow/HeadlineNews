package com.lw.headlinenews.base;

/**
 * Created by lw on 17-11-16.
 */
public interface IBasePresenter {

    /**
     * 刷新数据
     */
    void doRefresh();

    /**
     * 显示网络错误
     */
    void doShowNetError();
}
