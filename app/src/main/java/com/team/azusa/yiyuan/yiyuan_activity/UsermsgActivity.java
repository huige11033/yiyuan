package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.TabFragmentPagerAdapter;
import com.team.azusa.yiyuan.utils.ImageLoader;
import com.team.azusa.yiyuan.utils.StringUtil;
import com.team.azusa.yiyuan.yiyuan_usermsg_fragment.GainedgoodsFragment;
import com.team.azusa.yiyuan.yiyuan_usermsg_fragment.PlayRecordFragment;
import com.team.azusa.yiyuan.yiyuan_usermsg_fragment.ShareOrderFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class UsermsgActivity extends BaseActivity {

    @BindView(R.id.usermsg_userhead)
    SimpleDraweeView img_head;
    @BindView(R.id.vp_body)
    ViewPager viewpager;
    ArrayList<Fragment> fragmentsList;
    ArrayList<String> titles;
    private String user_id = "";
    private String username = "";
    private String user_headimgurl = "";

    @Override
    public int layout() {
        return R.layout.activity_usermsg;
    }

    public void initView() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        //使用CollapsingToolbarLayout必须把title设置到CollapsingToolbarLayout上，设置到Toolbar上则不会显示
        CollapsingToolbarLayout mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar_layout);
        mCollapsingToolbarLayout.setTitle(username);
        //通过CollapsingToolbarLayout修改字体颜色
        mCollapsingToolbarLayout.setExpandedTitleColor(Color.parseColor("#ffffff"));//设置还没收缩时状态下字体颜色
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.parseColor("#ff7700"));//设置收缩后Toolbar上字体的颜色

        //设置用户头像
        if (StringUtil.isEmpty(user_headimgurl)) {
            ImageLoader.getInstance().displayImage("res:///" + R.drawable.default_head_, img_head);
        } else {
            ImageLoader.getInstance().displayImage(user_headimgurl, img_head);
        }

        initViewPager();
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        username = intent.getStringExtra("user_name");
        user_id = intent.getStringExtra("user_id");
        user_headimgurl = intent.getStringExtra("userhead_img");
    }

    @Override
    public void setListener() {

    }

    private void initViewPager() {
        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tabs);
        titles = new ArrayList<>();
        titles.add("参与记录");
        titles.add("获得的商品");
        titles.add("晒单");

        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(titles.get(2)));

        mTabLayout.setTabTextColors(getResources().getColor(R.color.tabcolor), getResources().getColor(R.color.tabcolor_select));

        viewpager = (ViewPager) findViewById(R.id.vp_body);
        viewpager.setOffscreenPageLimit(3);
        fragmentsList = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", user_id);
        Fragment playRecordFragment = new PlayRecordFragment();
        Fragment gainedgoodsFragment = new GainedgoodsFragment();
        Fragment shareOrderFragment = new ShareOrderFragment();

        playRecordFragment.setArguments(bundle);
        gainedgoodsFragment.setArguments(bundle);
        shareOrderFragment.setArguments(bundle);

        fragmentsList.add(playRecordFragment);
        fragmentsList.add(gainedgoodsFragment);
        fragmentsList.add(shareOrderFragment);
        TabFragmentPagerAdapter tabFragmentPagerAdapter = new TabFragmentPagerAdapter(
                getSupportFragmentManager(), fragmentsList, titles);
        viewpager.setAdapter(new TabFragmentPagerAdapter(
                getSupportFragmentManager(), fragmentsList, titles));
        viewpager.setCurrentItem(0);

        mTabLayout.setupWithViewPager(viewpager);
        mTabLayout.setTabsFromPagerAdapter(tabFragmentPagerAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.toolbar_dot:
                Intent intent = new Intent(UsermsgActivity.this, UserVcardActivity.class);
                intent.putExtra("userId",user_id);
                intent.putExtra("headImg",user_headimgurl);
                intent.putExtra("userName",username);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.usermsg_userhead)
    public void onClick() {
        //点击头像，查看大图
        Intent photo = new Intent(UsermsgActivity.this, PhotoViewActivity.class);
        photo.putExtra("photo_count", 1);
        photo.putExtra("photo_position", 0);
        ArrayList<String> imgs = new ArrayList<>();
        imgs.add(user_headimgurl);
        photo.putStringArrayListExtra("photourl", imgs);
        startActivity(photo);
    }
}
