package com.maoyingjie.newapps.ui.Activity;

import android.util.Log;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;
import com.maoyingjie.newapps.databinding.ActivityMainBinding;
import com.maoyingjie.newapps.ViewModel.MainViewModel;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {

    @Override
    public ViewModel getViewModel() {
        return new ViewModelProvider(this,new ViewModelFactory()).get(MainViewModel.class);
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
        mViewModel.getmess();
        mViewModel.responseData.observe(this, new Observer<TouTiaoBean>() {
            @Override
            public void onChanged(TouTiaoBean touTiaoBean) {
                Log.d("main",new Gson().toJson(touTiaoBean));
            }
        });
    }
}