package com.maoyingjie.newapps.ui.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.Utils.GlideUtils;
import com.maoyingjie.newapps.databinding.GroupImageviewLayoutBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MGroupFilletImageView extends LinearLayout {
    private GroupImageviewLayoutBinding mBing;
    private int radius = 8;

    public MGroupFilletImageView(@NonNull @NotNull Context context) {
        super(context);
    }

    public MGroupFilletImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (mBing == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            mBing = DataBindingUtil.inflate(inflater, R.layout.group_imageview_layout,
                    this, true);
        }
    }

    public MGroupFilletImageView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public void BingImg(List<String> imgs) {
        if (mBing == null)
            return;
        if (imgs.get(0) != "" && imgs.get(0) != null)
            GlideUtils.LoadImageWithDiskCacheStrategy(mBing.firstImgIv, imgs.get(0));

        if (imgs.get(1) != "" && imgs.get(1) != null)
            GlideUtils.LoadImageWithDiskCacheStrategy(mBing.secondImgIv, imgs.get(1));

        if (imgs.get(2) != "" && imgs.get(2) != null)
            GlideUtils.LoadImageWithDiskCacheStrategy(mBing.thirdImgIv, imgs.get(2));

        CutFillet();
    }

    private void CutFillet() {
        if (mBing == null)
            return;
        mBing.firstImgIv.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, mBing.firstImgIv.getWidth(),
                        mBing.firstImgIv.getHeight(), radius);
            }
        });
        mBing.firstImgIv.setClipToOutline(true);

        mBing.secondImgIv.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, mBing.secondImgIv.getWidth(),
                        mBing.secondImgIv.getHeight(), radius);
            }
        });
        mBing.secondImgIv.setClipToOutline(true);

        mBing.thirdImgIv.setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0, 0, mBing.thirdImgIv.getWidth(),
                        mBing.thirdImgIv.getHeight(), radius);
            }
        });
        mBing.thirdImgIv.setClipToOutline(true);
    }
}
