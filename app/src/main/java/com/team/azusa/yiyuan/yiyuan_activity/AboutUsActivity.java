package com.team.azusa.yiyuan.yiyuan_activity;

import com.facebook.drawee.view.SimpleDraweeView;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.utils.ImageLoader;

import butterknife.BindView;
import butterknife.OnClick;

public class AboutUsActivity extends BaseActivity {

    @BindView(R.id.iv_tdcode)
    SimpleDraweeView TDCode;

    @Override
    public int layout() {
        return R.layout.activity_about_us;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        String url = getIntent().getStringExtra("url");

        ImageLoader.getInstance().displayImage(url, TDCode);
    }

    @Override
    public void setListener() {

    }

    @OnClick(R.id.return_about_us)
    public void onClick() {
        finish();
    }
}
