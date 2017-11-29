package com.example.lw.headlinenews.helper;


import android.content.Context;

import com.example.lw.headlinenews.HNApplication;
import com.example.lw.headlinenews.R;
import com.example.lw.headlinenews.dbmodel.NewsTabItems;
import com.example.lw.headlinenews.dbmodel.NewsTabItems_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by lw on 17-11-28.
 */

public class TabItemsHelper {
    public static List<NewsTabItems> getNewsTabItems() {
        List<NewsTabItems> newsTabItems = SQLite.select().from(NewsTabItems.class).where(NewsTabItems_Table.isEnable.eq(1)).queryList();
        if (newsTabItems == null || newsTabItems.size() <= 0) {
            firstNewsItemInsert();
            return SQLite.select().from(NewsTabItems.class).where(NewsTabItems_Table.isEnable.eq(1)).queryList();
        }
        return newsTabItems;
    }

    private static void firstNewsItemInsert() {
        Context context = HNApplication.getAppContext();
        String[] newsName = context.getResources().getStringArray(R.array.news_name);
        String[] newsId = context.getResources().getStringArray(R.array.news_id);
        for (int i = 0; i < 8; i++) {
            NewsTabItems tabItems = new NewsTabItems();
            tabItems.tabItemName = newsName[i];
            tabItems.tabItemId = newsId[i];
            tabItems.isEnable = 1;
            tabItems.insert();
        }
    }
}
