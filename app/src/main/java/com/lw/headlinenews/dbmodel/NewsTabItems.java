package com.lw.headlinenews.dbmodel;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.Table;

/**
 * Created by lw on 17-11-29.
 */
@Table(database = HNDatabase.class)
public class NewsTabItems extends BaseDbModel {
    public static final int ENABLE = 1;

    @Column
    public String tabItemName;

    @Column
    public String tabItemId;

    @Column
    public int isEnable; // 1 means enable, 0 means not enable
}
