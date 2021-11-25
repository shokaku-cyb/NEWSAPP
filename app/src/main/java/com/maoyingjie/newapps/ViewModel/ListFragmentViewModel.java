package com.maoyingjie.newapps.ViewModel;

import androidx.lifecycle.MutableLiveData;

import com.maoyingjie.newapps.model.NetWorkManager.ApiService;
import com.maoyingjie.newapps.model.NetWorkManager.Http.HttpManager;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ListFragmentViewModel extends BaseViewModel {
    private HttpManager manager = HttpManager.getInstance();
    private ApiService apiService = manager.apiService;

    public MutableLiveData<TouTiaoBean> responseData = new MutableLiveData();

    public void getData() {
        Disposable disposable = apiService.getHeadline()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(touTiaoBean -> responseData.setValue(touTiaoBean))
                .doOnError(throwable -> {

                })
                .subscribe((touTiaoBean, throwable) -> {

                });
        compositeDisposable.add(disposable);
    }
}
