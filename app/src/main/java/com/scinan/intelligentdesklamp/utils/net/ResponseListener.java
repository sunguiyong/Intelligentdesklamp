package com.scinan.intelligentdesklamp.utils.net;

import com.android.volley.Response;

/**
 * Created by Arthas on 2017/7/31.
 */

public interface ResponseListener extends Response.ErrorListener{
    void onResponse(String response);
}
