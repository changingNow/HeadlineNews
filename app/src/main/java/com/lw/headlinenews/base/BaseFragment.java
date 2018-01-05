package com.lw.headlinenews.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by lw on 17-11-16.
 */

public abstract class BaseFragment<V extends IBaseView, P extends IBasePresenter<V>> extends RxFragment implements IBaseView {

    protected P presenter;
    private ProgressDialog progressDialog;

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract int attachLayoutId();

    /**
     * init presenter
     *
     * @return presenter
     */
    protected abstract P createPresenter();

    /**
     * 初始化视图控件
     */
    protected abstract void initView(View view);

    /**
     * 初始化数据
     */
    protected abstract void initData() throws NullPointerException;

    /**
     * 初始化 Toolbar
     */
    protected void initToolBar(Toolbar toolbar, boolean homeAsUpEnabled, String title) {
        ((BaseActivity) getActivity()).initToolBar(toolbar, homeAsUpEnabled, title);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(attachLayoutId(), container, false);
        initView(view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        setPresenter();
        initData();
    }

    private void setPresenter() {
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("presenter must be set before!");
        }
        presenter.onAttach((V) this);
    }

    /**
     * 绑定生命周期
     */
    @Override
    public <T> LifecycleTransformer<T> bindToLife() {
        return bindUntilEvent(FragmentEvent.STOP);
    }

    @Override
    public void onStop() {
        if (presenter != null) {
            presenter.onDetach();
        }
        hideLoadingProgress();
        super.onStop();
    }

    public void showLoadingProgress(String message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getContext());
            progressDialog.setMessage(message);
        }
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }
    }

    public void hideLoadingProgress() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

}
