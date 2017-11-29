package com.example.lw.headlinenews.module.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lw.headlinenews.R;
import com.example.lw.headlinenews.dbmodel.NewsTabItems;
import com.example.lw.headlinenews.helper.TabItemsHelper;

import java.util.List;


/**
 * Created by lw on 17-11-27.
 */

public class NewsTabLayout extends Fragment {

    private TabLayout newsTab;
    private ViewPager newsViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_tablayout, container, false);
        initView(view);
        Log.d("tag", "============is here?");
        return view;
    }

    private void initView(View view) {
        newsTab = view.findViewById(R.id.news_tab);
        newsViewPager = view.findViewById(R.id.news_viewpager);
        newsTab.setupWithViewPager(newsViewPager);
        List<NewsTabItems> newsTabItems = TabItemsHelper.getNewsTabItems();
        Log.d("tag", "==========="+newsTabItems.size());
    }

}
