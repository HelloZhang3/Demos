package com.example.administrator.demos;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv);
        mListView.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
        mListView.setStackFromBottom(true);
        btn = (Button) findViewById(R.id.btn);


        final MyAdapter adapter = new MyAdapter(this);
        mListView.setAdapter(adapter);

        final List<String> list = new ArrayList<>();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adapter.addDate("sss");
            }
        });
    }


    class MyAdapter extends BaseAdapter {

        private List<String> dataList = new ArrayList<>();
        private Context mContext;
        private LayoutInflater mInflater;

        public MyAdapter(Context context) {
            this.mContext = context;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return getItem(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_layout, null);
                holder.content = (TextView) convertView.findViewById(R.id.tv);
                convertView.setTag(holder);
            } else {
                convertView.getTag();
            }

//            holder.content.setText(dataList.get(position));

            return convertView;
        }

        class ViewHolder {
            TextView content;
        }


        /**
         * 初始化数据
         *
         * @param dataList
         */
        public void initDate(List<String> dataList) {
            this.dataList = dataList;
            notifyDataSetChanged();
        }

        public void addDate(String str) {
            dataList.add(str);
            notifyDataSetChanged();
        }
    }
}
