package com.lw.headlinenews.module.photo;

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
 * Created by lw on 17-11-29.
 */

public class PhotoTabLayout extends Fragment {
    private TabLayout photoTab;
    private ViewPager photoViewPager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.photo_tablayout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        photoTab = view.findViewById(R.id.photo_tab);
        photoViewPager = view.findViewById(R.id.photo_viewpager);
        photoTab.setupWithViewPager(photoViewPager);
        photoTab.setTabMode(TabLayout.MODE_SCROLLABLE);
    }
}
