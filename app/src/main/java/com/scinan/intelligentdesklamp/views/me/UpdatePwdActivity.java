package com.scinan.intelligentdesklamp.views.me;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;

public class UpdatePwdActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_update_pwd;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.zhuce_bt)
    Button zhuceBt;

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
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_update_pwd;
    }
}
