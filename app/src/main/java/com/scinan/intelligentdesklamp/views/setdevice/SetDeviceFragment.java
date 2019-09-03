package com.scinan.intelligentdesklamp.views.setdevice;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseFragment;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;

public class SetDeviceFragment extends BaseFragment implements View.OnClickListener {
    int x = R.layout.fragment_set_device;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.switch_bt)
    Button switchBt;
    @Bind(R.id.posture_bt)
    Button postureBt;
    @Bind(R.id.rest_tv)
    Button restTv;
    @Bind(R.id.seekBar_light)
    SeekBar seekBarLight;
    @Bind(R.id.checkBox_light)
    CheckBox checkBoxLight;
    @Bind(R.id.seekBar_volume)
    SeekBar seekBarVolume;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img: {
                getActivity().finish();
                break;
            }
            case R.id.history: {
                startActivity(new Intent(mContext, SetRemaindActivity.class));
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        backImg.setOnClickListener(this);
        history.setOnClickListener(this);
    }

    @Override
    public void initData() {
        seekBarLight.getThumb().setColorFilter(getResources().getColor(R.color.toolbarcolor), PorterDuff.Mode.SRC_ATOP);
        seekBarLight.getProgressDrawable().setColorFilter(getResources().getColor(R.color.toolbarcolor), PorterDuff.Mode.SRC_ATOP);
        seekBarVolume.getThumb().setColorFilter(getResources().getColor(R.color.toolbarcolor), PorterDuff.Mode.SRC_ATOP);
        seekBarVolume.getProgressDrawable().setColorFilter(getResources().getColor(R.color.toolbarcolor), PorterDuff.Mode.SRC_ATOP);

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_set_device;
    }
}
