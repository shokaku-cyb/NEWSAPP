package com.maoyingjie.newapps.ui.Activity;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;

import com.maoyingjie.newapps.Utils.StatusBarUtils;
import com.maoyingjie.newapps.ViewModel.BaseViewModel;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;
import com.maoyingjie.newapps.ViewModel.MainViewModel;

public abstract class BaseActivity<T extends ViewDataBinding,
        Y extends ViewModel> extends AppCompatActivity implements ViewModelStoreOwner {
    protected T mBing;
    protected Y mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mBing == null)
            mBing = (T) DataBindingUtil.setContentView(this, bingLayout());
        if (mViewModel == null)
            this.mViewModel = (Y) getViewModel();
        initData();
        setStatusBar();
    }

    @Override
    protected void onStart() {
        super.onStart();
        initAnimation();
    }

    private void setStatusBar(){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.KITKAT)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        mBing.getRoot().setPadding(0,
                StatusBarUtils.getStatusBarHeight(this),0,0);

    }
    public abstract ViewModel getViewModel();

    public abstract void initData();

    public abstract int bingLayout();

    public abstract void initAnimation();
}