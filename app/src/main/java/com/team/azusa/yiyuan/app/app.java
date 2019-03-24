package com.team.azusa.yiyuan.app;

import android.app.Application;
import android.app.Notification;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.squareup.okhttp.OkHttpClient;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.database.SharedPreferenceData;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.PersistentCookieStore;

import java.net.CookieManager;
import java.net.CookiePolicy;

import androidx.multidex.MultiDex;
import cn.jpush.android.api.BasicPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

//import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Azusa on 2016/2/5.
 */
public class app extends Application {
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.primary, android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化全局Context对象
        ConstanceUtils.CONTEXT = getApplicationContext();
        //初始化Fresco
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(ConstanceUtils.CONTEXT, config);
        //添加请求自动带上cookie
        OkHttpClient client = OkHttpUtils.getInstance().getOkHttpClient();
        client.setCookieHandler(new CookieManager(
                new PersistentCookieStore(ConstanceUtils.CONTEXT),
                CookiePolicy.ACCEPT_ALL));
        //从SharedPreference中读取app是否开启无图模式
        Config.isNoDownload = SharedPreferenceData.getInstance().isUserDownloadImage(ConstanceUtils.CONTEXT);

        //初始化JPush代码
//        JPushInterface.setDebugMode(true);//设置为debug模式可以查看log日志
//        JPushInterface.init(getApplicationContext());
//        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(getApplicationContext());
//        builder.statusBarDrawable = R.drawable.yyg_logo;
//        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
//                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
//        builder.notificationDefaults = Notification.DEFAULT_SOUND
//                | Notification.DEFAULT_VIBRATE
//                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
//        JPushInterface.setPushNotificationBuilder(1, builder);

//        //初始化内存检测工具
//        LeakCanary.install(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
