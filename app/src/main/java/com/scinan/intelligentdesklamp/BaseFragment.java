package com.scinan.intelligentdesklamp;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.ImageRequest;
import com.google.gson.JsonObject;
import com.scinan.intelligentdesklamp.utils.net.ATTJsonRequest;

import org.json.JSONObject;

import java.util.HashMap;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment implements InitViews {
    protected AppCompatActivity mContext;
    protected View mRoot = null;
    private int cursor;

    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public int getCursor() {
        return cursor;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = (AppCompatActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        initData();
        bindListener();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onDestroy() {
        AppApplication.getInstance().getRequestQueue().cancelAll("VolleyRequest");
        super.onDestroy();
    }

    public <T> void getDataFromServer(int method, String url, Class<T> clazz, Response.Listener<T> listener,
                                      Response.ErrorListener errorListener) {
        ATTJsonRequest<T> qBaoJsonRequest = new ATTJsonRequest<T>(method, url, clazz, listener, errorListener);
        executeRequest(qBaoJsonRequest);
    }

    public <T> void getDataFromServer(int method, String url, HashMap<String, String> params,
                                      Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        ATTJsonRequest<T> qBaoJsonRequest = new ATTJsonRequest<T>(method, url, clazz, listener, errorListener);
        if (params != null) {
            qBaoJsonRequest.addParams(params);
        }
        executeRequest(qBaoJsonRequest);
    }

    public <T> void getDataFromServer(int method, String url, JsonObject jsonObject, Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        ATTJsonRequest<T> qBaoJsonRequest = new ATTJsonRequest<T>(url, clazz, jsonObject, listener, errorListener);
        executeRequest(qBaoJsonRequest);
    }

    public <T> void getDataFromServer(String url, JSONObject jsonRequest,
                                      Class<T> clazz, Response.Listener<T> listener, Response.ErrorListener errorListener) {
        ATTJsonRequest<T> attJsonRequest = new ATTJsonRequest<T>(url, clazz, jsonRequest, listener, errorListener);
        executeRequest(attJsonRequest);
    }

    public void getImageFromServer(String url, Response.Listener<Bitmap> listener, Response.ErrorListener errorListener) {
        ImageRequest imageRequest = new ImageRequest(
                url, listener, 0, 0, Bitmap.Config.RGB_565, errorListener);
        executeRequest(imageRequest);
    }

    protected void executeRequest(Request<?> request) {
        request.setTag(this);
        AppApplication.getInstance().getRequestQueue().add(request);
    }

    protected void showToast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(String msg, int time) {
        Toast.makeText(mContext, msg, time).show();
    }

    /**
     * 是否在事件总线中注册
     *
     * @return 返回true则要在相应的activity中定义public void onEvent(SomeEvent event)方法,默认返回false
     */
    protected boolean registerEventBus() {
        return false;
    }

    public void skipToLoginActivity() {
//        if (getActivity() != null) {
//            Intent intent = new Intent(getActivity(), LoginActivity.class);
//            intent.putExtra("from", "session");
//            getActivity().startActivity(intent);
//            ATTApplication.getInstance().finishOtherActivity();
//        }
    }
}
