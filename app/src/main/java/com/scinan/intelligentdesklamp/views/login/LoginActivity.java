package com.scinan.intelligentdesklamp.views.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.devicelist.DeviceListActivity;
import com.scinan.intelligentdesklamp.views.register.RegistActivity;

import butterknife.Bind;

public class LoginActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_login;
    @Bind(R.id.logo_img)
    ImageView logoImg;
    @Bind(R.id.phone_et)
    EditText phoneEt;
    @Bind(R.id.pwd_et)
    EditText pwdEt;
    @Bind(R.id.eye_img)
    ImageView eyeImg;
    @Bind(R.id.forgetpsd_tv)
    TextView forgetpsdTv;
    @Bind(R.id.login_bt)
    Button loginBt;
    @Bind(R.id.msg_login_tv)
    TextView msgLoginTv;
    @Bind(R.id.register_tv)
    TextView registerTv;
    @Bind(R.id.weixin_imgbt)
    ImageButton weixinImgbt;
    @Bind(R.id.qq_imgbt)
    ImageButton qqImgbt;
    @Bind(R.id.version_tv)
    TextView versionTv;

    @Override
    public void bindListener() {
        msgLoginTv.setOnClickListener(this);
        registerTv.setOnClickListener(this);
        forgetpsdTv.setOnClickListener(this);
        loginBt.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        return R.layout.activity_login;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.msg_login_tv: {
                Intent intent = new Intent(this, MsgLoginActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.register_tv: {
                Intent intent = new Intent(this, RegistActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.forgetpsd_tv: {
                Intent intent = new Intent(this, ForgetPwdActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.login_bt: {
                Intent intent = new Intent(this, DeviceListActivity.class);
                startActivity(intent);
                break;
            }
        }
    }
}
