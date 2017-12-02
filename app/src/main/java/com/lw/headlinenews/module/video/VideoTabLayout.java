package com.lw.headlinenews.module.video;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lw.headlinenews.R;
import com.lw.headlinenews.dbmodel.NewsTabItems;
import com.lw.headlinenews.helper.TabItemsHelper;

import java.util.List;

/**
 * Created by lw on 17-11-29.
 */

public class VideoTabLayout extends Fragment {
    private TabLayout videoTab;
    private ViewPager videoViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.video_tablayout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        videoTab = view.findViewById(R.id.video_tab);
        videoViewPager = view.findViewById(R.id.video_viewpager);
        videoTab.setupWithViewPager(videoViewPager);
        videoTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        List<NewsTabItems> newsTabItems = TabItemsHelper.getNewsTabItems();
    }

}
