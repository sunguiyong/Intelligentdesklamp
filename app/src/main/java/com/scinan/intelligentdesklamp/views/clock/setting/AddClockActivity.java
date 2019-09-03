package com.scinan.intelligentdesklamp.views.clock.setting;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;

public class AddClockActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_add_clock;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.function_tv)
    TextView functionTv;
    @Bind(R.id.timepicker)
    TimePicker timepicker;
    @Bind(R.id.numberpicker1)
    NumberPicker numberpicker1;
    @Bind(R.id.numberpicker2)
    NumberPicker numberpicker2;
    @Bind(R.id.right_img1)
    ImageView rightImg1;
    @Bind(R.id.repeat_rl)
    RelativeLayout repeatRl;
    @Bind(R.id.right_img2)
    ImageView rightImg2;
    @Bind(R.id.clockname_rl)
    RelativeLayout clocknameRl;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img: {
                finish();
                break;
            }
            case R.id.repeat_rl: {
                showDialogItem();
                break;
            }
            case R.id.clockname_rl: {
                showDialogEditText();
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        backImg.setOnClickListener(this);
        repeatRl.setOnClickListener(this);
        clocknameRl.setOnClickListener(this);
    }

    @Override
    public void initData() {
        initNumberPicker();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_clock;
    }

    private void showDialogEditText() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_edittext, null);
        TextView cancel = view.findViewById(R.id.choosepage_cancel);
        TextView sure = view.findViewById(R.id.choosepage_sure);
        final EditText editText = view.findViewById(R.id.choosepage_edittext);
        final Dialog dialog = builder.create();
        dialog.show();
        dialog.getWindow().setContentView(view);
        //唤起键盘
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("cancel");
                dialog.dismiss();
            }
        });
        sure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("sure" + editText.getText().toString());
                dialog.dismiss();
            }
        });
    }

    private void showDialogItem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_item_repeat, null);
        RadioButton radioButton1 = view.findViewById(R.id.rbt1);
        RadioButton radioButton2 = view.findViewById(R.id.rbt2);
        RadioButton radioButton3 = view.findViewById(R.id.rbt3);
        RadioButton radioButton4 = view.findViewById(R.id.rbt4);
        RadioButton radioButton5 = view.findViewById(R.id.rbt5);
        TextView cancel = view.findViewById(R.id.cancel_tv);
        final Dialog dialog=builder.create();
        dialog.show();
        dialog.getWindow().setContentView(view);
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
