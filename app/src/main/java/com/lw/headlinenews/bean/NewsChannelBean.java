package com.lw.headlinenews.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.lw.headlinenews.BR;

/**
 * Created by lw on 17-12-22.
 */

public class NewsChannelBean extends BaseObservable {
    private String name;
    private boolean enable;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
        notifyPropertyChanged(BR.enable);
    }
}
