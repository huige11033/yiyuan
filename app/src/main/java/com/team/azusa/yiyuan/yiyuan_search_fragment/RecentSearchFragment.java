package com.team.azusa.yiyuan.yiyuan_search_fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.team.azusa.yiyuan.BaseFragment;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.RecentSearchLvAdapter;
import com.team.azusa.yiyuan.database.SharedPreferenceData;
import com.team.azusa.yiyuan.event.SearchTextEven;
import com.team.azusa.yiyuan.utils.UserUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;


public class RecentSearchFragment extends BaseFragment {

    @BindView(R.id.btn_clearrecord)
    Button btnClearrecord;
    @BindView(R.id.recent_lv)
    ListView mlistView;
    private ArrayList<String> datas;
    private String user_id;
    private RecentSearchLvAdapter adapter;

    public void setListener() {
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EventBus.getDefault().post(new SearchTextEven(datas.get(position)));
            }
        });
    }

    @Override
    public int layout() {
        return R.layout.search_fg1_recent;
    }

    @Override
    public void initView() {

    }

    public void initData() {
        if (UserUtils.userisLogin) {
            user_id = UserUtils.user.getId();
        } else {
            user_id = "未登录";
        }
        datas = SharedPreferenceData.getInstance().getSearchList(getContext(), user_id);
        adapter = new RecentSearchLvAdapter(getContext(), datas);
        mlistView.setAdapter(adapter);
    }

    @Override
    public void initAnimation() {

    }

    @OnClick(R.id.btn_clearrecord)
    public void onClick() {
        SharedPreferenceData.getInstance().clearSearchtext(getContext(), user_id);
        datas.clear();
        adapter.notifyDataSetChanged();
    }
}
