package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.base.BaseActivity;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.JumpUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.widget.ClearEditText;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmationActivity extends BaseActivity {

    @Bind(R.id.confirmation_edit)
    @BindView(R.id.confirmation_edit)
    ClearEditText confirmationEdit;
    @Bind(R.id.confirmation_second)
    @BindView(R.id.confirmation_second)
    TextView confirmationSecond;
    @Bind(R.id.tx1)
    @BindView(R.id.tx1)
    TextView tx1;
    @Bind(R.id.tx2)
    @BindView(R.id.tx2)
    TextView tx2;
    @Bind(R.id.confirmation_again)
    @BindView(R.id.confirmation_again)
    Button confirmation_again;
    private String phone;
    private String type;
    int second = 120 - (int) (System.currentTimeMillis() - ConstanceUtils.THE_COUNT_DOWN_TIME) / 1000;
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (second == 0) {
                tx1.setText("如未收到验证短信，请");
                confirmationSecond.setVisibility(View.GONE);
                tx2.setText("点击重新发送。");
                confirmation_again.setEnabled(true);
                handler.removeCallbacks(this);
                return;
            }
            confirmationSecond.setText(second + "");
            second--;
            handler.postDelayed(this, 1000);
        }
    };

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        ButterKnife.bind(this);
    public int layout() {
        return R.layout.activity_confirmation;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        phone = getIntent().getStringExtra("phone");
        type = getIntent().getStringExtra("type");
        handler.post(runnable);
    }

    @Override
    public void setListener() {

    }

    @OnClick({R.id.return_confirmation, R.id.confirmation_ensuer, R.id.confirmation_again})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_confirmation:
                finish();
                break;
            case R.id.confirmation_again:
                updateSendAgainView();
                UserUtils.sendConfirmCodeTo(phone);
                break;
            case R.id.confirmation_ensuer:
                String confirmCode = confirmationEdit.getText().toString();
                if (confirmCode.length() < 6) {
                    MyToast.showToast("验证码长度不足");
                    return;
                }
                Map<String,String> params = new HashMap<>();
                params.put("msgCode",confirmCode);
                params.put("mobile",phone);
                RequestService.request(Config.CHECK_CODE_URL, params, TAG,
                        new RequestCallBack<String> (){
                    @Override
                    public void onError(String errMsg) {
                        MyToast.showToast(errMsg);
                    }

                    @Override
                    public void onResult(String result) {
                        JumpUtils.jumpNewPassword(ConfirmationActivity.this,phone,type,result);
                    }

                });
                break;
        }
    }

    private void updateSendAgainView() {
        second = 8;
        tx1.setText("如未收到验证短信，请在");
        confirmationSecond.setVisibility(View.VISIBLE);
        tx2.setText("秒后点击重新发送。");
        confirmation_again.setEnabled(false);
        handler.post(runnable);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 200 && resultCode == RESULT_OK) {
            setResult(RESULT_OK);
            finish();
        }
    }

    @Override
    protected void onPause() {
        handler.removeCallbacks(runnable);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        OkHttpUtils.getInstance().cancelTag("ConfirmationActivity");
        super.onDestroy();
    }
}
