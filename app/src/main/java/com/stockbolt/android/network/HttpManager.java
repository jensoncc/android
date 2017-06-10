package com.stockbolt.android.network;

import android.util.LruCache;
import rx.Observable;

public class HttpManager {

    public static HttpServiceRest service;
    private LruCache<Class<?>, Observable<?>> apiObservables = new LruCache<>(10);


    public Observable<?> getPreparedObservable(Observable<?> unPreparedObservable, Class<?> clazz, boolean cacheObservable, boolean useCache) {
        Observable<?> preparedObservable = null;

        if (useCache) //this way we don't reset anything in the cache if this is the only instance of us not wanting to use it.
            preparedObservable = apiObservables.get(clazz);

        if (preparedObservable != null)
            return preparedObservable;

        //we are here because we have never created this observable before or we didn't want to use the cache...
        preparedObservable = unPreparedObservable;

        if (cacheObservable) {
            preparedObservable = preparedObservable.cache();
            apiObservables.put(clazz, preparedObservable);
        }

        return preparedObservable;
    }
}
