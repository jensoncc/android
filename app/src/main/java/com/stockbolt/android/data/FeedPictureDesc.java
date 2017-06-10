package com.stockbolt.android.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jenson on 11/5/2017.
 */

public class FeedPictureDesc {

    @SerializedName("title")
    private String title;
    @SerializedName("desc")
    private String desc;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("type")
    private int type;


    public FeedPictureDesc(String title, String thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
