package com.scinan.intelligentdesklamp.views.clock.setting;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;

public class SetClockActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_set_clock;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.addclock_rl)
    RelativeLayout addclockRl;
    @Bind(R.id.dateandtime_rl)
    RelativeLayout dateandtimeRl;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addclock_rl: {
                Intent intent = new Intent(this, AddClockActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.back_img: {
                finish();
                break;
            }
            case R.id.dateandtime_rl: {
                Intent intent = new Intent(this, DateAndTimeActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        addclockRl.setOnClickListener(this);
        backImg.setOnClickListener(this);
        dateandtimeRl.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_set_clock;
    }

}
