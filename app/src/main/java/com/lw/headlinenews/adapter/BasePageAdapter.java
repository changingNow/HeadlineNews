package com.lw.headlinenews.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.List;

/**
 * Created by lw on 17-12-5.
 */

public class BasePageAdapter extends FragmentStatePagerAdapter {
    List<Fragment> fragmentList;
    List<String> titleList;

    public BasePageAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titleList == null ? 0 : titleList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }

    public void recreateTabs(List<Fragment> fragmentList, List<String> titleList) {
        this.fragmentList = fragmentList;
        this.titleList = titleList;
        notifyDataSetChanged();
    }
}
