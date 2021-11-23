package com.maoyingjie.newapps.ui.Fragment;

import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.databinding.FragmentListBinding;
import com.maoyingjie.newapps.ViewModel.RecyclerViewFragmentViewModel;

public class RecyclerViewFragment extends BaseFragment<FragmentListBinding,
        RecyclerViewFragmentViewModel>{

    @Override
    public int bingLayout() {

        return R.layout.fragment_list;
    }
}
