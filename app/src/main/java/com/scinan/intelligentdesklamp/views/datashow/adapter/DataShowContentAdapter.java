package com.scinan.intelligentdesklamp.views.datashow.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.scinan.intelligentdesklamp.views.datashow.contentfragment.LeftEyeFragment;
import com.scinan.intelligentdesklamp.views.datashow.contentfragment.RightEyeFragment;
import com.scinan.intelligentdesklamp.views.datashow.contentfragment.SittingPostureFragment;
import com.scinan.intelligentdesklamp.views.datashow.contentfragment.UseTimeFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置数据fragment中的子fragment
 */
public class DataShowContentAdapter extends FragmentPagerAdapter {
    private List<String> names;

    public DataShowContentAdapter(FragmentManager fm) {
        super(fm);
        this.names = new ArrayList<>();
    }

    public void setList(List<String> datas) {
        this.names.clear();
        this.names.addAll(datas);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0: {
                fragment = new SittingPostureFragment();
                break;
            }
            case 1: {
                fragment = new LeftEyeFragment();
                break;
            }
            case 2: {
                fragment = new RightEyeFragment();
                break;
            }
            case 3: {
                fragment = new UseTimeFragment();
                break;
            }
            default:
                fragment = new SittingPostureFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String plateName = names.get(position);
        if (plateName == null) {
            plateName = "";
        } else if (plateName.length() > 15) {
            plateName = plateName.substring(0, 15) + "...";
        }
        return plateName;
    }
}
