package com.maoyingjie.newapps.ui.Fragment;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;
import com.maoyingjie.newapps.ViewModel.ListFragmentViewModel;
import com.maoyingjie.newapps.databinding.FragmentListBinding;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;
import com.maoyingjie.newapps.ui.Adapter.MultipleItemQuickAdapter;

import java.util.ArrayList;

public class ListFragment extends BaseFragment<FragmentListBinding, ListFragmentViewModel> {
    private MultipleItemQuickAdapter quickAdapter;

    @Override
    public void initData() {
        mViewModel.getmess();
        mViewModel.responseData.observe(this, new Observer<TouTiaoBean>() {
            @Override
            public void onChanged(TouTiaoBean touTiaoBean) {
                if (quickAdapter == null) {
                    quickAdapter = new MultipleItemQuickAdapter(touTiaoBean);
                    mBing.contentRv.setAdapter(quickAdapter);
                }else{

                }
            }
        });
    }

    @Override
    public void init() {

    }

    @Override
    public ViewModel getViewModel() {
        return new ViewModelProvider(getActivity()
                , new ViewModelFactory()).get(ListFragmentViewModel.class);
    }

    @Override
    public int bingLayout() {
        return R.layout.fragment_list;
    }

    @Override
    public void initView() {
        mBing.contentRv.setLayoutManager(new LinearLayoutManager(getContext()));
    }
}
