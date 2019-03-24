package com.team.azusa.yiyuan.adapter;

import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragmentList;

    public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.mFragmentList = fragmentList;
        fm.beginTransaction().commitAllowingStateLoss();
    }

    @Override
    public Fragment getItem(int position) {
        return this.mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return this.mFragmentList.size();
    }

    @Override
    public int getItemPosition(Object object) {
        return PagerAdapter.POSITION_NONE;
    }


    public void refresh(List<Fragment> fragmentList) {
        this.mFragmentList = fragmentList;
        notifyDataSetChanged();
    }
}
