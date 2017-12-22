package com.mir.mpchartdemo;

import android.content.Context;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.utils.MPPointF;

/**
 * @author by lx
 * @github https://github.com/a1498506790
 * @data 2017/12/21
 * @desc
 */

public class MyMarkerView extends MarkerView {

    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
    }

    @Override
    public MPPointF getOffset() { //正中心
        return new MPPointF(-(getWidth() / 2), -getHeight() / 2);
    }

}
