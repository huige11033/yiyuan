package com.team.azusa.yiyuan.yiyuan_search_fragment;

import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.TabFragmentPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;


public class SearchRemindFragment extends BaseFragment {

    @BindView(R.id.tablayout_search)
    TabLayout tb_search;
    @BindView(R.id.vp_search)
    ViewPager mviewpager;
    ArrayList<Fragment> fragmentsList;
    ArrayList<String> titles;

    @Override
    public int layout() {
        return R.layout.search_fg1;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAnimation() {

    }

    @Override
    public void setListener() {

    }

    public void initView() {
        titles = new ArrayList<>();
        titles.add("最近搜索");
        titles.add("热门搜索");

        tb_search.addTab(tb_search.newTab().setText(titles.get(0)));
        tb_search.addTab(tb_search.newTab().setText(titles.get(1)));

        tb_search.setTabTextColors(getResources().getColor(R.color.tabcolor), getResources().getColor(R.color.tabcolor_select));

        mviewpager.setOffscreenPageLimit(2);
        fragmentsList = new ArrayList<Fragment>();
        Fragment recentSearchFragment = new RecentSearchFragment();
        Fragment hotSearchFragment = new HotSearchFragment();

        fragmentsList.add(recentSearchFragment);
        fragmentsList.add(hotSearchFragment);
        TabFragmentPagerAdapter tabFragmentPagerAdapter = new TabFragmentPagerAdapter(
                getActivity().getSupportFragmentManager(), fragmentsList, titles);
        mviewpager.setAdapter(new TabFragmentPagerAdapter(
                getActivity().getSupportFragmentManager(), fragmentsList, titles));
        mviewpager.setCurrentItem(0);

        tb_search.setupWithViewPager(mviewpager);
        tb_search.setTabsFromPagerAdapter(tabFragmentPagerAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
