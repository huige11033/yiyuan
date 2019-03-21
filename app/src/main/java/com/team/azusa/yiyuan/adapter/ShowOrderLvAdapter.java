package com.team.azusa.yiyuan.adapter;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.bean.ShowOrder;
import com.team.azusa.yiyuan.bean.ShowOrderCommentDto;
import com.team.azusa.yiyuan.bean.ShowOrderDto;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.listener.MyOnClickListener;
import com.team.azusa.yiyuan.model.ShowOrderBean;
import com.team.azusa.yiyuan.utils.DateUtil;
import com.team.azusa.yiyuan.utils.ImageLoader;
import com.team.azusa.yiyuan.utils.MyToast;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Azusa on 2016/1/15.
 */
public class ShowOrderLvAdapter extends CommonAdapter<ShowOrderBean> {

    public ShowOrderLvAdapter(Context context,ArrayList<ShowOrderBean> datas) {
        super(context,R.layout.show_order_item,datas);
    }

    @Override
    protected void convert(com.zhy.adapter.recyclerview.base.ViewHolder holder, ShowOrderBean showOrder, int position) {
        ImageLoader.getInstance().displayImage(showOrder.userLogoPath, holder.getView(R.id.show_order_touxiang));
        holder.setText(R.id.tv_nickname,showOrder.userNickName);
        holder.setText(R.id.tv_shaidan_time,showOrder.createTime);
        holder.setText(R.id.tv_shaidan_title,showOrder.title);
        holder.setText(R.id.tv_shaidan_title,showOrder.content);
    }
}
