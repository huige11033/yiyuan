package com.team.azusa.yiyuan.adapter_new;

import android.content.Context;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.listener.AddCarClickListener;
import com.team.azusa.yiyuan.model.ProductInfo;
import com.team.azusa.yiyuan.utils.ImageLoader;
import com.team.azusa.yiyuan.widget.AddCarAnimation;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author : chenru
 * @功能描述:
 * @创建时间: 2019/3/19
 */
public class ProductAdapter extends CommonAdapter<ProductInfo> {


    private AddCarClickListener mAddCarClickListener;

    public ProductAdapter(Context context, List<ProductInfo> datas) {
        super(context, R.layout.product_recyclerview_item, datas);
    }

    @Override
    protected void convert(ViewHolder holder, ProductInfo info, int position) {
        ImageLoader.getInstance().displayImage(info.photoPath,holder.getView(R.id.product_img));
        holder.setText(R.id.product_name,info.title);
//        holder.setText(R.id.total_score,info.remark);
    }

    public void SetOnAddCarClickListener(AddCarClickListener ClickListener) {
        this.mAddCarClickListener = ClickListener;
    }



}
