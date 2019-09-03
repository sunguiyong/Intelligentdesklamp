package com.scinan.intelligentdesklamp.views.clock.editclock;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class EditClockActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_edit_clock;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.timepicker)
    TimePicker timepicker;
    @Bind(R.id.numberpicker1)
    NumberPicker numberpicker1;
    @Bind(R.id.numberpicker2)
    NumberPicker numberpicker2;

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
        initTimePicker();
        initNumberPicker();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_edit_clock;
    }

    @SuppressLint("NewApi")
    private void initTimePicker() {
        timepicker.setDescendantFocusability(TimePicker.FOCUS_BLOCK_DESCENDANTS);
        timepicker.setIs24HourView(true);
        timepicker.setHour(9);
        timepicker.setMinute(10);

        Resources systemResources = Resources.getSystem();
        int hourNumberPickerId = systemResources.getIdentifier("hour", "id", "android");
        int minuteNumberPickerId = systemResources.getIdentifier("minute", "id", "android");
        NumberPicker hourNumberPicker = (NumberPicker) timepicker.findViewById(hourNumberPickerId);
        NumberPicker minuteNumberPicker = (NumberPicker) timepicker.findViewById(minuteNumberPickerId);

    }

    @SuppressLint("NewApi")
    private void initNumberPicker() {
        numberpicker1.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberpicker1.setMinValue(0);
        numberpicker1.setMaxValue(23);
        numberpicker1.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                String tmpStr = String.valueOf(i);
                if (i < 10) {
                    tmpStr = "0" + tmpStr;
                }
                return tmpStr;
            }
        });

        numberpicker2.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        numberpicker2.setMinValue(0);
        numberpicker2.setMaxValue(59);
        numberpicker2.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int i) {
                String tmpStr = String.valueOf(i);
                if (i < 10) {
                    tmpStr = "0" + tmpStr;
                }
                return tmpStr;
            }
        });
    }
}
