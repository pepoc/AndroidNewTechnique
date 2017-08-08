package com.pepoc.androidnewtechnique.customview.layout;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by yangchen on 2017/8/4.
 */

public class FlowLinearLayout extends LinearLayout {
    public FlowLinearLayout(Context context) {
        super(context);
    }

    public FlowLinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public FlowLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
