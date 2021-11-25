package com.maoyingjie.newapps.ui.CustomizeView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.Utils.GlideUtils;
import com.maoyingjie.newapps.databinding.GroupImageviewLayoutBinding;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MGroupFilletImageView extends LinearLayout {
    private TypedArray ta;
    private GroupImageviewLayoutBinding mBing;
    private int[] layoutId;
    private int radius = 12;
    public MGroupFilletImageView(@NonNull @NotNull Context context) {
        super(context);
    }

    public MGroupFilletImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

//        ta = context.obtainStyledAttributes(attributeSet, R.styleable.GroupImageView);
//        layoutId[0] = ta.getResourceId(R.styleable.GroupImageView_firstImageBg,
//                R.mipmap.ic_launcher);
//        layoutId[1] = ta.getResourceId(R.styleable.GroupImageView_secondImageBg,
//                R.mipmap.ic_launcher);
//        layoutId[2] = ta.getResourceId(R.styleable.GroupImageView_thirdImageBg,
//                R.mipmap.ic_launcher);
        if (mBing == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            mBing = DataBindingUtil.inflate(inflater, R.layout.group_imageview_layout,
                    this, true);
        }
//        ta.recycle();
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
            GlideUtils.LoadImageWithDiskCacheStrategy(getContext(),
                    mBing.firstImgIv, imgs.get(0));

        if (imgs.get(1) != "" && imgs.get(1) != null)
            GlideUtils.LoadImageWithDiskCacheStrategy(getContext(),
                    mBing.secondImgIv, imgs.get(1));

        if (imgs.get(2) != "" && imgs.get(2) != null)
            GlideUtils.LoadImageWithDiskCacheStrategy(getContext(),
                    mBing.thirdImgIv, imgs.get(2));

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
