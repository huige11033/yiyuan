package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import android.view.KeyEvent;
import android.webkit.WebView;

import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.widget.MyDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class SettingHelpActivity extends BaseActivity {

    @BindView(R.id.webview)
    WebView webview;
    private MyDialog myDialog = new MyDialog();
    private AlertDialog loding_dialog;

    @Override
    public int layout() {
        return R.layout.activity_setting_help;
    }

    @Override
    public void initView() {
        loding_dialog = myDialog.showLodingDialog(this);
        loding_dialog.setOnKeyListener(backlistener);
        try {
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("http://192.168.1.110:8080/yiyuan/setting_help");
        } catch (Exception e) {
            MyToast.showToast("连接出错");
        } finally {
            myDialog.dismissDialog();
        }
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {

    }

    private DialogInterface.OnKeyListener backlistener = new DialogInterface.OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {  //表示按返回键 时的操作
                myDialog.dismissDialog();
                return false;    //已处理
            }
            return false;
        }
    };

    @OnClick(R.id.help_go_back)
    public void onClick() {
        finish();
    }

}
