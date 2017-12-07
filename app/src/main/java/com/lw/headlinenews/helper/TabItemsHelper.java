package com.lw.headlinenews.helper;


import android.content.Context;

import com.lw.headlinenews.HNApplication;
import com.lw.headlinenews.R;
import com.lw.headlinenews.dbmodel.NewsTabItems;
import com.lw.headlinenews.dbmodel.NewsTabItems_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

/**
 * Created by lw on 17-11-28.
 */

public class TabItemsHelper {
    private static final int ENABLE = 1;
    private static final int DISABLE = 0;
    private static final int DEFAULT_ENABLE_NUM = 8;
    public static List<NewsTabItems> getNewsTabItems() {
        List<NewsTabItems> newsTabItems = SQLite.select().from(NewsTabItems.class).where(NewsTabItems_Table.isEnable.eq(ENABLE)).queryList();
        if (newsTabItems == null || newsTabItems.size() <= 0) {
            firstNewsItemInsert();
            return SQLite.select().from(NewsTabItems.class).where(NewsTabItems_Table.isEnable.eq(ENABLE)).queryList();
        }
        return newsTabItems;
    }

    private static void firstNewsItemInsert() {
        Context context = HNApplication.getAppContext();
        String[] newsName = context.getResources().getStringArray(R.array.mobile_news_name);
        String[] newsId = context.getResources().getStringArray(R.array.mobile_news_id);
        for (int i = 0; i < DEFAULT_ENABLE_NUM; i++) {
            NewsTabItems tabItems = new NewsTabItems();
            tabItems.tabItemName = newsName[i];
            tabItems.tabItemId = newsId[i];
            tabItems.isEnable = ENABLE;
            tabItems.insert();
        }

        for (int i = DEFAULT_ENABLE_NUM; i < newsId.length; i++) {
            NewsTabItems tabItems = new NewsTabItems();
            tabItems.tabItemName = newsName[i];
            tabItems.tabItemId = newsId[i];
            tabItems.isEnable = DISABLE;
            tabItems.insert();
        }
    }
}
