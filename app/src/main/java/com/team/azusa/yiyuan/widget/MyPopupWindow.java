package com.team.azusa.yiyuan.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.adapter.PopupWindowAdapter;
import com.team.azusa.yiyuan.bean.SortType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Azusa on 2016/1/16.
 */
public class MyPopupWindow {
    private PopupWindow popupWindow;
    private ListView mlistView;
    private PopupWindowAdapter adapter;
    private ArrayList<SortType> datas = new ArrayList<>();
    private int currentPosition = 0;
    private TextView tv_sort;
    private OnPopupItemClickListener listener;


    public MyPopupWindow build(Context context, View view, View fullScreenView, int topHeight, TextView tv_sort) {
        popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT,
                fullScreenView.getHeight() - topHeight);
        this.tv_sort = tv_sort;
        mlistView = view.findViewById(R.id.popuwin_listview);
        adapter = new PopupWindowAdapter(context, datas);
        mlistView.setAdapter(adapter);
        setListener();

        return this;
    }

    public void setCheck(int position) {
        if (currentPosition != 0) {
            datas.get(currentPosition).setIscheck(false);
        }
        currentPosition = position;
        datas.get(position).setIscheck(true);
        tv_sort.setText(datas.get(position).getStringdatas());
        adapter.notifyDataSetChanged();
    }

    private void setListener() {
        mlistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (currentPosition == position) {
                    return;
                } else {
                    datas.get(currentPosition).setIscheck(false);
                    currentPosition = position;
                    datas.get(position).setIscheck(true);
                    tv_sort.setText(datas.get(position).getStringdatas());
                    adapter.notifyDataSetChanged();
                    popupWindow.dismiss();
                    if (listener != null) {
                        listener.onItemClick(position);
                    }
                }
            }
        });
    }

    public PopupWindow showLocation(View view, final View arrow) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.WHITE);
        popupWindow.setBackgroundDrawable(colorDrawable);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.showAsDropDown(view);
        popupWindow.update();
        if (arrow != null) {
            arrow.setVisibility(View.VISIBLE);
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    arrow.setVisibility(View.GONE);
                }
            });
        }
        return popupWindow;
    }


    public MyPopupWindow setData(List<String> names) {
        if (names == null || names.isEmpty()) {
            return this;
        }
        datas.clear();
        for (int i = 0; i < names.size(); i++) {
            datas.add(new SortType(names.get(i), i == 0));
        }
        adapter.notifyDataSetChanged();
        tv_sort.setText(names.get(0));
        setCheck(0);
        return this;
    }

    public void setOnItemClick(OnPopupItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnPopupItemClickListener {
        void onItemClick(int position);
    }

}
