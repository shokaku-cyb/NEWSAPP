package com.maoyingjie.newapps.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.maoyingjie.newapps.model.NetWorkManager.ApiService;
import com.maoyingjie.newapps.model.NetWorkManager.Http.HttpManager;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends BaseViewModel {
    private HttpManager manager = HttpManager.getInstance();
    private ApiService apiService = manager.apiService;

    public MutableLiveData<TouTiaoBean> responseData = new MutableLiveData();

    public void getmess() {
        apiService.getHeadline()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(new Consumer<TouTiaoBean>() {
                    @Override
                    public void accept(TouTiaoBean touTiaoBean) throws Exception {
                        responseData.setValue(touTiaoBean);
                    }
                })
                .doOnError(new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                })
                .subscribe();
    }
}
