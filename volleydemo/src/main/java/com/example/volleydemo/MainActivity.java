package com.example.volleydemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.VolleyError;

/**
 * Created by Administrator on 2016/4/8 0008.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VolleyGet();
    }


    private void VolleyGet() {
        String url = "http://www.baojian.com/app/index.php?com=com_appService&method=appSev&app_com=com_ad&task=top&optionid=109";
        VolleyRequest.RequestGet(this, url, "abc", new VolleyInstance(this, VolleyInstance.mListener, VolleyInstance.mErrorListener) {
            @Override
            public void onMySuccess(String result) {
                Toast.makeText(MainActivity.this, result.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMyError(VolleyError error) {
                Toast.makeText(MainActivity.this, error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();

        MyApplacation.getHttpQueues().cancelAll("");
    }
}
