package com.team.azusa.yiyuan.callback;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.team.azusa.yiyuan.bean.ResultBean;
import com.team.azusa.yiyuan.bean.User;
import com.team.azusa.yiyuan.config.ParameterizedTypeImpl;
import com.team.azusa.yiyuan.utils.Base64Utils;
import com.zhy.http.okhttp.callback.Callback;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author : chenru
 * @功能描述:
 * @创建时间: 2019/3/7
 */
public abstract class RequestCallBack<T> extends Callback<ResultBean<T>> {
    private String RESULT_OK = "000000";


    @Override
    public ResultBean<T> parseNetworkResponse(Response response) throws IOException {
        if (response.isSuccessful()) {
            String result = new String(Base64Utils.decode(response.body().string()));
            Log.d("RequestCallBack--->", result);
            Type type = getClass().getGenericSuperclass();
            if(type instanceof ParameterizedType) {
                Type[] types = ((ParameterizedType) type).getActualTypeArguments();
                Type ty = new ParameterizedTypeImpl(ResultBean.class, new Type[]{types[0]});
                ResultBean<T> resultBean = new Gson().fromJson(result, ty);
                if (resultBean != null) {
                    return resultBean;
                }
            }
        }
        return null;
    }

    @Override
    public void onResponse(ResultBean<T> resultBean) {
        if(resultBean == null){
            onError("数据解析错误");
            return;
        }
        if (TextUtils.equals(resultBean.code, RESULT_OK)) {
            onResult(resultBean.data);
        } else {
            onError(resultBean.msg);
        }
    }

    @Override
    public void onError(Request request, Exception e) {
        onError(e.getMessage());
    }

    public abstract void onError(String errMsg);

    public abstract void onResult(T result);
}
