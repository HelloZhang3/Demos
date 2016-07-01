package com.zyd.demos.adapter;

/**
 * Created by zhang on 2016/6/12.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zyd.demos.R;

import java.util.List;

/**
 * RecyclerView适配器
 *
 * @author zhangyadong
 * @time 2016/6/12  18:03
 * email:  zhangyadong@rockmobile.com.cn
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static enum ITEM_TYPE {
        ITEM_TYPE_IMAGE,
        ITEM_TYPE_TEXT
    }

    private Context mContext;
    private List<String> dataList;
    private LayoutInflater mLayoutInflater;

    public MyAdapter(Context context, List<String> list) {
        this.mContext = context;
        this.dataList = list;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = View.inflate(parent.getContext(), R.layout.recycler_view_item, null);
//        ViewHolder holder = new ViewHolder(view);
//        return holder;
        if (viewType == ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal()) {
            return new ViewHolder(mLayoutInflater.inflate(R.layout.recycler_view_item, null));
        } else {
            return new ViewHolderImage(mLayoutInflater.inflate(R.layout.recycler_view_item2, null));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        holder.content.setText(dataList.get(position));
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).content.setText(dataList.get(position));
        } else if (holder instanceof ViewHolderImage) {
//            ((ViewHolder)holder).imageView.setBack
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? ITEM_TYPE.ITEM_TYPE_IMAGE.ordinal() : ITEM_TYPE.ITEM_TYPE_TEXT.ordinal();
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView content;

        public ViewHolder(final View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            content = (TextView) itemView.findViewById(R.id.tv);
        }
    }

    public class ViewHolderImage extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public ViewHolderImage(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "点击了" + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });

            imageView = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

}
