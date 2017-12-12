package com.lw.headlinenews.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by lw on 17-12-12.
 */

public abstract class BaseDataBindingActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    protected abstract int getRootLayout();
}
