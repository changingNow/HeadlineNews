package com.lw.headlinenews.module.news;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lw.headlinenews.R;


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
        return view;
    }

    private void initView(View view) {
        newsTab = view.findViewById(R.id.news_tab);
        newsViewPager = view.findViewById(R.id.news_viewpager);
        newsTab.setupWithViewPager(newsViewPager);
        newsTab.setTabMode(TabLayout.MODE_SCROLLABLE);

    }

}
