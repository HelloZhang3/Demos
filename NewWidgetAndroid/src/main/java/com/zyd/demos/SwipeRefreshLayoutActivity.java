package com.zyd.demos;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * SwipeRefreshLayoutActivity
 */
public class SwipeRefreshLayoutActivity extends AppCompatActivity {

    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ListView mListView;
    private List<String> data;
    private ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_refresh_layout);
        initView();

        //设置刷新小球颜色
        mSwipeRefreshLayout.setColorSchemeColors(
                getResources().getColor(R.color.colorGreen),
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.colorPrimary));

        //刷新监听
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //模拟耗时
                new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                    }

                    @Override
                    public void onFinish() {
                        //停止刷新状态
                        if (mSwipeRefreshLayout.isRefreshing()) {
                            mSwipeRefreshLayout.setRefreshing(false);
                        }
                    }
                }.start();
            }
        });


        data = new ArrayList<>();
        initData(data);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        mListView.setAdapter(arrayAdapter);


    }

    private void initData(List<String> data) {
        for (int i = 0; i < 20; i++) {
            data.add("数据" + i);
        }
    }

    private void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swp_layout);
        mListView = (ListView) findViewById(R.id.lv);
    }
}
