package com.maoyingjie.newapps.ui.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

public class LinearGradientTextView extends AppCompatTextView {
    private Paint mPaint;
    private android.graphics.Matrix mMatrix;
    private LinearGradient mLinearGradient;
    private int width = 0;
    private int mTranslate =0;
    public LinearGradientTextView(Context context) {
        super(context);
    }

    public LinearGradientTextView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (width == 0)
            width = getMeasuredWidth();
        if (width > 0) {
            mPaint = getPaint();
            mLinearGradient = new LinearGradient(
                    0,
                    0,
                    width,
                    0,
                    new int[]{Color.parseColor("#8b8b8b"), Color.BLACK},
                    null, Shader.TileMode.MIRROR);
            mPaint.setShader(mLinearGradient);
            mMatrix = new Matrix();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mMatrix != null) {
            mTranslate += width / 5;
            if (mTranslate > 2 * width) {
                mTranslate = -width;
            }
            mMatrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(mMatrix);
            postInvalidateDelayed(150);
        }
    }
}
