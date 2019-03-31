package com.team.azusa.yiyuan.adapter_new;

import android.content.Context;
import android.view.View;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.model.UserYgEntity;
import com.team.azusa.yiyuan.utils.ImageLoader;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * 中奖记录。
 */
public class ZhongjiangAdapter extends CommonAdapter<UserYgEntity> {


    private View.OnClickListener onClickListener;

    public ZhongjiangAdapter(Context context, List<UserYgEntity> datas) {
        super(context, R.layout.item_choujiang_result, datas);
    }

    @Override
    protected void convert(ViewHolder holder, UserYgEntity info, int position) {
        ImageLoader.getInstance().displayImage(info.getBuyUserLogoPath(), holder.getView(R.id.image));
        holder.setText(R.id.time, info.getCreateTime());
        holder.setText(R.id.score, info.getSinglePrice()+"");
        holder.setText(R.id.mobile, info.getYgProduct().getWinUserNickName());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
