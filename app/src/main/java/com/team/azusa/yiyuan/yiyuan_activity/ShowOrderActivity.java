package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.ShowOrderLvAdapter;
import com.team.azusa.yiyuan.bean.ShowOrderDto;
import com.team.azusa.yiyuan.callback.ShowOrderCallback;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.listener.MyOnClickListener;
import com.team.azusa.yiyuan.listener.OnLoadListener;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.JsonUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.widget.PulluptoRefreshListview;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class ShowOrderActivity extends BaseActivity {

    @BindView(R.id.listview_shaidan)
    PulluptoRefreshListview listviewShaidan;
    private ShowOrderLvAdapter adapter;
    private String productId = "";//晒单ID
    private ArrayList<ShowOrderDto> datas = new ArrayList<>();//得到的晒单数据
    private int what; //区分是要显示哪个页面
    private String url;
    private boolean cancelrequest = false;

    @Override
    public int layout() {
        return R.layout.activity_show_order;
    }

    public void initView() {
        adapter = new ShowOrderLvAdapter(ConstanceUtils.CONTEXT, datas, R.layout.show_order_item);
        listviewShaidan.setFooterDividersEnabled(false);
        listviewShaidan.setAdapter(adapter);
        listviewShaidan.setOnLoadListener(new OnLoadListener() {
            @Override
            public void onLoad() {
                getData(datas.size());
            }
        });
    }

    public void setListener() {
        listviewShaidan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                turntoDetailPage(position);
            }
        });

        adapter.setOnClickListener(new MyOnClickListener() {
            @Override
            public void onClick(int position) {
                turntoDetailPage(position);
            }
        });
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
        Intent intent = getIntent();
        what = intent.getIntExtra("what", -1);
        if (what == -1) {
            productId = intent.getStringExtra("productId");
            url = "/yiyuan/b_getShaiDan";
            getData(0);
        } else {
            url = "/yiyuan/b_getAllShowOrders";
            getData(0);
        }

    }

    private void getData(int firstResult) {
        OkHttpUtils.get().url(Config.IP + url)
                .addParams("productId", productId)
                .addParams("firstResult", firstResult + "")
                .tag("ShowOrderActivity")
                .build().execute(new ShowOrderCallback() {
            @Override
            public void onError(Request request, Exception e) {
                if (cancelrequest) {
                    return;
                }
                MyToast.showToast("网络连接出错");
            }

            @Override
            public void onResponse(ArrayList<ShowOrderDto> response) {
                if (response == null || response.isEmpty()) {
                    listviewShaidan.setLoadComplete(true);
                    return;
                }
                listviewShaidan.setLoading(false);
                datas.addAll(response);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @OnClick(R.id.show_order_go_back)
    public void onClick() {
        this.finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelrequest = true;
        OkHttpUtils.getInstance().cancelTag("ShowOrderActivity");
    }
}
