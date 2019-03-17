package com.team.azusa.yiyuan.yiyuan_activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.yiyuan_usermsg_fragment.ShareOrderFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyShareOrderActivity extends AppCompatActivity {

    @BindView(R.id.return_shareorder)
    ImageView return_btn;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_share_order);
        ButterKnife.bind(this);
        user_id = UserUtils.user.getId();
        Fragment fg = new ShareOrderFragment();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", user_id);
        bundle.putInt("what", 1);
        fg.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.myshareorder_fg, fg).commit();
    }

    @OnClick(R.id.return_shareorder)
    public void onClick() {
        finish();
    }
}
