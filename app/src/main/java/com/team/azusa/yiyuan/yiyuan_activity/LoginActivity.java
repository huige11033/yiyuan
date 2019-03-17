package com.team.azusa.yiyuan.yiyuan_activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.azusa.yiyuan.app.UserManager;
import com.team.azusa.yiyuan.base.BaseActivity;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.database.SharedPreferenceData;
import com.team.azusa.yiyuan.event.LoginEvent;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.model.UserBean;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.StringUtil;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.widget.MyDialog;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

public class LoginActivity extends BaseActivity implements OnClickListener {

    private ImageView returnLogin;
    private Button buttonLogin;
    private EditText etUserName;
    private EditText eTpassword;
    private String username, password;
    private TextView TVForgetPassword, tvregister;
    private AlertDialog loding_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniView();
    }


    private void iniView() {
        returnLogin = (ImageView) findViewById(R.id.return_login);
        buttonLogin = (Button) findViewById(R.id.but_login);
        tvregister = (TextView) findViewById(R.id.tv_register);
        etUserName = (EditText) findViewById(R.id.username);
        eTpassword = (EditText) findViewById(R.id.password);
        TVForgetPassword = (TextView) findViewById(R.id.tv_forget_password);

        returnLogin.setOnClickListener(this);
        buttonLogin.setOnClickListener(this);
        tvregister.setOnClickListener(this);
        TVForgetPassword.setOnClickListener(this);
        etUserName.setText(SharedPreferenceData.getInstance().getLoginName(LoginActivity.this));
    }

    @Override
    public void onClick(View v) {
        // TODO 自动生成的方法存根
        switch (v.getId()) {
            case R.id.return_login:
                EventBus.getDefault().post(new LoginEvent(false));
                LoginActivity.this.finish();
                break;
            case R.id.but_login:
                loding_dialog = new MyDialog().showLodingDialog(LoginActivity.this);
                login();
                break;
            case R.id.tv_register:
                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent1);
                break;
            case R.id.tv_forget_password:
                Intent intent2 = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                startActivity(intent2);
                break;
            default:
                break;
        }
    }

    private void login() {
        username = etUserName.getText().toString();
        password = eTpassword.getText().toString();
        if (!StringUtil.isEmpty(username) && !StringUtil.isEmpty(password)) {
            Map<String,String> params = new HashMap<>();
            params.put("mobile",username);
            params.put("password",password);

            RequestService.request(Config.LOGIN_URL,params,TAG
                    , new RequestCallBack<UserBean>() {
                        @Override
                        public void onAfter() {
                            loding_dialog.dismiss();
                        }

                        @Override
                        public void onError(String errMsg) {

                        }

                        @Override
                        public void onResult(UserBean result) {
                            UserManager.getInstance().login(result);
                        }


                    });

//            OkHttpUtils.get().url(Config.IP + "/yiyuan/user_UserLogin")
//                    .addParams("loginName", username)
//                    .addParams("loginPwd", password).build().execute(new StringCallback() {
//                @Override
//                public void onError(Request request, Exception e) {
//                    MyToast.showToast("网络连接出错");
//                    loding_dialog.dismiss();
//                }
//
//                @Override
//                public void onResponse(String response) {
//                    loding_dialog.dismiss();
//                    try {
//                        JSONObject jsonObject = new JSONObject(response);
//                        String loginResponses = jsonObject.get("messageInfo").toString();
//                        if ("成功".equals(loginResponses)) {
//                            ObjectMapper mapper = new ObjectMapper();
//                            UserUtils.userisLogin = true;
//                            String userJson = jsonObject.get("user").toString();
//                            UserUtils.user = mapper.readValue(userJson, User.class);
//
//                            //JPush设置用户别名，后台用UserID当做别名区分唯一用户
//                            JPushInterface.setAlias(ConstanceUtils.CONTEXT, UserUtils.user.getId(), null);
//
//                            EventBus.getDefault().post(new LoginEvent(true));
//                            //保存用户名
//                            SharedPreferenceData.getInstance().saveLoginName(LoginActivity.this, username);
//                            finish();
//                        }
//                        if ("用户名不存在".equals(loginResponses) || "密码不正确".equals(loginResponses) || "服务器出错，请稍后重试".equals(loginResponses)) {
//                            MyToast.showToast(loginResponses);
//                        }
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    } catch (JsonMappingException e) {
//                        e.printStackTrace();
//                    } catch (JsonParseException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
        }
        else {
            MyToast.showToast("用户名或密码不能为空");
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            EventBus.getDefault().post(new LoginEvent(false));
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
