package com.team.azusa.yiyuan.config;

/**
 * Created by Azusa on 2016/1/22.
 */
public class Config {
//        public static String IP = "http://192.168.1.110:8080";
//    public static final String IP = "http://115.29.112.36";
    public static String IP = "http://116.89.242.19";
//    public static final String IP = "http://charles95.cn";


    // 是否开启无图模式
    public static boolean isNoDownload;


    public static String LOGIN_URL = IP + "/app/login/login";
    //发送验证码
    public static String SEND_CODE_URL = IP + "/app/register/sendCode";
    //验证验证码
    public static String CHECK_CODE_URL = IP + "/app/register/checkMsg";
    //重设密码
    public static String SAVE_PASSWORD_URL = IP + "/app/register/savePasswd";
    //晒单列表
    public static String SHARE_LIST_URL = IP + "/app/share/findByAudit";
    //广告列表
    public static String AD_LIST_URL = IP + "/app/index/findByAdv";
    //热门礼品
    public static String PRODUCT_HOT_LIST_URL = IP + "/app/index/findHotProduct";
    //新品上线
    public static String PRODUCT_NEW_LIST_URL = IP + "/app/index/findLastestPubProduct";
    //全部商品分类
    public static String PRODUCT_CATEGORY_LIST_URL = IP + "/app/category/findCategoryList";
    //全部商品
    public static String PRODUCT_ALL_LIST_URL = IP + "/app/category/findProductByCategory";

    // 抽奖记录
    public static String CHOUJIANG_JILU_URL = IP + "/app/member/findUserYgByUserId";
}
