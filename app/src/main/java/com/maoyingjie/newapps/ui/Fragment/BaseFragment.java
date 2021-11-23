package com.maoyingjie.newapps.ui.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import com.maoyingjie.newapps.ViewModel.BaseViewModel;

public abstract class BaseFragment<T extends ViewDataBinding, Y extends BaseViewModel> extends Fragment {
    protected T mBing;
    protected Y mViewModel;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        mBing = DataBindingUtil.inflate(inflater,bingLayout(),container,true);
        return mBing.getRoot();
    }

    public abstract int bingLayout();
}
