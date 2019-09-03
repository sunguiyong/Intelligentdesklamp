package com.scinan.intelligentdesklamp.views.me;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AboutActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_about;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.logo_img)
    ImageView logoImg;

    @Override
    public void bindListener() {
        backImg.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_about;
    }

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
