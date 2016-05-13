package com.zyd.demos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
//        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setLayoutManager(linearLayoutManager);
//        mRecyclerView.setLayoutManager(staggeredGridLayoutManager);

        initData();

        //设置适配
        adapter = new MyAdapter();
        mRecyclerView.setAdapter(adapter);
    }

    /**
     * init data
     */
    private void initData() {
        for (int i = 0; i < 100; i++) {
            dataList.add(i + "data :" + "原始数据" + i);
        }

    }

    /**
     * 适配器
     */
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = View.inflate(parent.getContext(), R.layout.recycler_view_item, null);
            ViewHolder holder = new ViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.content.setText(dataList.get(position));
        }


        @Override
        public int getItemCount() {
            return dataList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            private TextView content;

            public ViewHolder(View itemView) {
                super(itemView);
                content = (TextView) ((LinearLayout) itemView).getChildAt(0);
            }
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
            dataList.add(1, "大大的盛大的大声道");
            adapter.notifyItemInserted(1);
        } else {
            dataList.remove(2);
            adapter.notifyItemRemoved(2);
        }
        return super.onOptionsItemSelected(item);
    }
}
