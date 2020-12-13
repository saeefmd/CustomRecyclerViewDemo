package com.saeefmd.juproject.customrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;

    private Context mContext;
    private HeaderModel mHeaderModel;
    private ListModel mListModel;

    public MyRecyclerAdapter (Context context, HeaderModel headerModel, ListModel listModel) {
        this.mContext = context;
        this.mHeaderModel = headerModel;
        this.mListModel = listModel;
    }

    public boolean isHeader(int position) {
        return position == 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_ITEM) {
            // Here Inflating your recyclerview item layout
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_view, parent, false);
            return new ItemViewHolder(itemView);
        } else if (viewType == TYPE_HEADER) {
            // Here Inflating your header view
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_header_view, parent, false);
            return new HeaderViewHolder(itemView);
        }
        else return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof HeaderViewHolder){

            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;

            headerViewHolder.titleTv.setText(mHeaderModel.getTitle());
            headerViewHolder.descTv.setText(mHeaderModel.getDesc());
            headerViewHolder.sourceTv.setText(mHeaderModel.getSource());

        }
        else if (holder instanceof ItemViewHolder){

            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            int imgUrl = mListModel.getImageUrls().get(position-1);

            itemViewHolder.wallpaperIv.setText(String.valueOf(imgUrl));

            //Glide.with(mContext).asDrawable().load(imgUrl).into(itemViewHolder.wallpaperIv);
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }


    // getItemCount increasing the position to 1. This will be the row of header
    @Override
    public int getItemCount() {
        return (mListModel.getImageUrls().size() + 1);
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        TextView descTv;
        TextView sourceTv;
        public HeaderViewHolder(View view) {
            super(view);

            titleTv = view.findViewById(R.id.title_tv);
            descTv = view.findViewById(R.id.description_tv);
            sourceTv = view.findViewById(R.id.source_tv);
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView wallpaperIv;
        public ItemViewHolder(View itemView) {
            super(itemView);

            wallpaperIv = itemView.findViewById(R.id.wallpaper_iv);
        }
    }
}
