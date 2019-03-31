package com.team.azusa.yiyuan.adapter;

import android.content.Context;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.model.ShowOrderBean;
import com.team.azusa.yiyuan.utils.ImageLoader;
import com.zhy.adapter.recyclerview.CommonAdapter;

import java.util.ArrayList;

/**
 * Created by Azusa on 2016/1/15.
 */
public class ShowOrderLvAdapter extends CommonAdapter<ShowOrderBean> {

    public ShowOrderLvAdapter(Context context,ArrayList<ShowOrderBean> datas) {
        super(context,R.layout.item_show_order,datas);
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
