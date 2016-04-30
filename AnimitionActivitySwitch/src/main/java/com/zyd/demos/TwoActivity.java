package com.zyd.demos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myFinish();

            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:

                myFinish();

                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 自定义返回
     */
    private void myFinish() {

        finish();
        //在finish之后调用
        overridePendingTransition(R.animator.slide_in_left, R.animator.slide_out_right);
    }
}
