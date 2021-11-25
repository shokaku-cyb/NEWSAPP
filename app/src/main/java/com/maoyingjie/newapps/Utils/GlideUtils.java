package com.maoyingjie.newapps.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.maoyingjie.newapps.App;
import com.maoyingjie.newapps.R;

public class GlideUtils {

    public static void LoadImageWithDiskCacheStrategy(ImageView imageView, String img) {
        Glide
                .with(App.ApplicationContext())
                .asBitmap()
                .load(img)
                .error(R.mipmap.logo)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(imageView);
    }
}
