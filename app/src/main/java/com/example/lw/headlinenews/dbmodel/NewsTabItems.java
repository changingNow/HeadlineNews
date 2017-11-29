package com.example.lw.headlinenews.dbmodel;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;

/**
 * Created by lw on 17-11-29.
 */
@Table(database = HNDatabase.class)
public class NewsTabItems extends BaseDbModel {
    @Column
    public String tabItemName;

    @Column
    public String tabItemId;

    @Column
    public int isEnable; // 1 means enable, 0 means not enable
}
