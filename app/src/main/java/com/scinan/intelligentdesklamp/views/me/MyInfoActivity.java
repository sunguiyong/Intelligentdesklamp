package com.scinan.intelligentdesklamp.views.me;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.maple.msdialog.ActionSheetDialog;
import com.maple.msdialog.AlertDialog;
import com.scinan.intelligentdesklamp.BaseActivity;
import com.scinan.intelligentdesklamp.R;
import com.scinan.intelligentdesklamp.utils.dialog.CommonDialog;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyInfoActivity extends BaseActivity implements View.OnClickListener {
    int x = R.layout.activity_my_info;
    @Bind(R.id.back_img)
    ImageView backImg;
    @Bind(R.id.devicename_tv)
    TextView devicenameTv;
    @Bind(R.id.history)
    TextView history;
    @Bind(R.id.right_img1)
    ImageView rightImg1;
    @Bind(R.id.headportrait_rl)
    RelativeLayout headportraitRl;
    @Bind(R.id.right_img2)
    ImageView rightImg2;
    @Bind(R.id.nick_rl)
    RelativeLayout nickRl;
    @Bind(R.id.right_img3)
    ImageView rightImg3;
    @Bind(R.id.wechat_rl)
    RelativeLayout wechatRl;
    @Bind(R.id.right_img4)
    ImageView rightImg4;
    @Bind(R.id.qq_rl)
    RelativeLayout qqRl;
    @Bind(R.id.signout_bt)
    Button signoutBt;
    @Bind(R.id.headportrait_img)
    ImageView headportraitImg;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.headportrait_rl: {
                showDialog();
                break;
            }
            case R.id.back_img: {
                finish();
                break;
            }
            case R.id.wechat_rl: {
                initDialog();
                break;
            }
            case R.id.qq_rl: {
                break;
            }
            case R.id.nick_rl: {
                Intent intent = new Intent(this, NickActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public void bindListener() {
        headportraitRl.setOnClickListener(this);
        nickRl.setOnClickListener(this);
        wechatRl.setOnClickListener(this);
        qqRl.setOnClickListener(this);
        signoutBt.setOnClickListener(this);
        backImg.setOnClickListener(this);
    }

    @Override
    public void initData() {
        Glide.with(mContext).load("http://pic2.zhimg.com/50/v2-f34145b01ab1d5bb463cac35ddc9777d_hd.jpg")
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(headportraitImg);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_my_info;
    }

    public void showDialog() {
        new ActionSheetDialog(mContext)
                .addSheetItem("拍照", mContext.getResources().getColor(R.color.dialog), new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                })
                .addSheetItem("从相册选择", mContext.getResources().getColor(R.color.dialog), new ActionSheetDialog.OnSheetItemClickListener() {
                    @Override
                    public void onClick(int which) {

                    }
                })
                .setCancelText("取消", mContext.getResources().getColor(R.color.dialog), 18, false)
                .setCanceledOnTouchOutside(true)
                .setCancelable(true)
                .show();
    }

    private void initDialog() {
        final CommonDialog dialog = new CommonDialog(this);
        dialog.setMessage("确定要解除绑定吗？")
                .setOnClickBottomListener(new CommonDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        dialog.dismiss();
                        Toast.makeText(mContext, "确定", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNegtiveClick() {
                        dialog.dismiss();
                        Toast.makeText(mContext, "取消", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}
