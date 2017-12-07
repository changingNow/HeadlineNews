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
import com.lw.headlinenews.adapter.BasePageAdapter;
import com.lw.headlinenews.dbmodel.NewsTabItems;
import com.lw.headlinenews.helper.TabItemsHelper;
import com.lw.headlinenews.module.news.article.NewsArticleListFragment;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by lw on 17-11-27.
 */

public class NewsTabLayout extends Fragment {

    private TabLayout newsTab;
    private ViewPager newsViewPager;
    private List<String> titleList;
    private List<Fragment> fragmentList;

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
        initTabs();
        newsViewPager.setAdapter(new BasePageAdapter(getFragmentManager(), fragmentList, titleList));
    }

    private void initTabs() {
        List<NewsTabItems> newsTabItems = TabItemsHelper.getNewsTabItems();
        titleList = new ArrayList<>();
        fragmentList = new ArrayList<>();
        for (NewsTabItems item : newsTabItems) {
            Fragment fragment = null;
            switch (item.tabItemId){
                case "question_and_answer":
                    break;
                case "":
                case "essay_joke":
                    break;
                default:
                    fragment = NewsArticleListFragment.getInstance(item.tabItemId);
            }
            titleList.add(item.tabItemName);
            fragmentList.add(fragment);
        }
    }

}
