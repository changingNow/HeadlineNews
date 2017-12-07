package com.lw.headlinenews.base;

/**
 * Created by lw on 17-11-16.
 */
public abstract class IBasePresenter<V extends IBaseView> {

    private V view;

    public void onAttach(V view) {
        this.view = view;
    }

    public void onDetach() {
        view = null;
    }

    public V getView() {
        return view;
    }
}
