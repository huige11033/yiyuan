package com.team.azusa.yiyuan;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    public String TAG = getClass().getSimpleName();
    public Activity mContext;

    protected View view;

    public abstract int layout();

    public abstract void initView();

    public abstract void initData();

    public abstract void setListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        mContext = this;
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
        setListener();
    }

    @Override
    public void onDestroy() {
        OkHttpUtils.getInstance().cancelTag(TAG);
        super.onDestroy();
        unbinder.unbind();
    }
}
