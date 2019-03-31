package com.team.azusa.yiyuan.adapter_new;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.model.YgShareEntity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * 中奖记录。
 */
public class ShaidanAdapter extends CommonAdapter<YgShareEntity> {

    Context context;

    private View.OnClickListener onClickListener;

    public ShaidanAdapter(Context context, List<YgShareEntity> datas) {
        super(context, R.layout.item_shuaidan, datas);
        this.context = context;
    }

    @Override
    protected void convert(ViewHolder holder, YgShareEntity info, int position) {

        holder.setText(R.id.time, info.getCreateTime());
//        holder.setText(R.id.status, info. ? "审核失败" : "审核通过");
        holder.setText(R.id.nickname, info.getUserNickName());
        holder.setText(R.id.product, info.getTitle());
        holder.setText(R.id.message, info.getContent());

        RequestOptions options = new RequestOptions()
                .placeholder(R.drawable.default_head_)
                .error(R.drawable.default_head_)
                .fallback(R.drawable.default_head_)
                .transform(new RoundedCorners(10));
        ImageView image = holder.getView(R.id.image);
        ImageView shareImg = holder.getView(R.id.shareImg);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
        shareImg.setScaleType(ImageView.ScaleType.FIT_XY);
        Glide.with(context).load(info.getUserLogoPath()).apply(options).into(image);
        String photoList = info.getPhotos();
        if (photoList != null) {
            String[] arr = photoList.split(",");
            if (arr != null && arr.length > 0)
                Glide.with(context).load(arr[0]).apply(options).into(shareImg);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
