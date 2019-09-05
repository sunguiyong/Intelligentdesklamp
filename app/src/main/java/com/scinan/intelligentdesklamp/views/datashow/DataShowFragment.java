package com.scinan.intelligentdesklamp.views.datashow;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.scinan.intelligentdesklamp.BaseFragment;
import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.datashow.adapter.DataShowContentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

public class DataShowFragment extends BaseFragment implements View.OnClickListener {
    int x = R.layout.fragment_datashow;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.title_tv)
    TextView titleTv;
    @Bind(R.id.function_tv)
    TextView functionTv;
    @Bind(R.id.tablayout)
    TabLayout tablayout;
    @Bind(R.id.viewpager)
    ViewPager viewpager;

    private List<String> names;
    private DataShowContentAdapter adapter;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_img: {
                getActivity().finish();
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
        initFragment();
        int i = 3;
        String s = i++ + "1";
        Log.d("s", s);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_datashow;
    }

    private void initFragment() {
        viewpager.setOffscreenPageLimit(4);
        tablayout.addTab(tablayout.newTab().setText("坐姿"));
        tablayout.addTab(tablayout.newTab().setText("左眼视力"));
        tablayout.addTab(tablayout.newTab().setText("右眼视力"));
        tablayout.addTab(tablayout.newTab().setText("使用时间"));
        tablayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.black));
        adapter = new DataShowContentAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpager);
        initTabData();
        adapter.setList(names);
    }

    private void initTabData() {
        names = new ArrayList<>();
        names.add("坐姿");
        names.add("左眼视力");
        names.add("右眼视力");
        names.add("使用时间");
    }
}
