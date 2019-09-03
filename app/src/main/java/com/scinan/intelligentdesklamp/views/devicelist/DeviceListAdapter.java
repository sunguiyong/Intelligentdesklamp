package com.scinan.intelligentdesklamp.views.devicelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maple.msdialog.ActionSheetDialog;
import com.scinan.intelligentdesklamp.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DeviceListAdapter extends BaseAdapter {
    int x = R.layout.item_devicelist;
    private List<DeviceListBean> deviceListBeans;
    private Context context;
    private int resourceId;

    public DeviceListAdapter(List<DeviceListBean> deviceListBeans, Context context, int resourceId) {
        this.deviceListBeans = deviceListBeans;
        this.context = context;
        this.resourceId = resourceId;
    }

    public List<DeviceListBean> getDeviceListBeans() {
        return deviceListBeans;
    }

    public void setDeviceListBeans(List<DeviceListBean> deviceListBeans) {
        this.deviceListBeans = deviceListBeans;
    }

    @Override
    public int getCount() {
        return deviceListBeans == null ? 0 : deviceListBeans.size();
    }

    @Override
    public Object getItem(int i) {
        return deviceListBeans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_devicelist, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.devicenameTv.setText(deviceListBeans.get(position).getName());
        viewHolder.expandTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
        return convertView;
    }
    public void showDialog() {
        new ActionSheetDialog(context)
                .addSheetItem("删除", context.getResources().getColor(R.color.dialog), new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                })
                .addSheetItem("重命名", context.getResources().getColor(R.color.dialog), new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                })
                .setCancelText("取消", context.getResources().getColor(R.color.dialog), 18, false)
                .setCanceledOnTouchOutside(true)
                .setCancelable(true)
                .show();
    }
    static
    class ViewHolder {
        @Bind(R.id.device_img)
        ImageView deviceImg;
        @Bind(R.id.devicename_tv)
        TextView devicenameTv;
        @Bind(R.id.expand_tv)
        TextView expandTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
