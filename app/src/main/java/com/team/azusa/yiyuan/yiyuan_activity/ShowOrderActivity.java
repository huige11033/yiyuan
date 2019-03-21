package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.ShowOrderLvAdapter;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.model.ShowOrderBean;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.JsonUtils;
import com.team.azusa.yiyuan.utils.MyToast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class ShowOrderActivity extends BaseActivity {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ShowOrderLvAdapter adapter;
    private ArrayList<ShowOrderBean> datas = new ArrayList<>();//得到的晒单数据
    private int position = 0;

    @Override
    public int layout() {
        return R.layout.activity_show_order;
    }

    public void initView() {

        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                position = 0;
                getData(position);
            }

            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                getData(position);
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        adapter = new ShowOrderLvAdapter(ConstanceUtils.CONTEXT, datas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    public void setListener() {

    }

    //跳转至订单详情页面
    private void turntoDetailPage(int position) {
        if (position == datas.size()) {
            return;
        }
        Intent intent = new Intent(ShowOrderActivity.this, ShareOrderDetailActivity.class);
        intent.putExtra("showOrderDto", JsonUtils.getJsonStringformat(datas.get(position)));
        startActivity(intent);
    }

    public void initData() {
        getData(position);
    }

    private void getData(int firstResult) {

        Map<String, String> params = new HashMap<>();
        params.put("position", firstResult + "");
        RequestService.request(Config.SHARE_LIST_URL, params, TAG, new RequestCallBack<List<ShowOrderBean>>() {
            @Override
            public void onError(String errMsg) {
                MyToast.showToast(errMsg);
            }

            @Override
            public void onResult(List<ShowOrderBean> result) {
                if (result.isEmpty()) {
                    refreshLayout.finishLoadMoreWithNoMoreData();
                    refreshLayout.setEnableLoadMore(false);
                    return;
                }
                if(position == 0){
                    datas.clear();
                }
                refreshLayout.setEnableLoadMore(true);
                datas.addAll(result);
                position = datas.size();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onAfter() {
                refreshLayout.finishRefresh();
                refreshLayout.finishLoadMore();
            }
        });
    }

    @OnClick(R.id.show_order_go_back)
    public void onClick() {
        this.finish();
    }

}
