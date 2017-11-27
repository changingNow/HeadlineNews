package com.example.lw.headlinenews;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.RadioGroup;

import com.example.lw.headlinenews.base.BaseActivity;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, RadioGroup.OnCheckedChangeListener {

    private RadioGroup bottomMenu;
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
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
                drawer.closeDrawers();
                break;
            case R.id.nav_setting:
                drawer.closeDrawers();
                break;
            case R.id.nav_share:
                drawer.closeDrawers();
                break;
            case R.id.nav_about:
                drawer.closeDrawers();
                break;
            case R.id.nav_exit:
                onBackPressed();
                break;
        }
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
}
