package com.team.azusa.yiyuan.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Azusa on 2016/1/24.
 */
public class TabFragmentPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentsList;
    private ArrayList<String> titles;

    public TabFragmentPagerAdapter(FragmentManager fm, ArrayList<Fragment> fragmentsList, ArrayList<String> titles) {
        super(fm);
        this.mFragmentsList = fragmentsList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);
    }
}
