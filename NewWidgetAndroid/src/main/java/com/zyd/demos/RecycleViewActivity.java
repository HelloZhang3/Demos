package com.zyd.demos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;

import com.zyd.demos.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * recycleView
 *
 * @author zhangyadong
 * @time 2016/5/13  9:37
 * email:  zhangyadong@rockmobile.com.cn
 */
public class RecycleViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> dataList = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        /**
         * 三种LayoutManager
         */
        //横向
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //网格
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);

        //瀑布流
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, GridLayoutManager.VERTICAL);

        //设置Manager
        mRecyclerView.setLayoutManager(linearLayoutManager);
//        mRecyclerView.setLayoutManager(gridLayoutManager);
//        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);


        initData();

        //设置适配
        adapter = new MyAdapter(this, dataList);
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * init data
     */
    private void initData() {
        for (int i = 0; i < 20; i++) {
            dataList.add("原始数据" + i);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, 1, 1, "add");
        menu.add(Menu.NONE, 2, 2, "delete");
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 1) {
            dataList.add(1, "新加的");
            adapter.notifyItemInserted(1);
//            mRecyclerView.smoothScrollToPosition(0);//定位到首项
        } else {
            dataList.remove(1);
            adapter.notifyItemRemoved(1);
        }
        return super.onOptionsItemSelected(item);
    }
}
