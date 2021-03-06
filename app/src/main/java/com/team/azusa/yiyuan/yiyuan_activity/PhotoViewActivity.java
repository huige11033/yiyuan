package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.TextView;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.photo_fragment.PhotoFragment;
import com.team.azusa.yiyuan.widget.HackyViewPager;

import java.util.ArrayList;

public class PhotoViewActivity extends AppCompatActivity {


    private HackyViewPager mViewpager;
    private FragmentPagerAdapter mFragmentpageAdapter;
    private int photo_count, photo_position;
    private ArrayList<String> photourl;
    private TextView tv_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_photo_view);
        initView();
        initData();
        setView();
        setListener();
    }

    private void setListener() {
        mViewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                tv_count.setText((arg0 + 1) + "/" + photo_count);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });

    }

    private void setView() {
        tv_count.setText(photo_position + 1 + "/" + photo_count);

        mFragmentpageAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return photourl.size();
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new PhotoFragment();
                Bundle bundl = new Bundle();
                bundl.putString("photourl", photourl.get(position));
                fragment.setArguments(bundl);
                return fragment;
            }
        };

        mViewpager.setAdapter(mFragmentpageAdapter);
        mViewpager.setCurrentItem(photo_position);
    }

    private void initData() {
        Intent intent = getIntent();
        photo_count = intent.getIntExtra("photo_count", -1);
        photo_position = intent.getIntExtra("photo_position", -1);
        photourl = new ArrayList<>();
        photourl = intent.getStringArrayListExtra("photourl");
    }

    private void initView() {
        tv_count = (TextView) findViewById(R.id.tv_photo_count);
        mViewpager = (HackyViewPager) findViewById(R.id.photo_viewpage);
    }

}
