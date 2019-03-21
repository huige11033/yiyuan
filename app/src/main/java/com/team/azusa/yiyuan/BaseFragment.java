package com.team.azusa.yiyuan;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.team.azusa.yiyuan.network.RequestService;
import com.zhy.http.okhttp.OkHttpUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import de.greenrobot.event.EventBus;

public abstract class BaseFragment extends Fragment {
    private Unbinder unbinder;
    public String TAG = getClass().getSimpleName();

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
        if(isUseEvent()){
            EventBus.getDefault().register(this);
        }
        initView();
        initData();
        initAnimation();
        setListener();
        return view;
    }

    public boolean isUseEvent() {
        return false;
    }

    @Override
    public void onDestroyView() {
        OkHttpUtils.getInstance().cancelTag(TAG);
        if(isUseEvent()){
            EventBus.getDefault().unregister(this);
        }
        super.onDestroyView();
        unbinder.unbind();
    }
}
