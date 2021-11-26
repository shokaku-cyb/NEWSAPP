package com.maoyingjie.newapps.ui.Fragment;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.drakeet.multitype.MultiTypeAdapter;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;
import com.maoyingjie.newapps.ViewModel.ListFragmentViewModel;
import com.maoyingjie.newapps.databinding.FragmentContentlistBinding;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean.DocsDTO.ListDTO;
import com.maoyingjie.newapps.ui.Adapter.ImageItemProvider;
import com.maoyingjie.newapps.ui.Adapter.LargeImageItemProvider;
import com.maoyingjie.newapps.ui.Adapter.MiddleImageItemProvider;
import com.maoyingjie.newapps.ui.ViewState.StatefulData;

import java.util.concurrent.TimeUnit;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class ListFragment extends BaseFragment<FragmentContentlistBinding, ListFragmentViewModel>
        implements SwipeRefreshLayout.OnRefreshListener {
    private MultiTypeAdapter adapter;

    @Override
    public void initData() {
        mViewModel.getData();
        mViewModel.responseData.observe(this, data -> {
            switch (data.state) {
                case Error:

                    break;
                case Success:
                    if (adapter == null) {
                        createAdapter();
                        adapter.setItems(data.data.docs.list);
                    }
                    mBing.contentRv.setAdapter(adapter);
                    break;
            }
        });
    }

    @Override
    public ViewModel getViewModel() {
        return new ViewModelProvider(getActivity()
                , new ViewModelFactory()).get(ListFragmentViewModel.class);
    }

    @Override
    public int bingLayout() {
        return R.layout.fragment_contentlist;
    }

    @Override
    public void initView() {
        mBing.contentRv.setLayoutManager(new LinearLayoutManager(getContext()));
        mBing.refreshSrl.setOnRefreshListener(this);
        mBing.checkNetworkCl.setOnClickListener(view -> mViewModel.getData());
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.isLoading.observe(this, aBoolean -> {
            if (aBoolean)
                showLoading(R.layout.loading_layout);
            else
                hideLoading();
        });

        mViewModel.isNetWorkAvailable.observe(this, aBoolean -> {
            if (aBoolean)
                mBing.checkNetworkCl.setVisibility(View.VISIBLE);
            else mBing.checkNetworkCl.setVisibility(View.GONE);
        });
    }

    @Override
    public void onRefresh() {
        mViewModel.getData();
        mViewModel.responseData.observe(this, touTiaoBean ->
                Single.timer(3000, TimeUnit.MILLISECONDS)
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnSubscribe(disposable -> mBing.refreshSrl.setRefreshing(false))
                        .subscribe()
                        .dispose());
    }

    private void createAdapter() {
        adapter = new MultiTypeAdapter();
        adapter.register(ListDTO.class)
                .to(new ImageItemProvider(),
                        new MiddleImageItemProvider(),
                        new LargeImageItemProvider())
                .withJavaClassLinker((i, listDTO) -> {
                    switch (listDTO.listStyle) {
                        case "2":
                            return LargeImageItemProvider.class;
                        case "3":
                            return MiddleImageItemProvider.class;
                        case "4":
                            return ImageItemProvider.class;
                        default:
                            return null;
                    }
                });
    }
}
