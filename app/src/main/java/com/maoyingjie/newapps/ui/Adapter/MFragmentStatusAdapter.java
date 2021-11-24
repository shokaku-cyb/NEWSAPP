package com.maoyingjie.newapps.ui.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MFragmentStatusAdapter extends FragmentStateAdapter {
    private List<Fragment>fragmentList;

    public MFragmentStatusAdapter(@NonNull @NotNull FragmentActivity fragmentActivity,
                                  List<Fragment>fragmentList) {
        super(fragmentActivity);
        this.fragmentList = fragmentList;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentList.size();
    }
}
