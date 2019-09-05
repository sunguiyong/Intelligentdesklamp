package com.scinan.intelligentdesklamp.views.datashow.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.views.datashow.bean.LeftEyeDataBean;
import com.scinan.intelligentdesklamp.views.datashow.bean.RightEyeDataBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RightEyeDataAdapter extends BaseAdapter {
    int x = R.layout.item_lefteyedata;
    private List<RightEyeDataBean> rightEyeDataBeans;
    private Context context;
    private int resoourceId;

    public RightEyeDataAdapter(List<RightEyeDataBean> rightEyeDataBeans, Context context, int resoourceId) {
        this.rightEyeDataBeans = rightEyeDataBeans;
        this.context = context;
        this.resoourceId = resoourceId;
    }

    @Override
    public int getCount() {
        return rightEyeDataBeans == null ? 0 : rightEyeDataBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return rightEyeDataBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resoourceId, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.timeTv.setText(rightEyeDataBeans.get(i).getTime());
        viewHolder.visionTv.setText(rightEyeDataBeans.get(i).getVision());
        return view;
    }

    static
    class ViewHolder {
        @Bind(R.id.time_tv)
        TextView timeTv;
        @Bind(R.id.vision_tv)
        TextView visionTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
