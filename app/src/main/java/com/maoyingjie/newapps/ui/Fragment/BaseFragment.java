package com.maoyingjie.newapps.ui.Fragment;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.maoyingjie.newapps.ViewModel.BaseViewModel;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment<T extends ViewDataBinding, Y extends BaseViewModel> extends Fragment {
    protected T mBing;
    protected Y mViewModel;
    private boolean isLoaded = false;
    private PopupWindow popupWindow;
    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater,
                             @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                             @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        mBing = DataBindingUtil.inflate(inflater, bingLayout(), container, true);
        if (mViewModel == null)
            mViewModel = (Y) getViewModel();
        return mBing.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (!isLoaded) {
            initData();
            isLoaded = true;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isLoaded = false;
    }

    protected void showLoading(int layoutId){
        LayoutInflater inflater  = LayoutInflater.from(getContext());
        View view = inflater.inflate(layoutId,null);
        popupWindow = new PopupWindow(getContext());
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        popupWindow.setWidth(mBing.getRoot().getWidth());
        popupWindow.setHeight(mBing.getRoot().getHeight());
        popupWindow.setContentView(view);
        popupWindow.showAtLocation(mBing.getRoot(),
                Gravity.CENTER_HORIZONTAL|Gravity.CENTER_VERTICAL,0,0);
    }

    protected void hideLoading(){
         if (popupWindow!=null)
             popupWindow.dismiss();
    }
    public abstract void initData();

    public abstract ViewModel getViewModel();

    public abstract int bingLayout();

    public abstract void initView();
}
