package com.team.azusa.yiyuan.yiyuan_activity;

import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.utils.StringUtil;
import com.team.azusa.yiyuan.widget.ClearEditText;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

public class NewPasswordActivity extends BaseActivity {

    @BindView(R.id.newpass_edit)
    ClearEditText newpassEdit;
    @BindView(R.id.cb_newpass)
    CheckBox cbNewpass;

    private String phone;
    private int type;
    private String time;
    private boolean cancelrequest = false;

    @Override
    public int layout() {
        return R.layout.activity_new_password;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        phone = getIntent().getStringExtra("phone");
        type = getIntent().getIntExtra("type", 0);
        time = getIntent().getStringExtra("time");
    }

    @Override
    public void setListener() {
        cbNewpass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int type = isChecked ? (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD) :
                        (InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                newpassEdit.setInputType(type);
                newpassEdit.setSelection(newpassEdit.getText().toString().length());
            }
        });
    }

    @OnClick({R.id.return_newpassword, R.id.newpass_ensuer})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_newpassword:
                finish();
                break;
            case R.id.newpass_ensuer:
                final String pwd = newpassEdit.getText().toString();

                if (StringUtil.isEmail(pwd))
                    MyToast.showToast_center("密码不能为空");
                else if (pwd.length() < 8 || pwd.length() > 20)
                    MyToast.showToast_center("密码长度为8-20位");
                else if (!StringUtil.isTruePassword(pwd))
                    MyToast.showToast_center("密码由字母,数组或符号两种或以上组成");

                else {
                    Map<String, String> params = new HashMap<>();
                    params.put("time", time);
                    params.put("mobile", phone);
                    params.put("password", pwd);
                    params.put("yaoqingUserId", "");
                    RequestService.request(Config.SAVE_PASSWORD_URL, params, TAG,
                            new RequestCallBack<Boolean>() {
                        @Override
                        public void onError(String errMsg) {
                            MyToast.showToast(errMsg);
                        }

                        @Override
                        public void onResult(Boolean result) {
                            setResult(200);
                            finish();
                        }

                    });
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        OkHttpUtils.getInstance().cancelTag("NewPasswordActivity");
        super.onDestroy();
    }
}
