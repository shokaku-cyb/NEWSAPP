package com.maoyingjie.newapps.ui.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.databinding.FragmentHeadLineBinding;
import com.maoyingjie.newapps.ViewModel.HeadLineFragmentViewModel;
import com.maoyingjie.newapps.ui.Adapter.MFragmentStatusAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static com.google.android.material.tabs.TabLayout.*;

public class HeadLineFragment extends BaseFragment<FragmentHeadLineBinding,
        HeadLineFragmentViewModel> {
    public String[] title = new String[]{"头条", "要闻", "评论", "基教", "高教", "职教"};
    private MFragmentStatusAdapter fragmentStatusAdapter;

    @Override
    public void initData() {

    }

    @Override
    public ViewModel getViewModel() {
        return null;
    }

    @Override
    public int bingLayout() {

        return R.layout.fragment_head_line;
    }

    @Override
    public void initView() {

        initViewPager2();
    }

    private void initViewPager2() {
        if (fragmentStatusAdapter == null) {
            List<Fragment> fragments = new ArrayList<>();
            fragments.add(new ListFragment());
            fragments.add(new ListFragment());
            fragments.add(new ListFragment());
            fragments.add(new ListFragment());
            fragmentStatusAdapter = new MFragmentStatusAdapter(getActivity(), fragments);
        }
        mBing.contentVp.setAdapter(fragmentStatusAdapter);


        new TabLayoutMediator(mBing.tabNavigationTl, mBing.contentVp, (tab, position) -> {
            TextView textView = (TextView) getTabView(position);
            textView.setText(title[position]);
            if (position == 0)
                textView.setTextAppearance(getContext(), R.style.TabLayoutTextSelected);
            tab.setCustomView(textView);
        }).attach();

        mBing.tabNavigationTl.addOnTabSelectedListener(new OnTabSelectedListener() {
            @Override
            public void onTabSelected(Tab tab) {
                if (tab.getCustomView() == null)
                    tab.setCustomView(R.layout.tab_text_layout);
                TextView textView = tab.getCustomView().findViewById(R.id.text1);
                textView.setTextAppearance(getContext(), R.style.TabLayoutTextSelected);
            }

            @Override
            public void onTabUnselected(Tab tab) {
                if (tab.getCustomView() == null)
                    tab.setCustomView(R.layout.tab_text_layout);
                TextView textView = tab.getCustomView().findViewById(R.id.text1);
                textView.setTextAppearance(getContext(), R.style.TabLayoutTextUnSelected);
            }

            @Override
            public void onTabReselected(Tab tab) {

            }
        });
    }

    private View getTabView(int currentPosition) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.tab_text_layout, null);
        TextView textView = (TextView) view.findViewById(R.id.text1);
        textView.setText(title[currentPosition]);
        return view;
    }
}
