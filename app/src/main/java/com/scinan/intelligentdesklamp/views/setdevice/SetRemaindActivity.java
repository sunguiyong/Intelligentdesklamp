package com.scinan.intelligentdesklamp.views.setdevice;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SetRemaindActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_set_remaind;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.function_bt)
    ImageView functionBt;
    @Bind(R.id.addition1)
    ImageView addition1;
    @Bind(R.id.et_1)
    EditText et1;
    @Bind(R.id.subtraction1)
    ImageView subtraction1;
    @Bind(R.id.addition2)
    ImageView addition2;
    @Bind(R.id.et_2)
    EditText et2;
    @Bind(R.id.subtraction2)
    ImageView subtraction2;
    @Bind(R.id.addition3)
    ImageView addition3;
    @Bind(R.id.et_3)
    EditText et3;
    @Bind(R.id.subtraction3)
    ImageView subtraction3;
    @Bind(R.id.addition4)
    ImageView addition4;
    @Bind(R.id.et_4)
    EditText et4;
    @Bind(R.id.subtraction4)
    ImageView subtraction4;
    @Bind(R.id.addition5)
    ImageView addition5;
    @Bind(R.id.et_5)
    EditText et5;
    @Bind(R.id.subtraction5)
    ImageView subtraction5;
    @Bind(R.id.tv_2)
    TextView tv2;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img: {
                finish();
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        backImg.setOnClickListener(this);
        functionBt.setOnClickListener(this);
    }

    @Override
    public void initData() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        tv2.requestFocus();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_remaind;
    }

}
