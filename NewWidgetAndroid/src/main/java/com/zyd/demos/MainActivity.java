package com.zyd.demos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * 首页
 */
public class MainActivity extends AppCompatActivity {

    private Button swipeRefreshLayout, recycleView;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (Button) findViewById(R.id.btn_swipe_refresh_layout);
        recycleView = (Button) findViewById(R.id.btn_recycle_view);

        swipeRefreshLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, SwipeRefreshLayoutActivity.class);
                startActivity(intent);
            }
        });

        recycleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, RecycleViewActivity.class);
                startActivity(intent);
            }
        });
    }

}
