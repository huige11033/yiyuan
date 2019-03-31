package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Context;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.callback.RequestCallBack;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.model.ArticleCateEntity;
import com.team.azusa.yiyuan.network.RequestService;
import com.team.azusa.yiyuan.utils.MyToast;
import com.team.azusa.yiyuan.widget.DividerGridItemDecoration;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author : chenru
 * @功能描述:
 * @创建时间: 2019/3/31
 */
public class HelpCenterActivity extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.refresh_layout)
    SmartRefreshLayout refreshLayout;

    ArticleCategoryAdapter mAdapter;

    private List<ArticleCateEntity> mDatas = new ArrayList<>();

    @Override
    public int layout() {
        return R.layout.help_article_category_layout;
    }

    @Override
    public void initView() {
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                requestArticleCateGory();
            }
        });
        refreshLayout.setEnableLoadMore(false);
        initRecyclerView();
    }

    private void initRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerGridItemDecoration(this, R.drawable.rv_divider));
        recyclerView.setHasFixedSize(true);
    }

    @Override
    public void initData() {
        refreshLayout.autoRefresh();
    }

    @Override
    public void setListener() {

    }


    private void requestArticleCateGory() {
        RequestService.request(Config.HELP_ARTICLE_CATEGORY_LIST_URL, TAG, new RequestCallBack<List<ArticleCateEntity>>() {

            @Override
            public void onError(String errMsg) {
                MyToast.showToast(errMsg);
            }

            @Override
            public void onResult(List<ArticleCateEntity> result) {
                if (!result.isEmpty()) {
                    mDatas.clear();
                    mDatas.addAll(result);
                    if (mAdapter == null) {
                        mAdapter = new ArticleCategoryAdapter(mContext, mDatas);
                    } else {
                        mAdapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    private class ArticleCategoryAdapter extends CommonAdapter<ArticleCateEntity> {

        public ArticleCategoryAdapter(Context context, List<ArticleCateEntity> datas) {
            super(context, R.layout.help_article_category_item, datas);
        }

        @Override
        protected void convert(ViewHolder holder, ArticleCateEntity articleCateEntity, int position) {
            holder.setText(R.id.category_name, articleCateEntity.name);
            holder.setText(R.id.category_remark, articleCateEntity.remark);
        }
    }
}
