package com.team.azusa.yiyuan.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.team.azusa.yiyuan.yiyuan_activity.ConfirmationActivity;
import com.team.azusa.yiyuan.yiyuan_activity.HelpCenterActivity;
import com.team.azusa.yiyuan.yiyuan_activity.NewPasswordActivity;
import com.team.azusa.yiyuan.yiyuan_activity.ShowOrderActivity;

/**
 * @author : chenru
 * @功能描述:
 * @创建时间: 2019/3/17
 */
public class JumpUtils {

    public static void jumpConfirmation(Context context,String phone,String type){
        Intent intent = new Intent(context, ConfirmationActivity.class);
        intent.putExtra("phone",phone);
        intent.putExtra("type",type);
        context.startActivity(intent);
    }

    public static void jumpNewPassword(Activity activity,
                                       String phone, String type,String time){
        Intent intent = new Intent(activity, NewPasswordActivity.class);
        intent.putExtra("phone", phone);
        intent.putExtra("time", time);
        activity.startActivityForResult(intent, 200);
    }


    //跳转到所有晒单页面
    public static void jumpShowOrder(Context context) {
        Intent intent = new Intent(context, ShowOrderActivity.class);
        context.startActivity(intent);
    }
    //跳转到帮助中心
    public static void jumpHelpCenter(Context context) {
        Intent intent = new Intent(context, HelpCenterActivity.class);
        context.startActivity(intent);
    }
}
