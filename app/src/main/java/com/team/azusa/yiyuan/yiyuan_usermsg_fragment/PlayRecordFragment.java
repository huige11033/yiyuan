package com.team.azusa.yiyuan.yiyuan_usermsg_fragment;

import android.graphics.Color;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.squareup.okhttp.Request;
import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.MyPlayRecordRviewAdapter;
import com.team.azusa.yiyuan.bean.BuyRecordInfo;
import com.team.azusa.yiyuan.callback.BuyRecordProductCallback;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.listener.RecyclerViewItemClickLitener;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by Azusa on 2016/1/17.
 */
public class PlayRecordFragment extends BaseFragment {
    @BindView(R.id.usermsg_fg1_rv)
    XRecyclerView recyclerview;
    private MyPlayRecordRviewAdapter adapter;
    private ArrayList<BuyRecordInfo> datas;
    private View footer;
    //上拉加载更多的footer里面的pb，tv；
    private ProgressBar loadmore_pb;
    private Animation animation; //pb的旋转动画
    private boolean initViewed = false; //是否初始化过页面
    private String user_id; //用户ID
    private boolean cancelrequest = false; //是否取消网络请求

    @Override
    public int layout() {
        return R.layout.usermsg_fgtab1;
    }

    public void initView() {
        initFooter();
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(ConstanceUtils.CONTEXT);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(mLayoutManager);
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recyclerview.setHasFixedSize(true);
        //设置分割线
        recyclerview.addItemDecoration(new HorizontalDividerItemDecoration
                .Builder(ConstanceUtils.CONTEXT).color(Color.parseColor("#eeeeee")).build());

        adapter = new MyPlayRecordRviewAdapter(datas, ConstanceUtils.CONTEXT);
        recyclerview.setAdapter(adapter);
        adapter.setOnItemClickLitener(new RecyclerViewItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                MyToast.showToast( "" + position);
            }
        });
        recyclerview.setPullRefreshEnabled(false);
        recyclerview.addFootView(footer);
        recyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
            }

            @Override
            public void onLoadMore() {
                getData(datas.size());
                loadmore_pb.startAnimation(animation);
            }
        });
    }

    public void initFooter() {
        footer = View.inflate(ConstanceUtils.CONTEXT, R.layout.listview_footer, null);
        loadmore_pb = (ProgressBar) footer.findViewById(R.id.pull_to_refresh_load_progress);
    }

    public void initData() {
        user_id = getArguments().getString("user_id");
        datas = new ArrayList<>();
    }

    /**
     * 从服务器获取数据
     *
     * @param firstResult 要加载的第一条数据的position
     */
    public void getData(final int firstResult) {
        OkHttpUtils.get().url(Config.IP + "/yiyuan/user_getUserRecord")
                .addParams("userId", user_id).addParams("firstResult", firstResult + "")
                .tag("PlayRecordFragment")
                .build().execute(new BuyRecordProductCallback() {
            @Override
            public void onError(Request request, Exception e) {
                if (cancelrequest) {
                    return;
                }
                MyToast.showToast( "网络连接出错");
                recyclerview.loadMoreComplete();
            }

            @Override
            public void onResponse(ArrayList<BuyRecordInfo> response) {
                datas.addAll(response);
                loadmore_pb.clearAnimation();
                recyclerview.loadMoreComplete();
            }
        });
    }

    public void initAnimation() {
        animation = AnimationUtils.loadAnimation(ConstanceUtils.CONTEXT, R.anim.myrotate);
        LinearInterpolator lin = new LinearInterpolator();
        animation.setInterpolator(lin); //设置插值器，匀速加载动画
        loadmore_pb.startAnimation(animation);
    }

    @Override
    public void setListener() {

    }

    @Override
    public void onDestroyView() {
        cancelrequest = true;
        OkHttpUtils.getInstance().cancelTag("PlayRecordFragment");
        super.onDestroyView();
    }
}