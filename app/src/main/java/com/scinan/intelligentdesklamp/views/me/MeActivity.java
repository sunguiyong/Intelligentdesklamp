package com.scinan.intelligentdesklamp.views.me;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;

public class MeActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_me;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.headportrait_img)
    ImageView headportraitImg;
    @Bind(R.id.pwd_img)
    ImageView pwdImg;
    @Bind(R.id.updatepwd_rl)
    RelativeLayout updatepwdRl;
    @Bind(R.id.questionnaire_img)
    ImageView questionnaireImg;
    @Bind(R.id.questionnaire_rl)
    RelativeLayout questionnaireRl;
    @Bind(R.id.about_img)
    ImageView aboutImg;
    @Bind(R.id.about_rl)
    RelativeLayout aboutRl;
    @Bind(R.id.nick_rl)
    RelativeLayout nickRl;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.nick_rl: {
                Intent intent = new Intent(this, MyInfoActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.updatepwd_rl: {
                Intent intent = new Intent(this, UpdatePwdActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.questionnaire_rl: {
                Intent intent = new Intent(this, QuestionnaireActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.about_rl: {
                Intent intent = new Intent(this, AboutActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.back_img: {
                finish();
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        backImg.setOnClickListener(this);
        nickRl.setOnClickListener(this);
        updatepwdRl.setOnClickListener(this);
        questionnaireRl.setOnClickListener(this);
        aboutRl.setOnClickListener(this);
    }

    @Override
    public void initData() {
        //Glide加载网络图片作为头像，圆形
        Glide.with(mContext)
                .load("http://pic2.zhimg.com/50/v2-f34145b01ab1d5bb463cac35ddc9777d_hd.jpg")
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(headportraitImg);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_me;
    }
}
