package com.lw.headlinenews;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.lw.headlinenews.base.BaseActivity;
import com.lw.headlinenews.bean.NewsArticleParcelableBean;
import com.lw.headlinenews.event.NewsItemClickEvent;
import com.lw.headlinenews.event.NewsItemShareClickEvent;
import com.lw.headlinenews.module.news.NewsTabLayout;
import com.lw.headlinenews.module.news.article.NewsDetailWebActivity;
import com.lw.headlinenews.module.photo.PhotoTabLayout;
import com.lw.headlinenews.module.video.VideoTabLayout;
import com.lw.headlinenews.utils.AppConstant;
import com.lw.headlinenews.utils.BeanFormate;

import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup bottomMenu;
    private DrawerLayout drawer;
    private NewsTabLayout newsTabLayout;
    private VideoTabLayout videoTabLayout;
    private PhotoTabLayout photoTabLayout;
    private String POSITION = "position";
    private String CURRENT_ID = "id";
    private int position = 0;//

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setContentFragment(savedInstanceState);
    }

    private void setContentFragment(Bundle savedInstanceState) {
        FragmentManager fragmentManager = getSupportFragmentManager();
//        if (savedInstanceState != null) {
//            newsTabLayout = (NewsTabLayout)fragmentManager.findFragmentByTag(NewsTabLayout.class.toString());
//            videoTabLayout = (VideoTabLayout)fragmentManager.findFragmentByTag(VideoTabLayout.class.toString());
//            photoTabLayout = (PhotoTabLayout)fragmentManager.findFragmentByTag(PhotoTabLayout.class.toString());
//            int position = savedInstanceState.getInt(POSITION);
//            int id = savedInstanceState.getInt(CURRENT_ID);
//            switchFragment(position);
//            bottomMenu.check(id);
//        } else {
        fragmentManager.beginTransaction().add(R.id.content_container, new NewsTabLayout()).commit();
//        }
    }

    private void switchFragment(int position) {

    }

    private void initViews() {
        bottomMenu = (RadioGroup) findViewById(R.id.bottom_menus);
        bottomMenu.setOnCheckedChangeListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        initToolBar(toolbar, true, getResources().getString(R.string.menu));
        initDrawerLayout(toolbar);
    }

    private void initDrawerLayout(Toolbar toolbar) {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawerToggle.syncState();// use for change the state of back button
        NavigationView navigationMenu = (NavigationView) findViewById(R.id.nav_main);
        navigationMenu.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_switch_night_mode:
                break;
            case R.id.nav_setting:
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_about:
                break;
            case R.id.nav_exit:
                onBackPressed();
                break;
        }
        drawer.closeDrawers();
        return false;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.menu_news:
                break;
            case R.id.menu_pic:
                break;
            case R.id.menu_video:
                break;
            case R.id.menu_media:
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(POSITION, position);
        outState.putInt(CURRENT_ID, bottomMenu.getCheckedRadioButtonId());
    }

    @Subscribe
    public void onNewsItemClickEvent(NewsItemClickEvent event) {
        Intent intent = new Intent();
        NewsArticleParcelableBean parcelableBean = new NewsArticleParcelableBean();
        BeanFormate.formateToParcelableArticleBean(event.getDataBean(), parcelableBean);
        Bundle bundle = new Bundle();
        bundle.putParcelable(AppConstant.NEWS_ARTICLE_PARCEABLE_BEAN_KEY, parcelableBean);
        intent.putExtra(AppConstant.NEWS_INTENT_BUNDLE_KEY, bundle);
        intent.setComponent(new ComponentName(this, NewsDetailWebActivity.class));
        startActivity(intent);
    }

    @Subscribe
    public void onNewsItemShareClickEvent(NewsItemShareClickEvent event) {
        Log.d("tag", "========onItemShareClickEvent======"+event.getBean().getShareUrl());
    }
}
