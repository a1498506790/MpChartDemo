package com.mir.mpchartdemo;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.List;

/**
 * @author by lx
 * @github https://github.com/a1498506790
 * @data 2017/12/21
 * @desc
 */
public class MyFormatter implements IAxisValueFormatter {

    private List<TestBean> mDats;

    public MyFormatter(List<TestBean> dats) {
        mDats = dats;
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {
        int position = (int) value;
        TestBean bean = mDats.get(position);
        return bean.getTime();
    }
}
