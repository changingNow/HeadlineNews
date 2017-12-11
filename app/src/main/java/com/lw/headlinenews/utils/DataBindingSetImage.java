package com.lw.headlinenews.utils;

import android.databinding.BindingAdapter;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.lw.commonUtils.StringUtils;
import com.lw.headlinenews.R;

/**
 * Created by lw on 17-12-8.
 */

public class DataBindingSetImage {
    @BindingAdapter("setImageByUrl")
    public static void setImageByUrl(ImageView view, String url) {
        if(!StringUtils.isNullOrEmpty(url)) {
            Glide.with(view.getContext())
                    .load(url)
                    .placeholder(R.mipmap.ic_app_icon)
                    .error(R.mipmap.ic_app_icon)
                    .into(view);
        }
    }
}
