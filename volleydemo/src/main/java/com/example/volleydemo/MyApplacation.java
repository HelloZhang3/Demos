package com.example.volleydemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/3/15 0015.
 */
public class MyApplacation extends Application{

    public static RequestQueue mRequestQueue;

    @Override
    public void onCreate() {
        super.onCreate();

        mRequestQueue = Volley.newRequestQueue(getApplicationContext());

    }

    /**
     * 获取请求队列
     * @return
     */
    public static RequestQueue getHttpQueues(){
        return mRequestQueue;
    }
}
