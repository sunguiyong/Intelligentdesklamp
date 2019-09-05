package com.scinan.intelligentdesklamp.views.clock.setting;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.clock.bean.CardItem;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.Bind;

public class DateAndTimeActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_date_and_time;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.hour24_sw)
    Switch hour24Sw;
    @Bind(R.id.autodateandtime_sw)
    Switch autodateandtimeSw;
    @Bind(R.id.right_img1)
    ImageView rightImg1;
    @Bind(R.id.settime_rl)
    RelativeLayout settimeRl;
    @Bind(R.id.autotimezoon_sw)
    Switch autotimezoonSw;
    @Bind(R.id.right_img2)
    ImageView rightImg2;
    @Bind(R.id.timezoon_rl)
    RelativeLayout timezoonRl;
    @Bind(R.id.settime_tv)
    TextView settimeTv;
    @Bind(R.id.time_tv)
    TextView timeTv;

    private DateAndTimeEvent dateAndTimeEvent = new DateAndTimeEvent();
    private List<CardItem> cardItems = new ArrayList<>();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.settime_rl: {
                Calendar selectedDate = Calendar.getInstance();
                Calendar startDate = Calendar.getInstance();
                startDate.setTime(new Date());
                Calendar endDate = Calendar.getInstance();
                endDate.setTime(new Date());

                OptionsPickerView opv = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        String tx = cardItems.get(options1).getPickerViewText();
                    }
                })
                        .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
                            @Override
                            public void customLayout(View v) {
                                final TextView title = (TextView) findViewById(R.id.title_tv);

                            }
                        })
                        .setTitleText("设置时间")
                        .isDialog(true)
                        .setBackgroundId(R.color.colorWhite)
                        .build();
//                opv.show();
                opv.setPicker(cardItems);
                break;
            }
            case R.id.back_img: {
                finish();
                break;
            }
            case R.id.timezoon_rl: {
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        timezoonRl.setOnClickListener(this);
        settimeRl.setOnClickListener(this);
        hour24Sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    dateAndTimeEvent.setHour24(true);
                } else {
                    dateAndTimeEvent.setHour24(false);
                }
                EventBus.getDefault().post(dateAndTimeEvent);
            }
        });
        autodateandtimeSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    settimeTv.setTextColor(Color.GRAY);
                    timeTv.setTextColor(Color.GRAY);
                    settimeRl.setClickable(true);
                } else {
                    settimeTv.setTextColor(Color.LTGRAY);
                    timeTv.setTextColor(Color.LTGRAY);
                    settimeRl.setClickable(false);
                }
            }
        });
    }

    @Override
    public void initData() {
        EventBus.getDefault().register(this);
        EventBus.getDefault().post(dateAndTimeEvent);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_date_and_time;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(final DateAndTimeEvent dateAndTimeEvent) {
        if (dateAndTimeEvent.isAutoDateAndTime()) {
            showToast("开始了");
        } else {
            showToast("不行");
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    settimeTv.setTextColor(getResources().getColor(R.color.normaltextcolor));
                }
            });

        }
    }
}
