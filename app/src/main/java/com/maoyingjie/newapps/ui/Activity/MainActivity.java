package com.maoyingjie.newapps.ui.Activity;

import android.content.ContentProvider;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.gson.Gson;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.ViewModel.Factory.ViewModelFactory;
import com.maoyingjie.newapps.databinding.ActivityMainBinding;
import com.maoyingjie.newapps.ViewModel.MainViewModel;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;
import com.maoyingjie.newapps.ui.Adapter.MFragmentStatusAdapter;
import com.maoyingjie.newapps.ui.Fragment.HeadLineFragment;
import com.maoyingjie.newapps.ui.Fragment.ListFragment;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static androidx.viewpager2.widget.ViewPager2.*;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel> {
    private MFragmentStatusAdapter fragmentStatusAdapter;

    @Override
    public ViewModel getViewModel() {
        return new ViewModelProvider(this,
                new ViewModelFactory()).get(MainViewModel.class);
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
    public void initView() {
        initViewPager2();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void initViewPager2() {
        if (fragmentStatusAdapter == null) {
            List<Fragment> fragments = new ArrayList<>();
            fragments.add(new HeadLineFragment());
            fragmentStatusAdapter = new MFragmentStatusAdapter(this, fragments);
        }
        mBing.contentVp.setAdapter(fragmentStatusAdapter);

        mBing.contentVp.registerOnPageChangeCallback(new OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mBing.bottomNavigationNv.getMenu().getItem(position).setCheckable(true);
            }
        });
        mBing.contentVp.setCurrentItem(0);
        mBing.contentVp.setUserInputEnabled(false);

        mBing.bottomNavigationNv.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_mess:
                    mBing.contentVp.setCurrentItem(0);
                    break;
                case R.id.navigation_education:
                    break;
                case R.id.navigation_mine:
                    break;
                case R.id.navigation_topic:
                    break;
                case R.id.navigation_video:
                    break;
            }
            return true;
        });
    }

}