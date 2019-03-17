package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.team.azusa.yiyuan.BaseActivity;
import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.database.SharedPreferenceData;
import com.team.azusa.yiyuan.event.SearchTextEven;
import com.team.azusa.yiyuan.utils.ConstanceUtils;
import com.team.azusa.yiyuan.utils.StringUtil;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.widget.ClearEditText;
import com.team.azusa.yiyuan.yiyuan_search_fragment.SearchRemindFragment;
import com.team.azusa.yiyuan.yiyuan_search_fragment.SearchResoultFragment;

import butterknife.BindView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class SearchActivity extends BaseActivity {

    @BindView(R.id.return_btn)
    ImageView btn_return;
    @BindView(R.id.btn_search)
    Button btn_search;
    @BindView(R.id.search_edt)
    ClearEditText edt_search;
    @BindView(R.id.Search_fg)
    FrameLayout SearchFg;
    private String user_id;

    //主页限购、手机、黄金等按钮点击搜索,或者点击搜索按钮进入该页面
    private void jdugeWhereClickSearch() {
        Intent intent = getIntent();
        if (intent.getIntExtra("what", -1) == ConstanceUtils.MESSAGE_OK) {
            search(intent.getStringExtra("search_key"));
        }else {
            Fragment fg1 = new SearchRemindFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.Search_fg, fg1).commit();
        }
    }

    @Override
    public int layout() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        EventBus.getDefault().register(this);
    }

    public void initData() {
        if (UserUtils.userisLogin) {
            user_id = UserUtils.user.getId();
        } else {
            user_id = "未登录";
        }
    }

    @Override
    public void setListener() {
        jdugeWhereClickSearch();
    }

    //eventbus接收点击最近搜索和热门搜索发来的消息
    public void onEventMainThread(SearchTextEven event) {
        edt_search.setText(event.getSearch_key());
        search(event.getSearch_key());
    }

    @OnClick({R.id.return_btn, R.id.btn_search})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_btn:
                finish();
                break;
            case R.id.btn_search:
                String string = edt_search.getText().toString();
                if (StringUtil.isEmpty(string)) {
                    string = "iphon";
                }
                search(string);
                break;
        }
    }

    private void search(String searchkey) {
        SharedPreferenceData.getInstance().saveSearchtext(SearchActivity.this, searchkey, user_id);
        Bundle bundle = new Bundle();
        bundle.putString("search_key", searchkey);
        Fragment fg2 = new SearchResoultFragment();
        fg2.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.Search_fg, fg2).commit();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
