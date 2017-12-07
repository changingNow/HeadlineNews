package com.lw.headlinenews.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lw.headlinenews.event.DoNoThingEvent;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by lw on 17-11-16.
 */

public abstract class BaseFragment<V extends IBaseView, P extends IBasePresenter<V>> extends RxFragment implements IBaseView {

    protected P presenter;

    /**
     * 绑定布局文件
     *
     * @return 布局文件ID
     */
    protected abstract int attachLayoutId();

    /**
     * init presenter
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
        EventBus.getDefault().register(this);
        setPresenter();
        initView(view);
        initData();
        return view;
    }

    private void setPresenter() {
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("presenter must be set before!");
        }
        presenter.onAttach((V)this);
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
        super.onStop();
        if (presenter != null) {
            presenter.onDetach();
        }
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void registEventBusOnly(DoNoThingEvent event) {
    }
}
