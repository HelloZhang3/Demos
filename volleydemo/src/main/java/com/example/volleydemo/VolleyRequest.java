package com.example.volleydemo;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Volly请求封装
 * Created by Administrator on 2016/4/8 0008.
 */
public class VolleyRequest {

    public static Context mContext;
    public static StringRequest stringRequest;

    /**
     * Volley Get
     */
    public static void RequestGet(Context context, String url, String tag, VolleyInstance vif) {
        MyApplacation.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.GET, url, vif.loadingListener(), vif.errorListener());
        stringRequest.setTag(tag);
        MyApplacation.getHttpQueues().add(stringRequest);
        MyApplacation.getHttpQueues().start();
    }

    /**
     * Volley Post
     */
    public static void RequestPost(Context context, String url, String tag, final Map<String, String> params, VolleyInstance vif) {
        MyApplacation.getHttpQueues().cancelAll(tag);
        stringRequest = new StringRequest(Request.Method.POST, url, vif.loadingListener(), vif.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        stringRequest.setTag(tag);
        MyApplacation.getHttpQueues().add(stringRequest);
        MyApplacation.getHttpQueues().start();
    }
}
