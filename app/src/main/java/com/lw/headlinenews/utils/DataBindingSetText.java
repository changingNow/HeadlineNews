package com.lw.headlinenews.utils;

import android.databinding.BindingAdapter;
import android.widget.TextView;

import com.lw.commonUtils.StringUtils;
import com.lw.commonUtils.TimeUtil;

/**
 * Created by lw on 17-12-8.
 */

public class DataBindingSetText {
    @BindingAdapter("setIntToTextView")
    public static void setIntToTextView(TextView view, int str) {
        if (!StringUtils.isNullOrEmpty(String.valueOf(str))) {
            view.setText(TimeUtil.getTimeStampAgo(String.valueOf(str)));
        }
    }

    @BindingAdapter("formatTimeToTextView")
    public static void formatTimeToTextView(TextView view, int duration) {
        if (!StringUtils.isNullOrEmpty(String.valueOf(duration))) {
            String min = String.valueOf(duration / 60);
            String second = String.valueOf(duration % 10);
            if (Integer.parseInt(second) < 10) {
                second = "0" + second;
            }
            String videoTime = min + ":" + second;
            view.setText(videoTime);
        }
    }
}
