package com.team.azusa.yiyuan.yiyuan_activity;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.TabFragmentPagerAdapter;
import com.team.azusa.yiyuan.recharge_fragment.BankRechargeFragment;
import com.team.azusa.yiyuan.recharge_fragment.CardRechargeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RechargeActivity extends AppCompatActivity {

    @BindView(R.id.return_recharge)
    ImageView returnRecharge;
    @BindView(R.id.tv_acountdetail)
    TextView tvAcountdetail;
    @BindView(R.id.tablayout_recharge)
    TabLayout mtablayout;
    @BindView(R.id.vp_recharge)
    ViewPager mviewpager;

    private View view;
    ArrayList<Fragment> fragmentsList;
    ArrayList<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);
        ButterKnife.bind(this);
        iniView();
    }

    private void iniView() {
        titles = new ArrayList<>();
        titles.add("网银充值");
        titles.add("充值卡充值");

        mtablayout.addTab(mtablayout.newTab().setText(titles.get(0)));
        mtablayout.addTab(mtablayout.newTab().setText(titles.get(1)));

        mtablayout.setTabTextColors(getResources().getColor(R.color.tabcolor), getResources().getColor(R.color.tabcolor_select));

        mviewpager.setOffscreenPageLimit(2);
        fragmentsList = new ArrayList<>();
        Fragment bankRechargeFragment = new BankRechargeFragment();
        Fragment cardRechargeFragment = new CardRechargeFragment();

        fragmentsList.add(bankRechargeFragment);
        fragmentsList.add(cardRechargeFragment);
        TabFragmentPagerAdapter tabFragmentPagerAdapter = new TabFragmentPagerAdapter(
                getSupportFragmentManager(), fragmentsList, titles);
        mviewpager.setAdapter(new TabFragmentPagerAdapter(
                getSupportFragmentManager(), fragmentsList, titles));
        mviewpager.setCurrentItem(0);

        mtablayout.setupWithViewPager(mviewpager);
        mtablayout.setTabsFromPagerAdapter(tabFragmentPagerAdapter);
    }


    @OnClick({R.id.return_recharge, R.id.tv_acountdetail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.return_recharge:
                finish();
                break;
            case R.id.tv_acountdetail:
                break;
        }
    }
}
