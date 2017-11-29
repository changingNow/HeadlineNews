package com.example.lw.headlinenews.dbmodel;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by lw on 17-11-29.
 */

public class BaseDbModel extends BaseModel {

    //自增ID
    @PrimaryKey(autoincrement = true)
    public int uniqueId ;
    @Column
    public String createdAt;
    @Column
    public String updatedAt;

}
