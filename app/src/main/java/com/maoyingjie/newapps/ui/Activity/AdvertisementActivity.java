package com.maoyingjie.newapps.ui.Activity;

import android.content.Intent;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.ViewModel.AdvertisementViewModel;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;
import com.maoyingjie.newapps.databinding.ActivityAdvertisementBinding;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class AdvertisementActivity extends BaseActivity<ActivityAdvertisementBinding,
        AdvertisementViewModel> {
    private int count =3 ;
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
        return R.layout.activity_advertisement;
    }


    @Override
    public void initAnimation() {

    }

    @Override
    public void initView() {

    }

    @Override
    protected void onResume() {
        super.onResume();
        Disposable disposable = Observable.intervalRange(0,4,0,1,
                TimeUnit.SECONDS)
               .observeOn(AndroidSchedulers.mainThread())
               .map(aLong -> count-aLong)
               .doOnNext(aLong -> mBing.timeShowerTv.setText(aLong.toString()+"秒"))
               .doOnComplete(() -> {
                   startActivity(new Intent(AdvertisementActivity.
                           this,MainActivity.class));
                   AdvertisementActivity.this.finish();
               })
               .subscribe();
        compositeDisposable.add(disposable);
    }
}