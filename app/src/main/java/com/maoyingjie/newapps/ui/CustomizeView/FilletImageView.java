package com.maoyingjie.newapps.ui.CustomizeView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;

import org.jetbrains.annotations.NotNull;

public class FilletImageView extends AppCompatImageView {

    public FilletImageView(@NonNull @NotNull Context context) {
        super(context);
    }
    public FilletImageView(Context context, AttributeSet attr){
        super(context,attr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setOutlineProvider(new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                outline.setRoundRect(0,0,getWidth(),getHeight(),12);
            }
        });
        setClipToOutline(true);
    }
}
