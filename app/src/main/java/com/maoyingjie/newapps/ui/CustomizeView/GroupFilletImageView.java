package com.maoyingjie.newapps.ui.CustomizeView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.maoyingjie.newapps.R;
import com.maoyingjie.newapps.databinding.GroupImageviewLayoutBinding;

import org.jetbrains.annotations.NotNull;

public class GroupFilletImageView extends RelativeLayout {
    private TypedArray ta;
    private GroupImageviewLayoutBinding mBing;

    public GroupFilletImageView(@NonNull @NotNull Context context) {

        super(context);
    }

    public GroupFilletImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        ta = context.obtainStyledAttributes(attributeSet,R.styleable.GroupImageView);

        if (mBing == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            mBing = DataBindingUtil.inflate(inflater, R.layout.group_imageview_layout,
                    this, true);
        }

    }

    public GroupFilletImageView(Context context, AttributeSet attributeSet, int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (ta!=null){
            mBing.firstImgIv.setBackgroundResource(
                    ta.getResourceId(R.styleable.GroupImageView_firstImageBg,R.mipmap.ic_launcher));
            mBing.secondImgIv.setBackgroundResource(
                    ta.getResourceId(R.styleable.GroupImageView_secondImageBg,R.mipmap.ic_launcher));
            mBing.thirdImgIv.setBackgroundResource(
                    ta.getResourceId(R.styleable.GroupImageView_thirdImageBg,R.mipmap.ic_launcher));
        }
    }

    public void BingImg(String... imgs) {
        if (mBing == null)
            return;
        if (imgs[0] != "" && imgs[0] != null)
            Glide
                    .with(getContext())
                    .asBitmap()
                    .load(imgs)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(mBing.firstImgIv);
        if (imgs[1] != "" && imgs[0] != null)
            Glide
                    .with(getContext())
                    .asBitmap()
                    .load(imgs)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(mBing.firstImgIv);
        if (imgs[3] != "" && imgs[0] != null)
            Glide
                    .with(getContext())
                    .asBitmap()
                    .load(imgs)
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .into(mBing.firstImgIv);

    }

//    public void setCutFillet(boolean isCutting) {
//        if (mBing == null)
//            return;
//        mBing.firstImgIv.setOutlineProvider(new ViewOutlineProvider() {
//            @Override
//            public void getOutline(View view, Outline outline) {
//                outline.setRoundRect(0, 0, mBing.firstImgIv.getWidth(),
//                        mBing.firstImgIv.getHeight(), 30);
//            }
//        });
//        mBing.firstImgIv.setClipToOutline(true);
//
//        mBing.secondImgIv.setOutlineProvider(new ViewOutlineProvider() {
//            @Override
//            public void getOutline(View view, Outline outline) {
//                outline.setRoundRect(0, 0, mBing.secondImgIv.getWidth(),
//                        mBing.secondImgIv.getHeight(), 30);
//            }
//        });
//        mBing.secondImgIv.setClipToOutline(true);
//
//        mBing.thirdImgIv.setOutlineProvider(new ViewOutlineProvider() {
//            @Override
//            public void getOutline(View view, Outline outline) {
//                outline.setRoundRect(0, 0, mBing.thirdImgIv.getWidth(),
//                        mBing.thirdImgIv.getHeight(), 30);
//            }
//        });
//        mBing.thirdImgIv.setClipToOutline(true);
//    }
}
