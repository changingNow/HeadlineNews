package com.lw.headlinenews.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by lw on 17-11-16.
 */
public interface IBaseView<T> {

    /**
     * 显示加载动画 recycler view 的loading 图标
     */
    void onShowLoading();

    /**
     * 隐藏加载
     */
    void onHideLoading();

    /**
     * 显示网络错误
     */
    void onShowNetError();

    /**
     * 设置 presenter
     */
    void setPresenter(T presenter);

    /**
     * 绑定生命周期
     */
    <T> LifecycleTransformer<T> bindToLife();
}
