package com.team.azusa.yiyuan;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity {
    private Unbinder unbinder;

    protected View view;

    public abstract int layout();

    public abstract void initView();

    public abstract void initData();

    public abstract void setListener();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout());
        unbinder = ButterKnife.bind(this);
        initView();
        initData();
        setListener();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
