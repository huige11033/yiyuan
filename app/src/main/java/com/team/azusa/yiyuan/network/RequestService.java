package com.team.azusa.yiyuan.network;

import android.util.Log;

import com.alibaba.fastjson.JSONObject;
import com.squareup.okhttp.MediaType;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.utils.SignUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * @author : chenru
 * @功能描述:
 * @创建时间: 2019/3/6
 */
public class RequestService {
    // 此secretKey由接口服务方提供
    private static String secretKey = "A49UcP73DH51fK74500W8WY422eCVCf9IL01OFc330b4c9T3R70U4PW70JcCD4EI";


    public static void request(String url, Map<String, String> params
            , String tag, final RequestCallBack callBack) {
        Log.d("RequestUrl--->", url);
        Log.d("RequestParams--->", showParams(params));

        OkHttpUtils.postString().mediaType(MediaType.parse("application/json")).tag(tag)
                .url(url)
                .content(JSONObject.toJSONString(SignUtil.doSign(secretKey, params)))
                .build().execute(callBack);
    }

    private static String showParams(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            Iterator<String> iterator = params.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                sb.append("\n" + key + ":" + params.get(key));
            }
            return sb.toString();
        }
    }

    public static void request(String url,
                               String tag, final RequestCallBack callBack) {

        OkHttpUtils.postString().mediaType(MediaType.parse("application/json")).tag(tag)
                .url(url)
                .content(JSONObject.toJSONString(SignUtil.doSign(secretKey, new HashMap<>())))
                .build().execute(callBack);
    }

}
