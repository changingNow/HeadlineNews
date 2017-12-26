package com.lw.headlinenews.module.news;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.lw.headlinenews.R;
import com.lw.headlinenews.adapter.BasePageAdapter;
import com.lw.headlinenews.dbmodel.NewsTabItems;
import com.lw.headlinenews.event.NewsChannelSavedEvent;
import com.lw.headlinenews.helper.TabItemsHelper;
import com.lw.headlinenews.module.news.article.NewsArticleListFragment;
import com.lw.headlinenews.module.news.channel.AddChannelActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by lw on 17-11-27.
 */

public class NewsTabLayout extends Fragment implements View.OnClickListener {

    private static final String TAG = "NewsTabLayout";

    private TabLayout newsTab;
    private ViewPager newsViewPager;
    private List<String> titleList;
    private List<Fragment> fragmentList;
    private ImageButton newsAddChannel;
    private BasePageAdapter adapter;
    private Map<String, Fragment> map = new HashMap<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_tablayout, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        newsTab = view.findViewById(R.id.news_tab);
        newsAddChannel = view.findViewById(R.id.news_add_item);
        newsViewPager = view.findViewById(R.id.news_viewpager);
        newsTab.setupWithViewPager(newsViewPager);
        newsTab.setTabMode(TabLayout.MODE_SCROLLABLE);
        initTabs();
        adapter = new BasePageAdapter(getChildFragmentManager(), fragmentList, titleList);
        newsViewPager.setAdapter(adapter);
        newsViewPager.setOffscreenPageLimit(3);
        newsAddChannel.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    private void initTabs() {
        List<NewsTabItems> newsTabItems = TabItemsHelper.getNewsTabItems();
        titleList = new ArrayList<>();
        fragmentList = new ArrayList<>();
        for (NewsTabItems item : newsTabItems) {
            Fragment fragment = null;
            String tabItemId = item.tabItemId;
            if (tabItemId.equals("question_and_answer") || tabItemId.equals("video") || tabItemId.equals("essay_joke")) {
                continue;
            }
            if (map.containsKey(tabItemId)) {
                fragment = map.get(tabItemId);
            } else {
                fragment = NewsArticleListFragment.getInstance(item.tabItemId);
            }
            fragmentList.add(fragment);
            titleList.add(item.tabItemName);
            if (fragment != null) {
                map.put(tabItemId, fragment);
            }
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(getActivity(), AddChannelActivity.class));
        startActivity(intent);
    }

    @Subscribe
    public void OnNewsChannelSaved(NewsChannelSavedEvent event) {
        if (adapter != null && event.successful) {
            titleList.clear();
            fragmentList.clear();
            initTabs();
            adapter.recreateTabs(fragmentList, titleList);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
