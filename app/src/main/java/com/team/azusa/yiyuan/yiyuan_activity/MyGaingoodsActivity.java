package com.team.azusa.yiyuan.yiyuan_activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.utils.UserUtils;
import com.team.azusa.yiyuan.yiyuan_usermsg_fragment.GainedgoodsFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyGaingoodsActivity extends AppCompatActivity {

    @BindView(R.id.return_mygaingoods)
    ImageView return_btn;
    private String user_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gaingoods);
        ButterKnife.bind(this);
        user_id = UserUtils.user.getId();
        Fragment fg = new GainedgoodsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("user_id", user_id);
        bundle.putInt("what", 1);
        fg.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(R.id.mygaingoods_fg, fg).commit();
    }

    @OnClick(R.id.return_mygaingoods)
    public void onClick() {
        finish();
    }
}
