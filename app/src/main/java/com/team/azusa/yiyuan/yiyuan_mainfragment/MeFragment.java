package com.team.azusa.yiyuan.yiyuan_mainfragment;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.bean.User;
import com.team.azusa.yiyuan.event.AddPhotoEvent;
import com.team.azusa.yiyuan.event.LoginEvent;
import com.team.azusa.yiyuan.utils.ImageLoader;
import com.team.azusa.yiyuan.utils.StringUtil;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.yiyuan_activity.AccountDetailsActivity;
import com.team.azusa.yiyuan.yiyuan_activity.LoginActivity;
import com.team.azusa.yiyuan.yiyuan_activity.MyAddressActivity;
import com.team.azusa.yiyuan.yiyuan_activity.MyBuyRecordActivity;
import com.team.azusa.yiyuan.yiyuan_activity.MyGaingoodsActivity;
import com.team.azusa.yiyuan.yiyuan_activity.MyShareOrderActivity;
import com.team.azusa.yiyuan.yiyuan_activity.SettingActivity;
import com.team.azusa.yiyuan.yiyuan_activity.UsermsgActivity;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;


public class MeFragment extends BaseFragment {

    @BindView(R.id.setting)
    ImageView btn_setting;  //设置按钮
    @BindView(R.id.login)
    Button btn_login;  //登陆按钮
    @BindView(R.id.layout_unlogin)
    LinearLayout layoutUnlogin;  //未登陆状态下的头部布局
    @BindView(R.id.my_head)
    RelativeLayout my_head; //登录后显示的头部
    @BindView(R.id.head)
    SimpleDraweeView head;  //用户头像
    @BindView(R.id.mobile)
    TextView mobile;//积分
    @BindView(R.id.score)
    TextView score;//积分

    @BindView(R.id.chongzhi)
    View chongzhi;  //登录后的充值按钮

    @BindView(R.id.chongzhijilu)
    RelativeLayout chongzhijilu; //充值记录
    @BindView(R.id.choujiangjilu)
    RelativeLayout choujiangjilu; //抽奖记录
    @BindView(R.id.xingyunjilu)
    RelativeLayout xingyunjilu; //幸运记录
    @BindView(R.id.dizhiguanli)
    RelativeLayout dizhiguanli; //地址管理
    @BindView(R.id.shaidanjilu)
    RelativeLayout shaidanjilu; //晒单记录
    @BindView(R.id.lebiduihuan)
    RelativeLayout lebiduihuan; //乐币兑换

    private User user;//用户对象

