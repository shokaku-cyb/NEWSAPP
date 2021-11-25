package com.maoyingjie.newapps.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.drakeet.multitype.ItemViewDelegate;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.Utils.GlideUtils;
import com.maoyingjie.newapps.databinding.LargeImageviewLayoutBinding;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import org.jetbrains.annotations.NotNull;

public class LargeImageItemProvider extends ItemViewBinder<TouTiaoBean.DocsDTO.ListDTO,
        LargeImageItemProvider.ViewHolder> {

    @Override
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, TouTiaoBean.DocsDTO.ListDTO listDTO) {
        if (listDTO != null)
            viewHolder.bind(listDTO);
    }

    @Override
    public @NotNull LargeImageItemProvider.ViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        LargeImageviewLayoutBinding mBing = DataBindingUtil.inflate(layoutInflater,
                R.layout.large_imageview_layout, viewGroup, false);
        return new ViewHolder(mBing);
    }

    protected class ViewHolder extends RecyclerView.ViewHolder {
        private LargeImageviewLayoutBinding mBing;

        public ViewHolder(LargeImageviewLayoutBinding mBing) {
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
                GlideUtils.LoadImageWithDiskCacheStrategy(mBing.imgGiv, listDTO.imgUrls.get(0));
            else
                mBing.imgGiv.setVisibility(View.GONE);
        }
    }
}
