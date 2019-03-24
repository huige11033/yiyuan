package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.FragmentAdapter;
import com.team.azusa.yiyuan.bean.BuyRecordInfo;
import com.team.azusa.yiyuan.fragment.choujiang.ChoujiangjiluFragment;
import com.team.azusa.yiyuan.fragment.choujiang.OldZhongjiangFragment;
import com.team.azusa.yiyuan.fragment.choujiang.ShaidanShareFragment;
import com.team.azusa.yiyuan.fragment.choujiang.ShangpingDetailFragment;
import com.team.azusa.yiyuan.utils.JsonUtils;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Azusa on 2016/2/5.
 */
public class YunRecordDetailActivity extends BaseActivity {

    @BindView(R.id.return_yundetail)
    ImageView btn_back;
    private BuyRecordInfo buyRecordInfo;

    @BindView(R.id.banner_view)
    Banner mBannerView;
    @BindView(R.id.view_pager)
    ViewPager mViewPager;
    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;
    //中心viewpager
    private List<Fragment> mFragmentList = new ArrayList<>();

    public void initData() {
        String data = getIntent().getStringExtra("product_data");
        buyRecordInfo = JsonUtils.getObjectfromString(data, BuyRecordInfo.class);
        initView();
    }

    @Override
    public int layout() {
        return R.layout.activity_yun_record;
    }

    public void initView() {
        setBannerData(buyRecordInfo);
        initTabViewPager();
    }

    public void setListener() {


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag("YunRecordDetailActivity");
    }

    @OnClick({R.id.return_yundetail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_yundetail:
                finish();
                break;
        }
    }

    /**
     * 设置Banner数据
     */
    private void setBannerData(BuyRecordInfo recordInfo) {
        List<String> images = new ArrayList<>();
        List<String> titles = new ArrayList<>();
        images.add(recordInfo.getProImgUrl());
        titles.add(recordInfo.getTitle());

        //设置样式(六种)
        mBannerView.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBannerView.setImages(images);
        mBannerView.setBannerTitles(titles);
        //设置动画(多种)
        mBannerView.setBannerAnimation(Transformer.Default);
        mBannerView.setDelayTime(3000);
        mBannerView.isAutoPlay(true);
        mBannerView.setIndicatorGravity(BannerConfig.RIGHT);
        mBannerView.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int index) {

            }
        }).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object url, ImageView imageView) {
                RequestOptions options = new RequestOptions()
//                        .placeholder(R.drawable.placeholder_home_banner)
//                        .error(R.drawable.placeholder_home_banner)
//                        .fallback(R.drawable.placeholder_home_banner)
                        .transform(new RoundedCorners(10));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                Glide.with(context).load((String) url).apply(options).into(imageView);
            }
        }).start();
    }

    /**
     * 初始化Tab和ViewPager
     */
    private void initTabViewPager() {
        List<String> mTabList = Arrays.asList(getResources().getStringArray(R.array.record_tab_title));
        mTabLayout.removeAllTabs();
        for (int i = 0; i < mTabList.size(); i++) {
            TabLayout.Tab tab = mTabLayout.newTab();
            tab.setCustomView(getTabView(i, mTabList.get(i)));
            mTabLayout.addTab(tab);
        }
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                View view = tab.getCustomView();
                if (null != view) {
                    TextView textView = view.findViewById(R.id.title_name);
                    TextView indicator = view.findViewById(R.id.indicator_view);
                    textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.red_title));
                    textView.getPaint().setFakeBoldText(true);
                    textView.setTextSize(18f);
                    indicator.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                if (null != view) {
                    TextView textView = view.findViewById(R.id.title_name);
                    textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.black_title));
                    textView.getPaint().setFakeBoldText(false);
                    textView.setTextSize(15f);
                    view.findViewById(R.id.indicator_view).setVisibility(View.GONE);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        Bundle bundle = new Bundle();
        ChoujiangjiluFragment choujiangjiluFragment = new ChoujiangjiluFragment();
        bundle.putSerializable("record", buyRecordInfo);
        choujiangjiluFragment.setArguments(bundle);
        mFragmentList.add(choujiangjiluFragment);
        mFragmentList.add(new ShangpingDetailFragment());
        mFragmentList.add(new OldZhongjiangFragment());
        mFragmentList.add(new ShaidanShareFragment());
        FragmentAdapter mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mFragmentAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = mTabLayout.getTabAt(position);
                if (tab != null) {
                    tab.select();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 自定义Tab的View
     */
    private View getTabView(int position, String title) {
        View view = View.inflate(getBaseContext(), R.layout.item_diagnose_tab_view, null);
        TextView textView = view.findViewById(R.id.title_name);
        TextView indicator = view.findViewById(R.id.indicator_view);
        textView.setText(title);
        if (position == 0) {
            textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.red_title));
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(18f);
            indicator.setVisibility(View.VISIBLE);
        }
        return view;
    }
}
