package com.maoyingjie.newapps.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.drakeet.multitype.ItemViewBinder;
import com.drakeet.multitype.ItemViewDelegate;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.Utils.GlideUtils;
import com.maoyingjie.newapps.databinding.SmallViewholderLayoutBinding;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import org.jetbrains.annotations.NotNull;

import static java.security.AccessController.getContext;

public class ImageItemProvider extends ItemViewBinder<TouTiaoBean.DocsDTO.ListDTO
        , ImageItemProvider.ViewHolder> {

    private TouTiaoBean.DocsDTO.ListDTO listDTO;

    @Override
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, TouTiaoBean.DocsDTO.ListDTO listDTO) {
        if (listDTO != null)
            viewHolder.bind(listDTO);
    }


    @Override
    public @NotNull ImageItemProvider.ViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        SmallViewholderLayoutBinding mBing = DataBindingUtil.inflate(layoutInflater,
                R.layout.small_viewholder_layout, viewGroup, false);
        return new ViewHolder(mBing);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private SmallViewholderLayoutBinding mBing;

        public ViewHolder(SmallViewholderLayoutBinding mBing) {
            super(mBing.getRoot());
            this.mBing = mBing;
        }

        public void bind(TouTiaoBean.DocsDTO.ListDTO listDTO) {
            if (listDTO.listTitle != "")
                mBing.firstTitleTv.setText(listDTO.listTitle);
            if (listDTO.label != "")
                mBing.litterTitleTv.setText(listDTO.label);
            if (listDTO.pubTime != "")
                mBing.itemTimeTv.setText(listDTO.pubTime);
            if (listDTO.imgUrls != null || listDTO.imgUrls.size() > 0)
                GlideUtils.LoadImageWithDiskCacheStrategy(mBing.imgIv, listDTO.imgUrls.get(0));
            else
                mBing.imgIv.setVisibility(View.GONE);
        }
    }
}
