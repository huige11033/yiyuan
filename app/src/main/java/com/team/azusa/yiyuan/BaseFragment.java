package com.team.azusa.yiyuan;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;

    protected View view;

    public abstract int layout();

    public abstract void initView();

    public abstract void initData();

    public abstract void initAnimation();

    public abstract void setListener();

    public void getData(int index){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(layout(), null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        initAnimation();
        setListener();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