    @Override
    public int layout() {
        return R.layout.main_fgtab05;
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

    public void initView() {
        if (UserUtils.userisLogin) {
            setLoginView();
        } else {
            setUnLoginView();
        }
    }

    //eventbus接收选择图片界面发来的消息
    public void onEventMainThread(AddPhotoEvent event) {
        //更新头像
        ImageLoader.getInstance().displayImage(event.getImgurl().get(0), head);
    }

    //eventbus接收登陆界面发来的消息
    public void onEventMainThread(LoginEvent event) {
        if (event.isLoginSuccess()) {
            setLoginView();
        } else {
            setUnLoginView();
        }
    }

    //设置为登陆的界面
    private void setUnLoginView() {
        layoutUnlogin.setVisibility(View.VISIBLE);
        if (my_head.getVisibility() == View.VISIBLE) {
            my_head.setVisibility(View.GONE);
        }
    }

    //设置已登陆的界面
    private void setLoginView() {
        if (layoutUnlogin.getVisibility() == View.VISIBLE) {
            layoutUnlogin.setVisibility(View.GONE);
        }
        my_head.setVisibility(View.VISIBLE);
        user = UserUtils.user;
        //设置头像
        if (StringUtil.isEmpty(UserUtils.user.getImgUrl())) {
            ImageLoader.getInstance().displayImage("res:///" + R.drawable.default_head_, head);
        } else ImageLoader.getInstance().displayImage(UserUtils.user.getImgUrl(), head);

        //设置用户账号名
        if (StringUtil.isEmpty(user.getName())) {
            mobile.setText(user.getMobile());
        } else {
            mobile.setText(user.getName() + "(" + user.getMobile() + ")");
        }
        //设置用户等级
//        setUserLv(Img_yungouLv, tv_yungouLv, user.getJingyan());
//        //设置经验值
//        tv_exprence.setText(user.getJingyan() + "");
//        //设置可用福分
//        tvFufen.setText(user.getJifen() + "");
//        //设置可用余额
//        tvBalance.setText("￥" + user.getBalance() + ".00");
        score.setText(String.valueOf(user.getJifen()));
    }

    public void setUserLv(ImageView img_lv, TextView tv_lv, int exprence) {
        if (0 <= exprence && exprence <= 9999) {
            img_lv.setImageResource(R.drawable.degree1);
            tv_lv.setText("云购小将");
        } else if (exprence <= 99999) {
            img_lv.setImageResource(R.drawable.degree2);
            tv_lv.setText("云购少将");
        } else if (exprence <= 999999) {
            img_lv.setImageResource(R.drawable.degree3);
            tv_lv.setText("云购中将");
        } else if (exprence <= 9999999) {
            img_lv.setImageResource(R.drawable.degree4);
            tv_lv.setText("云购大将");
        } else if (exprence <= 99999999) {
            img_lv.setImageResource(R.drawable.degree5);
            tv_lv.setText("云购将军");
        } else {
            img_lv.setImageResource(R.drawable.degree6);
            tv_lv.setText("云购总司");
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    @OnClick({R.id.setting, R.id.login, R.id.head, R.id.chongzhi, R.id.chongzhijilu, R.id.xingyunjilu, R.id.lebiduihuan,
            R.id.dizhiguanli, R.id.shaidanjilu, R.id.choujiangjilu})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.setting:
                Intent intentsetting = new Intent(getActivity(), SettingActivity.class);
                startActivity(intentsetting);
                break;
            case R.id.login:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.head://点击头像
                Intent intent2 = new Intent(getActivity(), UsermsgActivity.class);
                intent2.putExtra("user_id", user.getId());
                if (StringUtil.isEmpty(user.getName())) {
                    intent2.putExtra("user_name", user.getMobileEx());
                } else {
                    intent2.putExtra("user_name", user.getName());
                }
                intent2.putExtra("userhead_img", user.getImgUrl());
                startActivity(intent2);
                break;
            case R.id.chongzhi:
                break;
            case R.id.choujiangjilu:
                Intent intent3;
                if (UserUtils.userisLogin) {
                    intent3 = new Intent(getActivity(), MyBuyRecordActivity.class);
                } else {
                    intent3 = new Intent(getActivity(), LoginActivity.class);
                }
                startActivity(intent3);
                break;
            case R.id.xingyunjilu:
                Intent intentme2;
                if (UserUtils.userisLogin) {
                    intentme2 = new Intent(getActivity(), MyGaingoodsActivity.class);
                } else {
                    intentme2 = new Intent(getActivity(), LoginActivity.class);
                }
                startActivity(intentme2);
                break;
            case R.id.shaidanjilu:
                Intent intentme3;
                if (UserUtils.userisLogin) {
                    intentme3 = new Intent(getActivity(), MyShareOrderActivity.class);
                } else {
                    intentme3 = new Intent(getActivity(), LoginActivity.class);
                }
                startActivity(intentme3);
                break;
            case R.id.lebiduihuan:
                break;
//            case R.id.me6:
//
//                Intent intentme6;
//                if (UserUtils.userisLogin) {
//                    intentme6 = new Intent(getActivity(), AccountDetailsActivity.class);
//                } else {
//                    intentme6 = new Intent(getActivity(), LoginActivity.class);
//                }
//                startActivity(intentme6);
//
//                break;
            case R.id.dizhiguanli:
                Intent intent1;
                if (UserUtils.userisLogin) {
                    intent1 = new Intent(getActivity(), MyAddressActivity.class);
                } else {
                    intent1 = new Intent(getActivity(), LoginActivity.class);
                }
                startActivity(intent1);
                break;
        }

    }

    @Override
    public boolean isUseEvent() {
        return true;
    }
}
