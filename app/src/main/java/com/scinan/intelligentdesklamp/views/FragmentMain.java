package com.scinan.intelligentdesklamp.views;

import android.annotation.SuppressLint;
import android.util.Log;

import com.hjm.bottomtabbar.BottomTabBar;
import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.clock.ClockFragment;
import com.scinan.intelligentdesklamp.views.datashow.DataShowFragment;
import com.scinan.intelligentdesklamp.views.setdevice.SetDeviceFragment;
import com.scinan.intelligentdesklamp.views.vision.TestVisionFragment;

import butterknife.Bind;

public class FragmentMain extends BaseActivity {
    int x = R.layout.tabbar_main;
    @Bind(R.id.bottom_tab_bar)
    BottomTabBar bottomTabBar;

    @Override
    public void bindListener() {

    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void initData() {
        bottomTabBar.init(getSupportFragmentManager())
                .setImgSize(60, 60)
                .setFontSize(16)
                .setTabPadding(30, 6, 20)
                .setChangeColor(getResources().getColor(R.color.toolbarcolor), getResources().getColor(R.color.normaltextcolor))
                .addTabItem("主页", R.mipmap.icon_touxiang, R.mipmap.icon_shebei_p, SetDeviceFragment.class)
                .addTabItem("时钟", R.mipmap.icon_touxiang, R.mipmap.icon_shebei_p, ClockFragment.class)
                .addTabItem("测视力",R.mipmap.icon_touxiang, R.mipmap.icon_shebei_p, TestVisionFragment.class)
                .addTabItem("数据",R.mipmap.icon_touxiang, R.mipmap.icon_shebei_p, DataShowFragment.class)
                .isShowDivider(false)
//                .setTabBarBackgroundColor(R.color.black)
                .setDividerColor(getResources().getColor(R.color.colorWhite))
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {
                        Log.d("TGA", "位置：" + position + "选项卡的文字内容：" + name);
                    }
                });
    }

    @Override
    public int getLayoutId() {
        return R.layout.tabbar_main;
    }

}
