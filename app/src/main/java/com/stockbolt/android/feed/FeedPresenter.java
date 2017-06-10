package com.stockbolt.android.feed;

import android.support.annotation.NonNull;

import com.stockbolt.android.data.FeedPictureDesc;
import com.stockbolt.android.data.FeedRepository;

import java.util.List;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;


/**
 * Created by Jenson on 10/5/2017.
 */

public class FeedPresenter implements FeedContract.Presenter {

    @NonNull
    private final FeedContract.View mMainView;

    @NonNull
    private final FeedRepository feedRepository;

    public FeedPresenter(@NonNull FeedContract.View mMainView, @NonNull FeedRepository feedRepository) {
        this.mMainView = mMainView;
        this.feedRepository = feedRepository;
    }

    @Override
    public void subscribe() {
        loadFeed();
    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void loadFeed() {
        Observable<List<FeedPictureDesc>> listObservable = feedRepository.getFeed();
        listObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<FeedPictureDesc>>() {
                    @Override
                    public void call(List<FeedPictureDesc> iFeeds) {
                        mMainView.showFeed(iFeeds);
                    }
                });
    }

    @Override
    public void loadMoreFeed(int offset) {
        Observable<List<FeedPictureDesc>> listObservable = feedRepository.getMoreFeed(offset);
        listObservable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<FeedPictureDesc>>() {
                    @Override
                    public void call(List<FeedPictureDesc> iFeeds) {
                        mMainView.showMoreFeed(offset, iFeeds);
                    }
                });
    }
}