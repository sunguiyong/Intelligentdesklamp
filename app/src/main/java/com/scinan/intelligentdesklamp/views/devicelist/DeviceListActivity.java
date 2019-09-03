package com.scinan.intelligentdesklamp.views.devicelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.FragmentMain;
import com.scinan.intelligentdesklamp.views.me.MeActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DeviceListActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_device_list;
    @Bind(R.id.devicelist_listview)
    ListView devicelistListview;
    @Bind(R.id.mine_img)
    ImageView mineImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.adddevice_img)
    ImageView adddeviceImg;
    private DeviceListAdapter deviceListAdapter;
    private DeviceListBean deviceListBean;
    private List<DeviceListBean> deviceListBeans = new ArrayList<>();

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_img: {
                Intent intent = new Intent(this, MeActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        devicelistListview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(mContext, FragmentMain.class);
                startActivity(intent);
            }
        });
        adddeviceImg.setOnClickListener(this);
        mineImg.setOnClickListener(this);
    }

    @Override
    public void initData() {
        DeviceListBean deviceListBean1 = new DeviceListBean("设备一");
        deviceListBeans.add(deviceListBean1);
        DeviceListBean deviceListBean2 = new DeviceListBean("设备二");
        deviceListBeans.add(deviceListBean2);
        DeviceListBean deviceListBean3 = new DeviceListBean("设备三");
        deviceListBeans.add(deviceListBean3);
        deviceListAdapter = new DeviceListAdapter(deviceListBeans, mContext, R.layout.item_devicelist);
        devicelistListview.setAdapter(deviceListAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_device_list;
    }

}
