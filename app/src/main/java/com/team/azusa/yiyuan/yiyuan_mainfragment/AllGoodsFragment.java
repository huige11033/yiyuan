package com.team.azusa.yiyuan.yiyuan_mainfragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.AllgoodsLvAdapter;
import com.team.azusa.yiyuan.adapter_new.ProductAdapter;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.listener.AddCarClickListener;
import com.team.azusa.yiyuan.model.CategoryInfo;
import com.team.azusa.yiyuan.model.ProductInfo;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.widget.AddCarAnimation;
import com.team.azusa.yiyuan.widget.DividerGridItemDecoration;
import com.team.azusa.yiyuan.widget.MyDialog;
import com.team.azusa.yiyuan.widget.MyPopupWindow;
import com.team.azusa.yiyuan.widget.TopbarAnimation;
import com.team.azusa.yiyuan.yiyuan_activity.MainActivity;
import com.team.azusa.yiyuan.yiyuan_activity.SearchActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Azusa on 2016/1/10.
 */
public class AllGoodsFragment extends BaseFragment {

    @BindView(R.id.search_orange)
    ImageView searchOrange;
    @BindView(R.id.fg2_topbar_typerl)
    RelativeLayout TopbarTyperl;
    @BindView(R.id.fg2_topbar_publicrl)
    RelativeLayout TopbarPublicrl;
    @BindView(R.id.fg2_topll)
    LinearLayout Topll;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.sort_arrow)
    View sortArrow1;
    @BindView(R.id.sort_arrow2)
    View sortArrow2;
    @BindView(R.id.sort_tv1)
    TextView sortTv1;
    @BindView(R.id.sort_tv2)
    TextView sortTv2;

    private ArrayList<ProductInfo> datas;
    private ProductAdapter adapter;
    private int mTopbarHeight; //顶部toolbar高度
    private int mpwindow_TopbarHeight;
    private TopbarAnimation topbarAnimation;
    private MyDialog myDialog;
    private AlertDialog loding_dialog;
    private int orderBy; //排序
    private int category; //分类
    private int[] car_location; //购物车的位置
    private MainActivity activity;
    private MyPopupWindow pwin1 = new MyPopupWindow();
    private MyPopupWindow pwin2 = new MyPopupWindow();
    private List<CategoryInfo> mCategories;
    private View pwindow1;
    private View pwindow2;
    private int startPosition = 0;

    //当前页面可见时再加载页面数据
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if (isVisibleToUser) {
            if (!isInited) {
                myDialog = new MyDialog();
                loding_dialog = myDialog.showLodingDialog(getActivity());
                loding_dialog.setOnKeyListener(backlistener);
                car_location = activity.getCar_location();
                isInited = true;
                requestCategory();
            } else {
                if(!isLoaded){
                    loding_dialog.show();
                    myDialog.initAnimation();
                    requestCategory();
                }

            }
        }
        super.setUserVisibleHint(isVisibleToUser);
    }

    public void initView() {
        activity = (MainActivity) getActivity();
        initRecyclerView();
    }

    @Override
    public int layout() {
        return R.layout.main_fgtab02;
    }

    public void initData() {
        mTopbarHeight = getResources().getDimensionPixelSize(R.dimen.mTopbar_height);
        mpwindow_TopbarHeight = getResources().getDimensionPixelSize(R.dimen.mpwindow_Topbar_height);
        datas = new ArrayList<>();
        adapter = new ProductAdapter(getActivity(), datas);
        recyclerView.setAdapter(adapter);
        adapter.SetOnAddCarClickListener(new AddCarClickListener() {
            @Override
            public void onAddCarClick(int position, Bitmap drawable, int[] start_location) {
                new AddCarAnimation(getActivity()).doAnim(drawable, start_location, car_location);
            }
        });
        refreshLayout.setOnRefreshLoadMoreListener(new OnRefreshLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                requestProduct(datas.size(),orderBy,category);
            }

            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                requestProduct(0,orderBy,category);
                refreshLayout.setEnableLoadMore(true);
            }
        });
    }

    //初始化新品上线
    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(getActivity(), R.drawable.rv_divider));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void initAnimation() {
        topbarAnimation = new TopbarAnimation();
        topbarAnimation.build(mTopbarHeight, Topll);
        if (!topbarAnimation.getisShow()) {
            topbarAnimation.showTopbar();
        }
    }

    @Override
    public void setListener() {

    }


    @OnClick({R.id.search_orange, R.id.fg2_topbar_typerl, R.id.fg2_topbar_publicrl})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.search_orange:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.fg2_topbar_typerl:
                showPopupWindow(1);
                break;
            case R.id.fg2_topbar_publicrl:
                showPopupWindow(2);
                break;
        }
    }

    private void showPopupWindow(int what) {

        switch (what) {
            case 1:
                pwin1.showLocation(TopbarTyperl, sortArrow1);
                break;
            case 2:
                pwin2.showLocation(TopbarPublicrl, sortArrow2);
                break;
        }
    }

    private DialogInterface.OnKeyListener backlistener = new DialogInterface.OnKeyListener() {
        @Override
        public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_BACK) {  //表示按返回键 时的操作
                loding_dialog.dismiss();
                return false;    //已处理
            }
            return false;
        }
    };


    private void requestCategory() {
        RequestService.request(Config.PRODUCT_CATEGORY_LIST_URL, TAG, new RequestCallBack<List<CategoryInfo>>() {
            @Override
            public void onError(String errMsg) {
                MyToast.showToast(errMsg);
            }

            @Override
            public void onResult(List<CategoryInfo> result) {
                if (result != null && result.size() > 0) {
                    mCategories = result;
                    orderBy = 1;
                    category = result.get(0).id;
                    buildPopupWindow();
                    requestProduct(0,orderBy,category);
                    isLoaded = true;
                }
            }

            @Override
            public void onAfter() {
                loding_dialog.dismiss();
            }
        });
    }

    private void requestProduct(int position, int orderType, int categoryId) {
        Map<String, String> params = new HashMap<>();
        params.put("position", position + "");
        params.put("orderType", orderType + "");
        params.put("cateId", categoryId + "");
        RequestService.request(Config.PRODUCT_ALL_LIST_URL,params,TAG,new RequestCallBack<List<ProductInfo>>(){

            @Override
            public void onError(String errMsg) {
                MyToast.showToast(errMsg);
            }

            @Override
            public void onResult(List<ProductInfo> result) {
                if(result.size()>0){
                    if(position == 0){
                        datas.clear();
                    }
                    datas.addAll(result);
                    startPosition = datas.size();
                    adapter.notifyDataSetChanged();
                }else{
                    refreshLayout.setEnableLoadMore(false);
                }
            }

            @Override
            public void onAfter() {
                refreshLayout.finishLoadMore();
                refreshLayout.finishRefresh();
            }
        });
    }

    private void buildPopupWindow() {
        pwindow1 = View.inflate(getActivity(), R.layout.popupwindow_alltype, null);
        pwindow2 = View.inflate(getActivity(), R.layout.popupwindow_alltype, null);
        List<String> strings = Arrays.asList(getResources().getStringArray(R.array.order_type));
        pwin1.build(ConstanceUtils.CONTEXT, pwindow1,
                view, mpwindow_TopbarHeight, sortTv1).setData(parseCategory(mCategories));
        pwin2.build(ConstanceUtils.CONTEXT, pwindow2,
                view, mpwindow_TopbarHeight, sortTv2).setData(strings);
        pwin1.setOnItemClick(new MyPopupWindow.OnPopupItemClickListener() {
            @Override
            public void onItemClick(int position) {
                category = mCategories.get(position).id;
                requestProduct(0,orderBy,category);
            }
        });
        pwin2.setOnItemClick(new MyPopupWindow.OnPopupItemClickListener() {
            @Override
            public void onItemClick(int position) {
                orderBy = position + 1;
                requestProduct(0,orderBy,category);
            }
        });
    }

    private List<String> parseCategory(List<CategoryInfo> mCategorys) {
        List<String> categories = new ArrayList<>();
        for (CategoryInfo mCategory : mCategorys) {
            if (!TextUtils.isEmpty(mCategory.displayName)) {
                categories.add(mCategory.displayName);
            } else {
                categories.add(mCategory.name);
            }
        }
        return categories;
    }
}
