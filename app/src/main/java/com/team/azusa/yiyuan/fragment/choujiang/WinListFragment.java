package com.team.azusa.yiyuan.fragment.choujiang;

import android.util.Log;

import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter_new.ZhongjiangAdapter;
import com.team.azusa.yiyuan.app.UserManager;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.model.UserYgEntity;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.widget.MyDialog;
import com.team.azusa.yiyuan.yiyuan_activity.MyBuyRecordActivity;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.DrawableRes;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * 中奖记录列表。
 */
public class WinListFragment extends BaseFragment {
    ZhongjiangAdapter adapter;

    private ArrayList<UserYgEntity> datas;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

//    @BindView(R.id.refresh_layout)
//    SmartRefreshLayout refreshLayout;

    private MyDialog myDialog;

    @Override
    public int layout() {
        return R.layout.layout_listview;
    }

    @Override
    public void initView() {
        myDialog = new MyDialog();
        initRecyclerView();
    }

    @Override
    public void initData() {
        datas = new ArrayList<>();
        adapter = new ZhongjiangAdapter(activity, datas);
        recyclerView.setAdapter(adapter);
//        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
//            @Override
//            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
//                getData(datas.size());
//            }
//
//            @Override
//            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
//                getData(0);
//                refreshLayout.setEnableLoadMore(true);
//            }
//        });
        getData(0);
    }

    @Override
    public void initAnimation() {

    }

    @Override
    public void setListener() {

    }

    //初始化新品上线
    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(getRecyclerViewDivider(R.drawable.rv_divider_line));
        recyclerView.setHasFixedSize(true);
    }

    /**
     * 获取分割线
     *
     * @param drawableId 分割线id
     * @return
     */
    public RecyclerView.ItemDecoration getRecyclerViewDivider(@DrawableRes int drawableId) {
        DividerItemDecoration itemDecoration = new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(drawableId));
        return itemDecoration;
    }

    public void getData(int position) {
        Map<String, String> param = new HashMap<>();
        param.put("userId", UserManager.getInstance().getUser().id + "");
        param.put("position", position + "");
        myDialog.showLodingDialog(activity);
        RequestService.request(Config.WIN_LIST_URL, param, WinListFragment.class.getName(),
                new RequestCallBack<List<UserYgEntity>>() {
                    @Override
                    public void onError(String errMsg) {
                        myDialog.dismissDialog();
                        MyToast.showToast(errMsg);
                    }

                    @Override
                    public void onResult(List<UserYgEntity> result) {
                        Log.d(MyBuyRecordActivity.class.getSimpleName(), result + "");
                        if (result.size() > 0) {
                            if (position == 0) {
                                datas.clear();
                            }
                            datas.addAll(result);
                            adapter.notifyDataSetChanged();
                        } /*else {
                            refreshLayout.setEnableLoadMore(false);
                        }*/
                        myDialog.dismissDialog();
                    }

                    @Override
                    public void onAfter() {
//                        refreshLayout.finishLoadMore();
//                        refreshLayout.finishRefresh();
                        myDialog.dismissDialog();
                    }
                });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        OkHttpUtils.getInstance().cancelTag(WinListFragment.class.getName());
    }
}
