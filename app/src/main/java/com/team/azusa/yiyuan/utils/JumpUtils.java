package com.team.azusa.yiyuan.utils;

import android.content.Context;
import android.content.Intent;

import com.team.azusa.yiyuan.yiyuan_activity.ConfirmationActivity;

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
}
