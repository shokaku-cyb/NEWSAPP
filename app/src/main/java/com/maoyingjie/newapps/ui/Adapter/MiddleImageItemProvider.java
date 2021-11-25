package com.maoyingjie.newapps.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.drakeet.multitype.ItemViewBinder;
import com.drakeet.multitype.ItemViewDelegate;
import com.maoyingjie.newapps.DataBinderMapperImpl;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.Utils.GlideUtils;
import com.maoyingjie.newapps.databinding.LargeImageviewLayoutBinding;
import com.maoyingjie.newapps.databinding.MiddleViewholderLayoutBinding;
import com.maoyingjie.newapps.model.NetWorkManager.bean.TouTiaoBean;

import org.jetbrains.annotations.NotNull;

public class MiddleImageItemProvider extends ItemViewBinder<TouTiaoBean.DocsDTO.ListDTO
        , MiddleImageItemProvider.ViewHolder> {

    @Override
    public void onBindViewHolder(MiddleImageItemProvider.@NotNull ViewHolder viewHolder,
                                 TouTiaoBean.DocsDTO.ListDTO listDTO) {
        if (listDTO != null)
            viewHolder.bind(listDTO);
    }

    @Override
    public @NotNull MiddleImageItemProvider.ViewHolder onCreateViewHolder(@NotNull LayoutInflater layoutInflater, @NotNull ViewGroup viewGroup) {
        MiddleViewholderLayoutBinding mBing = DataBindingUtil.inflate(layoutInflater,
                R.layout.middle_viewholder_layout, viewGroup, false);
        return new ViewHolder(mBing);
    }


    protected class ViewHolder extends RecyclerView.ViewHolder {
        private MiddleViewholderLayoutBinding mBing;

        public ViewHolder(MiddleViewholderLayoutBinding mBing) {
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
                mBing.imgGroupGiv.BingImg(listDTO.imgUrls);
            else
                mBing.imgGroupGiv.setVisibility(View.GONE);
        }
    }
}
