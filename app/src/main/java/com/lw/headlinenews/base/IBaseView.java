package com.lw.headlinenews.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * Created by lw on 17-11-16.
 */
public interface IBaseView {

    /**
     * 绑定生命周期
     */
    <T> LifecycleTransformer<T> bindToLife();
}
