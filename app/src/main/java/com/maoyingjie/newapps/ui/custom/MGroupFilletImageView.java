package com.maoyingjie.newapps.ui.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
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
    private ImageView[]imageViews;
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
        imageViews = new ImageView[]{mBing.firstImgIv,mBing.secondImgIv,mBing.thirdImgIv};
        for (int i=0;i<imgs.size();i++){
          if (!TextUtils.isEmpty(imgs.get(i))) {
              GlideUtils.LoadImageWithDiskCacheStrategy(imageViews[i], imgs.get(0));
              imageViews[i].setOutlineProvider(new ViewOutlineProvider() {
                  @Override
                  public void getOutline(View view, Outline outline) {
                      outline.setRoundRect(0, 0, mBing.firstImgIv.getWidth(),
                              mBing.firstImgIv.getHeight(), radius);
                  }
              });
          }
        }
    }

}
