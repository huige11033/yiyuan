package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;

import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.widget.ClearEditText;

import butterknife.BindView;
import butterknife.OnClick;

public class AlterQQActivity extends BaseActivity {

    @BindView(R.id.qq_ET)
    ClearEditText qqET;
    private String qq;

    @Override
    public int layout() {
        return R.layout.activity_alter_qq;
    }

    @Override
    public void initView() {
        qqET.setText(UserUtils.user.getQQ());
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            qq_finish("Not_change");
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void qq_finish(String value) {
        Intent intent = new Intent();
        intent.putExtra("result", value);
        setResult(100, intent);//设置返回数据，100可以随便改，用于确定是何处调用。
        finish();
    }

    @OnClick({R.id.qq_return, R.id.qq_finsh})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.qq_return:
                qq_finish("Not_change");
                break;
            case R.id.qq_finsh:
                qq = qqET.getText().toString();
                UserUtils.user.setQQ(qq);
                qq_finish("qq");
                break;
        }
    }
}
