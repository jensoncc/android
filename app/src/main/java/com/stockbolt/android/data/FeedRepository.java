package com.stockbolt.android.data;

import com.google.gson.reflect.TypeToken;
import com.stockbolt.android.util.GsonUtil;

import java.util.List;

import rx.Observable;


/**
 * Created by Jenson on 10/5/2017.
 */

public class FeedRepository {

    public static final int TYPE_PICTURE_DESC = 1;
    public static final int TYPE_PICTURE_ONLY = 2;

    String feedJson = "[" +
            "{\"title\":\"title1\", \"desc\":\"desc1\", \"thumbnail\":\"image1.png\", \"type\":1},\n" +
            "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
            "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
            "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
            "{\"title\":\"title5\", \"desc\":\"desc5\", \"thumbnail\":\"image1.png\", \"type\":1},\n" +
            "{\"title\":\"title6\", \"desc\":\"desc6\", \"thumbnail\":\"image1.png\", \"type\":1}\n" +
            "]";

    private List<FeedPictureDesc> feedList;

    public FeedRepository() {
        feedList = GsonUtil.getGson().fromJson(feedJson, new TypeToken<List<FeedPictureDesc>>() {
        }.getType());
    }

    public Observable<List<FeedPictureDesc>> getFeed() {
        return Observable.from(feedList.subList(0, 4)).toList();
    }

    public Observable<List<FeedPictureDesc>> getMoreFeed(int lastItemPosition) {
        String feedJson = "[" +
                "{\"title\":\"title10\", \"desc\":\"desc1\", \"thumbnail\":\"image1.png\", \"type\":1},\n" +
                "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
                "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
                "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
                "{\"title\":\"title15\", \"desc\":\"desc5\", \"thumbnail\":\"image1.png\", \"type\":1},\n" +
                "{\"title\":\"title16\", \"desc\":\"desc6\", \"thumbnail\":\"image1.png\", \"type\":1},\n" +
                "{\"title\":\"title20\", \"desc\":\"desc1\", \"thumbnail\":\"image1.png\", \"type\":1},\n" +
                "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
                "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
                "{\"title\":\"\", \"desc\":\"\", \"thumbnail\":\"image1.png\", \"type\":2},\n" +
                "{\"title\":\"title25\", \"desc\":\"desc5\", \"thumbnail\":\"image1.png\", \"type\":1},\n" +
                "{\"title\":\"title26\", \"desc\":\"desc6\", \"thumbnail\":\"image1.png\", \"type\":1}\n" +
                "]";

        List<FeedPictureDesc> feedList2 = GsonUtil.getGson().fromJson(feedJson, new TypeToken<List<FeedPictureDesc>>() {
        }.getType());
        feedList.addAll(feedList2);
        return Observable.from(feedList.subList(lastItemPosition, lastItemPosition+feedList2.size())).toList();
    }

    public List<FeedPictureDesc> getFeedList(){
        return feedList;
    }

}
