package com.maoyingjie.newapps.ui.Adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.Utils.GlideUtils;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;
import com.maoyingjie.newapps.ui.CustomizeView.MGroupFilletImageView;

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
        BindTextContent(baseViewHolder, listDTO);
        switch (baseViewHolder.getItemViewType()) {
            case 2:
                if (listDTO.imgUrls != null || listDTO.imgUrls.size() > 0)
                    GlideUtils.LoadImageWithDiskCacheStrategy(getContext(),
                            (ImageView) baseViewHolder.itemView.findViewById(R.id.img_group_giv),
                            listDTO.imgUrls.get(0));
                else
                    baseViewHolder.itemView.findViewById(R.id.img_group_giv)
                            .setVisibility(View.GONE);
                break;
            case 3:
                MGroupFilletImageView imageViews = baseViewHolder.
                        itemView.findViewById(R.id.img_group_giv);
                if (listDTO.imgUrls != null && listDTO.imgUrls.size() > 0)
                    imageViews.BingImg(listDTO.imgUrls);
                else
                    imageViews.setVisibility(View.GONE);

                    break;

            case 4:
                if (listDTO.imgUrls != null || listDTO.imgUrls.size() > 0)
                    GlideUtils.LoadImageWithDiskCacheStrategy(getContext(),
                            (ImageView) baseViewHolder.itemView.findViewById(R.id.img_iv),
                            listDTO.imgUrls.get(0));
                else
                    baseViewHolder.itemView.findViewById(R.id.img_iv)
                            .setVisibility(View.GONE);
                break;

            default:
                break;
        }
    }

    public void BindTextContent(BaseViewHolder holder, TouTiaoBean.DocsDTO.ListDTO listDTO) {
        if (listDTO.listTitle != "")
            holder.setText(R.id.first_title_tv, listDTO.listTitle);
        if (listDTO.label != "")
            holder.setText(R.id.litter_title_tv, listDTO.label);
        if (listDTO.pubTime != "")
            holder.setText(R.id.item_time_tv, listDTO.pubTime);
    }
}
