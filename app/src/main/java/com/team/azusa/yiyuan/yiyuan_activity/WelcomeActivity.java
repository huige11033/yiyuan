package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.bean.User;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        turnToMainActivity();
        getUserId();
    }

    private void turnToMainActivity() {
        //获取屏幕宽度和高度
        DisplayMetrics outMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(outMetrics);
        ConstanceUtils.screenWidth = outMetrics.widthPixels;
        ConstanceUtils.screenHight = outMetrics.heightPixels;
        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void getUserId() {

    }
}
