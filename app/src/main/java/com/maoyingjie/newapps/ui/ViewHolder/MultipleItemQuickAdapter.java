package com.maoyingjie.newapps.ui.ViewHolder;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;
import com.maoyingjie.newapps.ui.Activity.BaseActivity;

import org.jetbrains.annotations.NotNull;

public class MultipleItemQuickAdapter extends
        BaseMultiItemQuickAdapter<TouTiaoBean.DocsDTO.ListDTO, BaseViewHolder> {

    public MultipleItemQuickAdapter(TouTiaoBean data) {
        addItemType(1, R.layout.large_imageview_layout);
        addItemType(2, R.layout.large_imageview_layout);
        addItemType(3, R.layout.large_imageview_layout);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder,
                           TouTiaoBean.DocsDTO.ListDTO listDTO) {
        switch (baseViewHolder.getItemViewType()) {
            case 1:

                break;
            case 2:

                break;

            case 3:
                break;
        }
    }
}
