package com.team.azusa.yiyuan.yiyuan_mainfragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.NewPublishLvAdapter;
import com.team.azusa.yiyuan.adapter.NewPublishedLvAdapter;
import com.team.azusa.yiyuan.bean.JieXiaoDto;
import com.team.azusa.yiyuan.bean.ProductDto;
import com.team.azusa.yiyuan.callback.DaoJiShiCallback;
import com.team.azusa.yiyuan.callback.JieXiaoCallback;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.listener.OnLoadListener;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.widget.MyDialog;
import com.team.azusa.yiyuan.widget.PulluptoRefreshListview;
import com.team.azusa.yiyuan.yiyuan_activity.GoodsDetailsActivity;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;

import androidx.appcompat.app.AlertDialog;
import butterknife.BindView;
import butterknife.OnClick;


public class DiscoveryFragment extends BaseFragment {


    @Override
    public int layout() {
        return R.layout.main_fg_discovery;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initAnimation() {

    }

    @Override
    public void setListener() {

    }
}
