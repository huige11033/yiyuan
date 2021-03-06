package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;

import com.google.gson.JsonArray;
import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.MyBuyRecordLvAdapter;
import com.team.azusa.yiyuan.app.UserManager;
import com.team.azusa.yiyuan.bean.BuyRecordInfo;
import com.team.azusa.yiyuan.callback.BuyRecordProductCallback;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.listener.OnLoadListener;
import com.team.azusa.yiyuan.model.UserYgEntity;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.JsonUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.widget.MyDialog;
import com.team.azusa.yiyuan.widget.PulluptoRefreshListview;
import com.team.azusa.yiyuan.widget.RefreshHead;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;

public class MyBuyRecordActivity extends BaseActivity {


    @BindView(R.id.mybuyrecordlv)
    PulluptoRefreshListview mybuyrecordlv;
    @BindView(R.id.buyrecordptrpulltorefresh)
    PtrFrameLayout buyrecordptrpulltorefresh;
    private MyBuyRecordLvAdapter adapter;
    private ArrayList<UserYgEntity> datas;
    private RefreshHead refreshHead;
    private boolean cancelrequest = false; //是否取消网络请求
    private MyDialog myDialog;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (1 == msg.what) {
                Intent intent = new Intent(MyBuyRecordActivity.this, YunRecordDetailActivity.class);
                intent.putExtra("product_data", (Serializable) msg.obj);
                startActivityForResult(intent, 1);
                myDialog.dismissDialog();
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            finish();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void setListener() {
        mybuyrecordlv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                if (position == datas.size()) {
                    return;
                }
                myDialog = new MyDialog();
                myDialog.showLodingDialog(MyBuyRecordActivity.this);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
//                        String data = JsonUtils.getJsonStringformat(datas.get(position));
                        Message message = Message.obtain();
                        message.what = 1;
                        message.obj = datas.get(position);
                        handler.sendMessageDelayed(message, 500);
                    }
                }).start();
            }
        });
    }

    public void initData() {
        datas = new ArrayList<>();
        adapter = new MyBuyRecordLvAdapter(datas, MyBuyRecordActivity.this);
        mybuyrecordlv.setAdapter(adapter);
    }


    /**
     * 从服务器获取数据
     *
     * @param firstResult 要加载的第一条数据的position
     */
    private void getData(final int firstResult, final int what) {
        Map<String,String> param = new HashMap<>();
        param.put("userId", UserManager.getInstance().getUser().id+"");
        param.put("position", firstResult + "");
        RequestService.request(Config.CHOUJIANG_JILU_URL, param, "MyBuyRecordActivity",
                new RequestCallBack<List<UserYgEntity>>() {
                    @Override
                    public void onError(String errMsg) {
                        if (cancelrequest) {
                            return;
                        }
                        MyToast.showToast("网络连接出错");
                        mybuyrecordlv.setLoadComplete(true);
                    }

                    @Override
                    public void onResult(List<UserYgEntity> result) {
                        Log.d(MyBuyRecordActivity.class.getSimpleName(), result + "");
                        if (null == result) {
                            mybuyrecordlv.setLoadComplete(true);
                            buyrecordptrpulltorefresh.refreshComplete();
                            return;
                        } else if (1 == what) {
                            datas.clear();
                        }
                        if (1 == what) {
                            if (cancelrequest) {
                                return;
                            }
                            buyrecordptrpulltorefresh.refreshComplete();
                        }
                        mybuyrecordlv.setLoading(false);
                        datas.addAll(result);
                        adapter.notifyDataSetChanged();
                    }
                });
    }

    @Override
    public int layout() {
        return R.layout.activity_my_buy_record;
    }

    public void initView() {
        refreshHead = new RefreshHead(MyBuyRecordActivity.this, "buyRecordPage");
        buyrecordptrpulltorefresh.setHeaderView(refreshHead);
        buyrecordptrpulltorefresh.addPtrUIHandler(refreshHead); //添加下拉刷新头部UI变化接口

        buyrecordptrpulltorefresh.setPtrHandler(new PtrDefaultHandler() {
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                if (mybuyrecordlv.isLoadmoreComplete()) {
                    mybuyrecordlv.setLoadComplete(false);
                }
                getData(0, 1);
            }

            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return mybuyrecordlv.getChildAt(0).getTop() == 0;
            }
        });

        mybuyrecordlv.setOnLoadListener(new OnLoadListener() {
            @Override
            public void onLoad() {
                getData(datas.size(), 2);
            }
        });
        buyrecordptrpulltorefresh.postDelayed(new Runnable() {
            @Override
            public void run() {
                buyrecordptrpulltorefresh.autoRefresh();
            }
        }, 100);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelrequest = true;
        OkHttpUtils.getInstance().cancelTag("MyBuyRecordActivity");
    }

    @OnClick(R.id.return_myrecord)
    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.return_myrecord:
                finish();
                break;
        }
    }
}