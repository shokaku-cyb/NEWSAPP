package com.maoyingjie.newapps.ui.Activity;

import android.content.Intent;
import android.util.Log;
import android.util.TimeUtils;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.ViewModel.AdvertisementViewModel;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;
import com.maoyingjie.newapps.databinding.ActivityAdvertisementBinding;
import com.maoyingjie.newapps.databinding.ActivityMainBinding;
import com.maoyingjie.newapps.ViewModel.MainViewModel;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class AdvertisementActivity extends BaseActivity<ActivityAdvertisementBinding,
        AdvertisementViewModel> {

    @Override
    public ViewModel getViewModel() {
        return new ViewModelProvider(this,
                new ViewModelFactory()).get(AdvertisementViewModel.class);
    }

    @Override
    public void initData() {
    }

    @Override
    public int bingLayout() {
        return R.layout.activity_main;
    }


    @Override
    public void initAnimation() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Observable.interval(1, TimeUnit.SECONDS)
                .takeUntil(it -> it == 3)
                .doOnNext(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        Long leftTime = 3 - aLong;
                        mBing.timeShowerTv.setText(leftTime.toString() + "秒");
                    }
                })
                .doFinally(new Action() {
                    @Override
                    public void run() throws Exception {
                        startActivity(new Intent(AdvertisementActivity.this,
                                MainActivity.class));
                        AdvertisementActivity.this.finish();
                    }
                })
                .subscribe();

    }
}