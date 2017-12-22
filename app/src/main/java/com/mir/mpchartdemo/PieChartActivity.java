package com.mir.mpchartdemo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class PieChartActivity extends AppCompatActivity {

    private PieChart mPieChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        mPieChart = (PieChart) findViewById(R.id.pieChart);
        initPieChart();
    }

    private void initPieChart() {
        /**
         * 是否使用百分比
         */
        mPieChart.setUsePercentValues(true);
        /**
         * 描述信息
         */
        Description description = new Description();
        description.setText("描述信息");
        mPieChart.setDescription(description);

        /**
         * 设置圆环中间的文字
         */
        mPieChart.setCenterText(generateCenterSpannableText());
        mPieChart.setCenterTextSize(7f);

        /**
         * 圆环距离屏幕上下上下左右的距离
         */
        mPieChart.setExtraOffsets(5f, 5.f, 5.f, 5.f);

        /**
         * 是否显示圆环中间的洞
         */
        mPieChart.setDrawHoleEnabled(true);

        /**
         * 设置中间洞的颜色
         */
        mPieChart.setHoleColor(Color.WHITE);

        /**
         * 设置圆环透明度及半径
         */
        mPieChart.setTransparentCircleColor(Color.YELLOW);
        mPieChart.setTransparentCircleAlpha(110);
        mPieChart.setTransparentCircleRadius(61f);

        /**
         * 设置圆环中间洞的半径
         */
        mPieChart.setHoleRadius(60f);

        /**
         * 是否显示洞中间文本
         */
        mPieChart.setDrawCenterText(true);

        /**
         *触摸是否可以旋转以及松手后旋转的度数
         */
        mPieChart.setRotationAngle(20);
        mPieChart.setRotationEnabled(true);

        setData();
    }

    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("MPAndroidChart\ndeveloped by Philipp Jahoda");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 14, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 14, s.length(), 0);
        return s;
    }


    private void setData() {
        // 设置图表数据与颜色
        ArrayList<PieEntry> entries = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();
        int[] colorfulColors = ColorTemplate.VORDIPLOM_COLORS;
        for (int i = 1; i < colorfulColors.length; i++) {
            PieEntry pieEntry = new PieEntry(i);
            entries.add(pieEntry);
            colors.add(colorfulColors[i - 1]);
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(colors);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        mPieChart.setData(data);
        mPieChart.animateX(800);
    }

}
