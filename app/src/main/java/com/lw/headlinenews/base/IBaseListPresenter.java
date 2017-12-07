package com.lw.headlinenews.base;

/**
 * Created by lw on 17-12-7.
 */

public abstract class IBaseListPresenter<V extends IBaseListView> extends IBasePresenter<V> {
    public abstract void doRefresh();
    public abstract void doLoadMore();
}
