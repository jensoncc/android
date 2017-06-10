package com.stockbolt.android.feed;

import com.stockbolt.android.BasePresenter;
import com.stockbolt.android.BaseView;
import com.stockbolt.android.data.FeedPictureDesc;
import java.util.List;

public interface FeedContract {
    interface View extends BaseView<Presenter> {
        void showFeed(List<FeedPictureDesc> feedList);
        void showMoreFeed(int offset, List<FeedPictureDesc> feedList);
    }

    interface Presenter extends BasePresenter {
        void loadFeed();
        void loadMoreFeed(int offset);
    }
}