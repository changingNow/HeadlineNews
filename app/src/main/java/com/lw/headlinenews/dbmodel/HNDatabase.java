package com.lw.headlinenews.dbmodel;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by lw on 17-11-29.
 */
@Database(version = HNDatabase.VERSION, name = HNDatabase.NAME)
public class HNDatabase {
    public static final String NAME = "HNDatabase";
    public static final int VERSION = 1;
}
