package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.event.AddCarsEvent;
import com.team.azusa.yiyuan.event.IntParameterEvent;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.DepthPageTransformer;
import com.team.azusa.yiyuan.widget.BadgeView;
import com.team.azusa.yiyuan.yiyuan_mainfragment.AllGoodsFragment;
import com.team.azusa.yiyuan.yiyuan_mainfragment.CartFragment;
import com.team.azusa.yiyuan.yiyuan_mainfragment.DiscoveryFragment;
import com.team.azusa.yiyuan.yiyuan_mainfragment.HomeFragment;
import com.team.azusa.yiyuan.yiyuan_mainfragment.MeFragment;
import com.team.azusa.yiyuan.yiyuan_mainfragment.NewestFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class MainActivity extends BaseActivity {
    private ViewPager mViewPager;
    private FragmentPagerAdapter mAdapter;
    private ArrayList<Fragment> mFragments;

    @BindViews({R.id.id_tab_home, R.id.id_all_goods, R.id.id_tab_newest, R.id.id_tab_cart, R.id.id_tab_me})
    List<LinearLayout> mTabs;

    @BindViews({R.id.id_tab_home_img, R.id.id_all_goods_img, R.id.id_tab_newest_img, R.id.id_tab_cart_img, R.id.id_tab_me_img})
    List<ImageButton> mImgs;

    @BindViews({R.id.text_home, R.id.text_all_goods, R.id.text_newest, R.id.text_cart, R.id.text_me})
    List<TextView> mTextViews;

    private int[] car_location; //购物车的位置
    public int car_count; //购物车商品个数
    private BadgeView badge; //购物车商品个数小圆点
    private int selectIndex = 0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == 20) {
            int result = data.getIntExtra("result", 0);
            setSelect(result);
        }
        if (resultCode == 111) {
            setSelect(3);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    //获取购物车位置
    public int[] getCar_location() {
        car_location = new int[2];
        mTabs.get(3).getLocationInWindow(car_location);
        return car_location;
    }

    //eventbus接收购物车页面发来的添加个数,修改购物车小红点上显示数
    public void onEventMainThread(AddCarsEvent event) {
        if (0 == event.getCount()) {
            car_count = 0;
        } else {
            car_count = car_count + event.getCount();
        }
        ConstanceUtils.carcount = car_count;
        badge.setBadgeCount(car_count);
    }

    //eventbus接收购物车页面发来的消息,确定要跳转到哪个Fragment
    public void onEventMainThread(IntParameterEvent event) {
        setSelect(event.getI());
    }

    public void setListener() {
        setSelect(selectIndex);
        badge = new BadgeView(ConstanceUtils.CONTEXT);
        badge.setTargetView(mTabs.get(3));
        badge.setBackgroundResource(R.drawable.cart_count_bg);
        badge.setBadgeMarginRight(16);
    }

    @OnClick({R.id.id_tab_home, R.id.id_all_goods, R.id.id_tab_newest, R.id.id_tab_cart, R.id.id_tab_me})
    public void click(View v) {
        switch (v.getId()) {
            case R.id.id_tab_home:
                setSelect(0);
                break;
            case R.id.id_all_goods:
                setSelect(1);
                break;
            case R.id.id_tab_newest:
                setSelect(2);
                break;
            case R.id.id_tab_cart:
                setSelect(3);
                break;
            case R.id.id_tab_me:
                setSelect(4);
                break;
            default:
                break;
        }
    }

    @Override
    public int layout() {
        return R.layout.activity_main;
    }

    public void initView() {
        mViewPager = findViewById(R.id.id_viewpager);

        mFragments = new ArrayList<>();
        Fragment mTab01 = new HomeFragment();
        Fragment mTab02 = new AllGoodsFragment();
        Fragment mTab03 = new DiscoveryFragment();
        Fragment mTab04 = new CartFragment();
        Fragment mTab05 = new MeFragment();

        mFragments.add(mTab01);
        mFragments.add(mTab02);
        mFragments.add(mTab03);
        mFragments.add(mTab04);
        mFragments.add(mTab05);

        mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mFragments.get(arg0);
            }
        };
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(true, new DepthPageTransformer());
        mViewPager.setOnPageChangeListener(new OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                setSelect(currentItem);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
        mViewPager.setOffscreenPageLimit(5);
    }

    @Override
    public void initData() {
        EventBus.getDefault().register(this);
    }

    private void setSelect(int i) {
        mImgs.get(selectIndex).setSelected(false);
        mTextViews.get(selectIndex).setEnabled(false);

        mImgs.get(i).setSelected(true);
        mTextViews.get(i).setEnabled(true);

        if (i != mViewPager.getCurrentItem())
            mViewPager.setCurrentItem(i, false);
        selectIndex = i;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
