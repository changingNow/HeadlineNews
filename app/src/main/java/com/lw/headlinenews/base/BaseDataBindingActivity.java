package com.lw.headlinenews.base;


import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by lw on 17-12-12.
 */

public abstract class BaseDataBindingActivity<B extends ViewDataBinding> extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        B binding = (B)DataBindingUtil.setContentView(this, getRootLayout());
        initViews(binding);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    protected abstract int getRootLayout();

    protected abstract void initViews(B binding);

    protected abstract void initData();

}
