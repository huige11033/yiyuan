package com.team.azusa.yiyuan.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zhy.http.okhttp.OkHttpUtils;

/**
 * @author : chenru
 * @功能描述:
 * @创建时间: 2019/3/12
 */
public class BaseActivity extends Activity {
    public String TAG = getClass().getSimpleName();
    public Activity mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    protected void onDestroy() {
        OkHttpUtils.getInstance().cancelTag(TAG);
        super.onDestroy();
    }
}
