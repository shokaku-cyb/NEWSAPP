package com.maoyingjie.newapps.ViewModel;

import android.net.ConnectivityManager;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.maoyingjie.newapps.Utils.NetWorkStateUtil;
import com.maoyingjie.newapps.Utils.ReTryWithDelay;
import com.maoyingjie.newapps.model.NetWorkManager.ApiService;
import com.maoyingjie.newapps.model.NetWorkManager.Http.HttpManager;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;
import com.maoyingjie.newapps.ui.ViewState.State;
import com.maoyingjie.newapps.ui.ViewState.StatefulData;

import org.jetbrains.annotations.NotNull;
import org.reactivestreams.Publisher;

import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.SingleSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.processors.PublishProcessor;
import io.reactivex.schedulers.Schedulers;

public class ListFragmentViewModel extends BaseViewModel {

    private HttpManager manager = HttpManager.getInstance();
    private ApiService apiService = manager.apiService;
    public MutableLiveData<StatefulData<TouTiaoBean>> responseData = new MutableLiveData();
    public MutableLiveData<Boolean>isNetWorkAvailable = new MutableLiveData<>();
    public MutableLiveData<Boolean>isLoading = new MutableLiveData<>();


    public void getData() {
        Single.
                fromCallable(() -> {
                    isLoading.postValue(true);
                    return NetWorkStateUtil.isNetWorking();
                })
                .flatMap((Function<Boolean, SingleSource<TouTiaoBean>>) aBoolean -> {
                    return apiService.getHeadline();
                })
                .toObservable()
                .retryWhen(new ReTryWithDelay(3, 3000))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(throwable -> {
                    Log.d("network", throwable.getMessage());
                })
                .subscribe(data -> {
                    isLoading.setValue(false);
                    if (data != null) {
                        responseData.setValue(new StatefulData<>(data, State.Success));
                    }
                    else
                        responseData.setValue(new StatefulData<>(data, State.Error));
                }, e -> {
                    e.printStackTrace();
                });
    }
}
