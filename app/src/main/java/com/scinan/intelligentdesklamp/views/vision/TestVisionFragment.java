package com.scinan.intelligentdesklamp.views.vision;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseFragment;
import com.scinan.intelligentdesklamp.R;

import butterknife.Bind;

public class TestVisionFragment extends BaseFragment implements View.OnClickListener {
    int x = R.layout.fragment_testvision;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.function_tv)
    TextView functionTv;
    @Bind(R.id.lefteye_tv)
    TextView lefteyeTv;
    @Bind(R.id.righteye_tv)
    TextView righteyeTv;

    @SuppressLint("NewApi")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img: {
                getActivity().finish();
                break;
            }
            case R.id.lefteye_tv: {
                lefteyeTv.setTextColor(Color.WHITE);
                righteyeTv.setTextColor(Color.BLACK);
                break;
            }
            case R.id.righteye_tv: {
                righteyeTv.setTextColor(Color.WHITE);
                lefteyeTv.setTextColor(Color.BLACK);
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        backImg.setOnClickListener(this);
        lefteyeTv.setOnClickListener(this);
        righteyeTv.setOnClickListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_testvision;
    }

    private void initView() {

    }
}
