package com.team.azusa.yiyuan.yiyuan_activity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.ImageView;

import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.PhotoDetailRvAdapter;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.StringUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class PhotoTextActivity extends BaseActivity {

    @BindView(R.id.tw_go_back)
    ImageView twGoBack;
    @BindView(R.id.rv_photodetail)
    RecyclerView recyclerView;

    private ArrayList<String> imgdatas; //图片URL集合

    public void initData() {
        imgdatas = StringUtil.getList(getIntent().getStringExtra("imgs"));
    }

    @Override
    public void setListener() {

    }

    @Override
    public int layout() {
        return R.layout.activity_photo_text;
    }

    public void initView() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(ConstanceUtils.CONTEXT);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(new PhotoDetailRvAdapter(imgdatas));

    }

    @OnClick(R.id.tw_go_back)
    public void onClick() {
        this.finish();
    }
}
