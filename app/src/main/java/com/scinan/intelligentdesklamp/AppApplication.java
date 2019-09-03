package com.scinan.intelligentdesklamp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.scinan.intelligentdesklamp.utils.NetUtils;

import java.util.LinkedList;
import java.util.List;

public class AppApplication extends Application {
    private static String TAG = "AppApplication";

    /**
     * Application实例
     */
    private static AppApplication instance = null;
    private List<Activity> mActivityStack = new LinkedList<>();
    private RequestQueue mRequestQueue = null;

    private static int mMainThreadId = -1;
    private static Thread mMainThread;
    private static Handler mMainThreadHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        if (NetUtils.isNetworkConnected(this)) {

        } else {
            Toast.makeText(this, "请连接网络！", Toast.LENGTH_LONG).show();
        }
        mRequestQueue = Volley.newRequestQueue(this, null);
//        Fresco.initialize(this);
        //取消所有请求过滤
//        HttpsTrustManager.allowAllSSL();

    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    public static AppApplication getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this, null);
        }
        return mRequestQueue;
    }

    public void addActivity(Activity activity) {
        mActivityStack.add(activity);
        //Logger.d("在activity栈中添加(" + activity.getClass().getSimpleName() + ")");
        System.out.print("在activity栈中添加" + activity.getClass().getSimpleName());

    }

    public void finishActivity(Activity activity) {
        if (mActivityStack.contains(activity)) {
            mActivityStack.remove(activity);
            //Logger.d("从activity栈中移除(" + activity.getClass().getSimpleName() + ")");
        }
    }

    public void finishAllActivity() {
        StringBuilder stringBuilder = new StringBuilder("移除所有的activity:");
        for (Activity activity : mActivityStack) {
            if (activity != null) {
                stringBuilder.append("==").append(activity.getClass().getSimpleName()).append("==");
                activity.finish();
            }
        }
        Log.d(TAG, stringBuilder.toString());
        mActivityStack.clear();
    }

    public void finishOtherActivity() {
        for (int i = 1; i < mActivityStack.size(); i++) {
            if (mActivityStack.get(i - 1) != null) {
                mActivityStack.get(i - 1).finish();
            }
        }
        mActivityStack.clear();
    }

    public Activity getCurretActivity() {
        return mActivityStack.get(mActivityStack.size() - 1);
    }


    public static int getMainThreadId() {
        return mMainThreadId;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }
}
