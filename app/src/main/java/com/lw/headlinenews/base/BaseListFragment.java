package com.lw.headlinenews.base;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.lw.commonUtils.ToastUtils;
import com.lw.headlinenews.R;
import com.lw.headlinenews.databinding.BaseListFragmentBinding;

/**
 * Created by lw on 17-12-4.
 */

public abstract class BaseListFragment<V extends IBaseListView, P extends IBaseListPresenter<V>> extends BaseFragment<V, P> implements IBaseListView, XRecyclerView.LoadingListener {

    protected XRecyclerView recycleView;

    @Override
    protected int attachLayoutId() {
        return R.layout.base_list_fragment;
    }

    @Override
    protected void initView(View view) {
        BaseListFragmentBinding bind = DataBindingUtil.bind(view);
        recycleView = bind.contentRecycleView;
        recycleView.setLoadingListener(this);
        recycleView.setLayoutManager(new LinearLayoutManager(getContext().getApplicationContext()));
    }

    @Override
    public void onShowNetError() {
        ToastUtils.showToast(getContext(), R.string.net_error);
    }

    @Override
    public void onRefresh() {
        Log.d("tag", "==XRecyclerView==onRefresh======");
        presenter.doRefresh();
    }

    @Override
    public void onLoadMore() {
        Log.d("tag", "==XRecyclerView==onLoadMore======");
        presenter.doLoadMore();
    }

    @Override
    public void onLoadingFinish() {
        recycleView.refreshComplete();
        recycleView.loadMoreComplete();
    }
}
