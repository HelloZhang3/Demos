package com.example.vollyImageDemo;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/4/8 0008.
 */
public class MyApplacation extends Application {

    public RequestQueue instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance= Volley.newRequestQueue(getApplicationContext());
    }
}
