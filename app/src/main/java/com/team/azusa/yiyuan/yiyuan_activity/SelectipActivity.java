package com.team.azusa.yiyuan.yiyuan_activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.team.azusa.yiyuan.R;
import com.team.azusa.yiyuan.config.Config;
import com.team.azusa.yiyuan.utils.StringUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectipActivity extends AppCompatActivity {

    @BindView(R.id.editip)
    EditText editip;
    @BindView(R.id.tvip1)
    RadioButton tvip1;
    @BindView(R.id.tvip2)
    RadioButton tvip2;
    @BindView(R.id.tvip3)
    RadioButton tvip3;
    @BindView(R.id.tvip4)
    RadioButton tvip4;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.tvip5)
    RadioButton tvip5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectip);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn)
    public void onClick() {
        if (StringUtil.isEmpty(editip.getText().toString())) {
            switch (radioGroup.getCheckedRadioButtonId()) {
                case R.id.tvip1:
                    Config.IP = tvip1.getText().toString();
                    break;
                case R.id.tvip2:
                    Config.IP = tvip2.getText().toString();
                    break;
                case R.id.tvip3:
                    Config.IP = tvip3.getText().toString();
                    break;
                case R.id.tvip4:
                    Config.IP = tvip4.getText().toString();
                    break;
                case R.id.tvip5:
                    Config.IP = tvip5.getText().toString();
                    break;
            }
        } else {
            Config.IP = "http://" + editip.getText().toString();
        }
        startActivity(new Intent(SelectipActivity.this, WelcomeActivity.class));
        finish();
    }
}
