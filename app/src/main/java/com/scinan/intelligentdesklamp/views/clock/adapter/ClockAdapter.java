package com.scinan.intelligentdesklamp.views.clock.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.clock.bean.ClockBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClockAdapter extends BaseAdapter {
    int x = R.layout.item_clock;
    private List<ClockBean> clockBeanList;
    private int resourceId;
    private Context context;

    public ClockAdapter(List<ClockBean> clockBeanList, int resourceId, Context context) {
        this.clockBeanList = clockBeanList;
        this.resourceId = resourceId;
        this.context = context;
    }

    @Override
    public int getCount() {
        return clockBeanList == null ? 0 : clockBeanList.size();
    }

    @Override
    public Object getItem(int i) {
        return clockBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_clock, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.timeTv.setText(clockBeanList.get(i).getTime());
        viewHolder.dayTv.setText(clockBeanList.get(i).getDay());
        return view;
    }

    static
    class ViewHolder {
        @Bind(R.id.time_tv)
        TextView timeTv;
        @Bind(R.id.day_tv)
        TextView dayTv;
        @Bind(R.id.clock_switch)
        Switch clockSwitch;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
