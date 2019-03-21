package com.team.azusa.yiyuan.yiyuan_mainfragment;


import android.content.Intent;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.superluo.textbannerlibrary.TextBannerView;
import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter_new.ProductAdapter;
import com.team.azusa.yiyuan.bean.Advert;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.listener.MyOnClickListener;
import com.team.azusa.yiyuan.model.ProductInfo;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.JumpUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.widget.DividerGridItemDecoration;
import com.team.azusa.yiyuan.widget.FlashView;
import com.team.azusa.yiyuan.widget.RefreshHead;
import com.team.azusa.yiyuan.yiyuan_activity.AllPartakerActivity;
import com.team.azusa.yiyuan.yiyuan_activity.RechargeActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment {


    @BindView(R.id.notice_banner)
    TextBannerView noticeBanner;

    @BindView(R.id.flash_view)
    FlashView flashView;

    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.nav_show)
    ImageButton navShow;
    @BindView(R.id.nav_invite)
    ImageButton navInvite;
    @BindView(R.id.nav_recharge)
    ImageButton navRecharge;
    @BindView(R.id.nav_notice)
    ImageButton navNotice;
    @BindView(R.id.nav_help)
    ImageButton navHelp;
    @BindView(R.id.new_product_more)
    Button newProductMore;
    @BindView(R.id.home_rl_new_product)
    RelativeLayout homeRlNewProduct;
    @BindView(R.id.recycler_new)
    RecyclerView recyclerViewNewProduct;
    @BindView(R.id.home_rl_popularity)
    RelativeLayout homeRlPopularity;
    @BindView(R.id.recycler_hot)
    RecyclerView recyclerViewHotProduct;
    @BindView(R.id.homescrollview)
    NestedScrollView homescrollview;
    private ArrayList<String> advImageUrls = new ArrayList<>(); //广告为图片url集合
    private ArrayList<ProductInfo> hotProducts = new ArrayList<>(); //热门礼品
    private ArrayList<ProductInfo> newProducts = new ArrayList<>(); //热门礼品
    private boolean adv_refresh_ok, notice_refresh_ok = true, new_refresh_ok = true, hot_refresh_ok;


    private int hotPosition = 0;
    private ProductAdapter hotProductAdapter;
    private ProductAdapter newProductAdapter;


    //初始化新品上线
    private void initNewProductRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerViewNewProduct.setLayoutManager(gridLayoutManager);
        recyclerViewNewProduct.addItemDecoration(new DividerGridItemDecoration(getActivity(), R.drawable.rv_divider));
        recyclerViewNewProduct.setHasFixedSize(true);

    }


    //初始化热门礼品
    private void initHotProductRecyclerView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerViewHotProduct.setLayoutManager(gridLayoutManager);
        recyclerViewHotProduct.addItemDecoration(new DividerGridItemDecoration(getActivity(), R.drawable.rv_divider));
        recyclerViewHotProduct.setHasFixedSize(true);
    }

    @Override
    public int layout() {
        return R.layout.main_fgtab01;
    }

    @Override
    public void initView() {
        homescrollview.setNestedScrollingEnabled(false);
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                getHotProduct(hotPosition);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                getAdvertData();
                getNewProduct();
                hotPosition = 0;
                getHotProduct(hotPosition);
            }
        });
        homescrollview.scrollTo(0, 0);
        setAutoRefresh();
        initNewProductRecyclerView();
        initHotProductRecyclerView();
    }

    @Override
    public void initData() {
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            stringList.add("中奖用户" + i);
        }
        noticeBanner.setDatasWithDrawableIcon(stringList,
                getResources().getDrawable(R.drawable.new_notice_icon),16, Gravity.LEFT);
    }

    @Override
    public void initAnimation() {

    }

    public void setListener() {
        //广告位图片点击监听
        flashView.setOnPageClickListener(new MyOnClickListener() {
            @Override
            public void onClick(int position) {
                //crtodo 广告监听
            }
        });
    }

    //获取广告位信息
    private void getAdvertData() {
        adv_refresh_ok = false;
        RequestService.request(Config.AD_LIST_URL,
                TAG,
                new RequestCallBack<ArrayList<Advert>>() {
                    @Override
                    public void onError(String errMsg) {
                        MyToast.showToast(errMsg);
                    }

                    @Override
                    public void onResult(ArrayList<Advert> result) {
                        ArrayList<String> temp = new ArrayList<>();
                        for (int i = 0; i < result.size(); i++) {
                            temp.add(result.get(i).photoPath);
                        }
                        if (!advImageUrls.containsAll(temp)) {
                            advImageUrls = temp;
                            flashView.setImageUris(advImageUrls);
                        }

                    }

                    @Override
                    public void onAfter() {
                        adv_refresh_ok = true;
                        refreshComplete();
                    }
                });
    }

    //设置自动刷新
    private void setAutoRefresh() {
        refreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.autoRefresh();
            }
        }, 100);

    }

    /**
     * 从服务器获取数据
     * <p/>
     * 获得热门礼品
     */
    private void getHotProduct(int position) {
        hot_refresh_ok = false;
        Map<String, String> params = new HashMap<>();
        params.put("position", position + "");
        RequestService.request(Config.PRODUCT_HOT_LIST_URL, params, TAG,
                new RequestCallBack<List<ProductInfo>>() {
                    @Override
                    public void onError(String errMsg) {
                        MyToast.showToast(errMsg);
                    }

                    @Override
                    public void onResult(List<ProductInfo> result) {
                        if (result != null && !result.isEmpty()) {
                            if (position == 0) {
                                hotProducts.clear();
                                refreshLayout.setEnableLoadMore(true);
                            }
                            hotPosition += result.size();
                            hotProducts.addAll(result);
                            if (hotProductAdapter == null) {
                                hotProductAdapter = new ProductAdapter(getActivity()
                                        , hotProducts);
                                recyclerViewHotProduct.setAdapter(hotProductAdapter);
                            } else {
                                hotProductAdapter.notifyDataSetChanged();
                            }
                        } else {
                            refreshLayout.setEnableLoadMore(false);
                        }

                    }

                    @Override
                    public void onAfter() {
                        hot_refresh_ok = true;
                        refreshComplete();
                    }
                });
    }

    /**
     * 从服务器获取数据
     * <p/>
     * 获得新品上线
     */
    private void getNewProduct() {
        new_refresh_ok = false;
        Map<String, String> params = new HashMap<>();
        params.put("position", 0 + "");
        RequestService.request(Config.PRODUCT_NEW_LIST_URL, params, TAG,
                new RequestCallBack<List<ProductInfo>>() {
                    @Override
                    public void onError(String errMsg) {
                        MyToast.showToast(errMsg);
                    }

                    @Override
                    public void onResult(List<ProductInfo> result) {
                        if (result != null && !result.isEmpty()) {
                            newProducts.clear();
                            if (result.size() > 4) {
                                newProducts.addAll(result.subList(0, 4));
                            } else {
                                newProducts.addAll(result);
                            }
                            if (newProductAdapter == null) {
                                newProductAdapter = new ProductAdapter(getActivity(), newProducts);
                                recyclerViewNewProduct.setAdapter(newProductAdapter);
                            } else {
                                newProductAdapter.notifyDataSetChanged();
                            }
                        }
                    }

                    @Override
                    public void onAfter() {
                        new_refresh_ok = true;
                        refreshComplete();
                    }
                });
    }


    private void refreshComplete() {
        if (adv_refresh_ok && notice_refresh_ok && new_refresh_ok && hot_refresh_ok) {
            refreshLayout.finishRefresh();
            refreshLayout.finishLoadMore();
        }
    }


    @OnClick({R.id.home_rl_new_product, R.id.home_rl_popularity, R.id.nav_notice,
            R.id.nav_show, R.id.nav_help, R.id.nav_invite, R.id.nav_recharge})
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.nav_help:
                break;
            case R.id.nav_notice:
                break;
            case R.id.nav_show:
                JumpUtils.jumpShowOrder(getActivity());
                break;
            case R.id.nav_invite:
                Intent intent1 = new Intent(getActivity(), AllPartakerActivity.class);
                intent1.putExtra("what", 1);
                startActivity(intent1);
                break;
            case R.id.nav_recharge:
                Intent intent2 = new Intent(getActivity(), RechargeActivity.class);
                startActivity(intent2);
                break;


        }
    }


    @Override
    public void onStop() {
        noticeBanner.stopViewAnimator();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        noticeBanner.startViewAnimator();
    }
}
