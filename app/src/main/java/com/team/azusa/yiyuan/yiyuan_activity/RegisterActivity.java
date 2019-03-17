package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;


import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.event.LoginEvent;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.JumpUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.StringUtil;
import com.team.azusa.yiyuan.widget.ClearEditText;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class RegisterActivity extends BaseActivity {

    @BindView(R.id.regisiter_edit)
    ClearEditText regisiterEdit;
    @BindView(R.id.cb_newpass)
    CheckBox cbNewpass;
    @BindView(R.id.regisiter_ensure)
    Button ensure;


    @Override
    public int layout() {
        return R.layout.activity_register;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        cbNewpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ensure.setEnabled(isChecked);
            }
        });
    }

    @OnClick({R.id.return_regisiter, R.id.regisiter_ensure, R.id.regisiter_tx})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_regisiter:
                finish();
                break;
            case R.id.regisiter_tx:
                Intent service = new Intent(RegisterActivity.this, ServiceAgreementActivity.class);
                startActivity(service);
                break;
            case R.id.regisiter_ensure:
                if (ConstanceUtils.THE_COUNT_DOWN_TIME != 0L &&
                        System.currentTimeMillis() - ConstanceUtils.THE_COUNT_DOWN_TIME < 120000) {
                    MyToast.showToast_center("不能过频繁请求");
                    return;
                }
                final String Phone = regisiterEdit.getText().toString();
                if (!StringUtil.isMobileNo(Phone)) {
                    MyToast.showToast("号码不是手机号");
                    return;
                }
                Map<String,String>params = new HashMap<>();
                params.put("mobile",Phone);
                params.put("act","regist");

                RequestService.request(Config.SEND_CODE_URL,params,TAG
                , new RequestCallBack<String>() {
                            @Override
                            public void onError(String errMsg) {
                                MyToast.showToast(errMsg);
                            }

                            @Override
                            public void onResult(String result) {
                                EventBus.getDefault().post(new LoginEvent(true));
                                JumpUtils.jumpConfirmation(mContext,Phone,"regist");
                            }


                        });

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1000 && resultCode == RESULT_OK) {
            finish();
        }
    }
}
