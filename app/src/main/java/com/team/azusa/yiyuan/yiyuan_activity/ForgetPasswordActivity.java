package com.team.azusa.yiyuan.yiyuan_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.utils.StringUtil;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.widget.ClearEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class ForgetPasswordActivity extends BaseActivity {

   
    @BindView(R.id.forgetPassword_edit)
    ClearEditText forgetPasswordEdit;
   

    @Override
   public int layout() {
        return R.layout.activity_forget_password;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.return_forgetPassword, R.id.forgetPassword_ensure})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_forgetPassword:
                finish();
                break;
            case R.id.forgetPassword_ensure:
                if (ConstanceUtils.THE_COUNT_DOWN_TIME != 0L &&
                        System.currentTimeMillis() - ConstanceUtils.THE_COUNT_DOWN_TIME < 120000) {
                    MyToast.showToast_center("不能过频繁请求");
                    return;
                }
                final String Phone = forgetPasswordEdit.getText().toString();
                if (!StringUtil.isMobileNo(Phone)) {
                    MyToast.showToast("号码不是手机号");
                    return;
                }
                Map<String,String> params = new HashMap<>();
                params.put("mobile",Phone);
                params.put("act","restpwd");

                RequestService.request(Config.IP + "/app/register/sendCode",params,TAG
                        , new RequestCallBack<String>() {
                            @Override
                            public void onError(String errMsg) {
                                MyToast.showToast(errMsg);
                            }

                            @Override
                            public void onResult(String result) {
                                MyToast.showToast("修改成功!");
                                finish();
                            }


                        });
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == RESULT_OK) {
            finish();
        }
    }

}
