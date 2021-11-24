package com.maoyingjie.newapps.ui.Adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import org.jetbrains.annotations.NotNull;

public class MultipleItemQuickAdapter extends
        BaseMultiItemQuickAdapter<TouTiaoBean.DocsDTO.ListDTO, BaseViewHolder> {

    public MultipleItemQuickAdapter(TouTiaoBean data) {
        super(data.docs.list);
        addItemType(2, R.layout.large_imageview_layout);
        addItemType(3, R.layout.middle_viewholder_layout);
        addItemType(4, R.layout.small_viewholder_layout);
    }


    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder,
                           TouTiaoBean.DocsDTO.ListDTO listDTO) {
        switch (baseViewHolder.getItemViewType()) {
            case 2:
                baseViewHolder.setText(R.id.first_title_tv,listDTO.listTitle);
                baseViewHolder.setText(R.id.litter_title_tv,listDTO.label);
                Glide
                        .with(getContext())
                        .asBitmap()
                        .load(listDTO.imgUrls.get(0))
                        .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                        .into((ImageView) baseViewHolder.itemView.findViewById(R.id.img_group_giv));
                break;
            case 3:

                break;

            case 4:
                break;

            default:
                break;
        }
    }
}
