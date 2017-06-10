package com.stockbolt.android.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.stockbolt.android.R;
import com.stockbolt.android.data.FeedPictureDesc;
import com.stockbolt.android.data.FeedRepository;

import java.util.List;

/**
 * Created by Jenson on 10/5/2017.
 */

public class FeedRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final String TAG = "FeedRecyclerViewAdapter";
    private List<FeedPictureDesc> feedList;

    public FeedRecyclerViewAdapter(List<FeedPictureDesc> feedList) {
        this.feedList = feedList;
    }

    /**
     * View holder class
     */

    public class FeedPictureDescViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desc;
        public ImageView thumbnail;

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }

        public TextView getDesc() {
            return desc;
        }

        public void setDesc(TextView desc) {
            this.desc = desc;
        }

        public ImageView getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(ImageView thumbnail) {
            this.thumbnail = thumbnail;
        }

        public FeedPictureDescViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            desc = (TextView) view.findViewById(R.id.desc);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }
    }

    public class FeedPictureViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumbnail;

        public FeedPictureViewHolder(View view) {
            super(view);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
        }

        public ImageView getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(ImageView thumbnail) {
            this.thumbnail = thumbnail;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "position:" + position + "getItemViewType: " + feedList.get(position).getType());
        return feedList.get(position).getType();
    }

    @Override
    public int getItemCount() {
        return feedList.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case FeedRepository.TYPE_PICTURE_ONLY:
                View viewPic = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.rv_feed_picture_only, parent, false);
                return new FeedPictureViewHolder(viewPic);
            case FeedRepository.TYPE_PICTURE_DESC:
                View viewPicDesc = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.rv_feed_picture_desc, parent, false);
                return new FeedPictureDescViewHolder(viewPicDesc);
        }
        return null;
    }

    public List<FeedPictureDesc> getFeedList() {
        return feedList;
    }

    public void setFeedList(List<FeedPictureDesc> feedList) {
        this.feedList = feedList;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedPictureDesc feed = feedList.get(position);

        if (holder.getItemViewType() == FeedRepository.TYPE_PICTURE_ONLY) {
            ((FeedPictureViewHolder) holder).thumbnail.setImageResource(R.drawable.placeholder);
        } else if (holder.getItemViewType() == FeedRepository.TYPE_PICTURE_DESC) {
            ((FeedPictureDescViewHolder) holder).thumbnail.setImageResource(R.drawable.placeholder);
            ((FeedPictureDescViewHolder) holder).title.setText(((FeedPictureDesc) feed).getTitle());
            ((FeedPictureDescViewHolder) holder).desc.setText(((FeedPictureDesc) feed).getDesc());
        }
    }
}