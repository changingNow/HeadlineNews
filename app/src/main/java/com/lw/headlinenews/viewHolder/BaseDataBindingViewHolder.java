package com.lw.headlinenews.viewHolder;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;

/**
 * Created by lw on 17-12-6.
 */

public class BaseDataBindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {
    public T view;
    public BaseDataBindingViewHolder(T view) {
        super(view.getRoot());
        this.view = view;
    }
}
