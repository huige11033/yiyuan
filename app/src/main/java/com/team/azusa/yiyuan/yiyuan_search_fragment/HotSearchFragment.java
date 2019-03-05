package com.team.azusa.yiyuan.yiyuan_search_fragment;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.HotSearchRviewAdapter;
import com.team.azusa.yiyuan.event.SearchTextEven;
import com.team.azusa.yiyuan.listener.RecyclerViewItemClickLitener;

import java.util.ArrayList;

import butterknife.BindView;
import de.greenrobot.event.EventBus;


public class HotSearchFragment extends BaseFragment {

    @BindView(R.id.hot_search_rv)
    RecyclerView hotSearchRv;
    private ArrayList<String> datas;
    HotSearchRviewAdapter adapter;

    @Override
    public int layout() {
        return R.layout.search_fg1_hot;
    }

    public void initView() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        hotSearchRv.setLayoutManager(gridLayoutManager);
        hotSearchRv.setHasFixedSize(true);
        datas = new ArrayList<String>();
        datas.add("iPhon6s");
        datas.add("小米5");
        datas.add("魅族");
        datas.add("平板电脑");
        datas.add("单反相机");
        datas.add("汽车");
        adapter = new HotSearchRviewAdapter(datas);
        hotSearchRv.setAdapter(adapter);
        adapter.setOnItemClickLitener(new RecyclerViewItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                EventBus.getDefault().post(new SearchTextEven(datas.get(position)));
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAnimation() {

    }

    @Override
    public void setListener() {

    }
}
