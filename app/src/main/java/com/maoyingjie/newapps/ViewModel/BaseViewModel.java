package com.maoyingjie.newapps.ViewModel;

import androidx.lifecycle.ViewModel;

import com.maoyingjie.newapps.Utils.BindLife;

public abstract class BaseViewModel extends ViewModel implements BindLife {

    @Override
    public void bindlife() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
