package com.maoyingjie.newapps.Utils;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;

public class ReTryWithDelay implements Function<Observable<Throwable>, ObservableSource<?>>{
    private int retryCount;
    private int retryDelayMillis;
    private int maxRetries;

    public ReTryWithDelay(int maxRetries, int retryDelayMillis) {
        this.maxRetries = maxRetries;
        this.retryDelayMillis = retryDelayMillis;
    }

    @Override
    public ObservableSource<?> apply(@NotNull Observable<Throwable> throwableObservable) throws Exception {
        return throwableObservable.flatMap((Function<Throwable, ObservableSource<?>>) throwable -> {
            if (++retryCount<=maxRetries)
                return Observable.timer(retryDelayMillis,TimeUnit.MILLISECONDS);
            return Observable.error(throwable);
        });
    }
}
