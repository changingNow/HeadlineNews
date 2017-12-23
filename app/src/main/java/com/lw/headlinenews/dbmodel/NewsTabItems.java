package com.lw.headlinenews.dbmodel;

import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;

import com.lw.headlinenews.BR;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;

/**
 * Created by lw on 17-11-29.
 */
@Table(database = HNDatabase.class)
public class NewsTabItems extends BaseDbModel implements Observable {
    public static final int ENABLE = 1;

   private PropertyChangeRegistry registry =  new PropertyChangeRegistry();

    @Column
    @Bindable
    public String tabItemName;

    @Column
    @Bindable
    public String tabItemId;

    @Column
    @Bindable
    public int isEnable; // 1 means enable, 0 means not enable

    @Bindable
    public boolean editing;

    @Bindable
    public String getTabItemName() {
        return tabItemName;
    }

    public void setTabItemName(String tabItemName) {
        this.tabItemName = tabItemName;
        registry.notifyChange(this, BR.tabItemName);
    }

    public String getTabItemId() {
        return tabItemId;
    }

    public void setTabItemId(String tabItemId) {
        this.tabItemId = tabItemId;
        registry.notifyChange(this, BR.tabItemId);
    }

    public int getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(int isEnable) {
        this.isEnable = isEnable;
        registry.notifyChange(this, BR.isEnable);
    }

    @Bindable
    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
        registry.notifyChange(this, BR.editing);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.add(onPropertyChangedCallback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback) {
        registry.remove(onPropertyChangedCallback);
    }
}
