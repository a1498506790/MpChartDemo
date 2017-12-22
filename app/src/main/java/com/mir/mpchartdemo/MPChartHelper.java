package com.mir.mpchartdemo;

import android.content.Context;
import android.graphics.Color;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by lx
 * @github https://github.com/a1498506790
 * @data 2017/12/22
 * @desc
 */

public class MPChartHelper {

    private Context mContext;
    private LineChart mLineChart;

    public MPChartHelper(Context context) {
        mContext = context;
    }

    public MPChartHelper initLineChart(LineChart lineChart){
        this.mLineChart = lineChart;
        //创建描述信息
        Description description = new Description();
        description.setText("L/m");
        description.setTextSize(10f);
        description.setPosition(70f, 20f);
        description.setTextColor(Color.parseColor("#999999"));
        mLineChart.setDescription(description);//设置图表描述信息


        mLineChart.setNoDataText("没有数据");//没有数据时显示的文字
        mLineChart.setNoDataTextColor(Color.BLUE);//没有数据时显示文字的颜色
        mLineChart.setDrawGridBackground(false);//chart 绘图区后面的背景矩形将绘制
        mLineChart.setDrawBorders(false);//禁止绘制图表边框的线
        // 设置是否支持缩放和拖动
        mLineChart.setDragEnabled(false);
        mLineChart.setScaleEnabled(false);

        //获取X轴
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); //x轴的文字显示在下方
        mLineChart.getAxisRight().setEnabled(false); //右侧y轴 不显示
        xAxis.setDrawGridLines(false); //竖线网格是否显示

        return this;
    }

    public void setLineChartData(List<TestBean> data) {
        //获取左侧y轴
        YAxis axisLeft = mLineChart.getAxisLeft();
        axisLeft.setDrawGridLines(false); //横线网格是否显示
        axisLeft.setDrawAxisLine(true);
        // 设置标记图
        MyMarkerView mv = new MyMarkerView(mContext, R.layout.custom_marker_view);
        mv.setChartView(mLineChart);
        mLineChart.setMarker(mv);
        mLineChart.getXAxis().setValueFormatter(new MyFormatter(data));

        /**
         * Entry 坐标点对象  构造函数 第一个参数为x点坐标 第二个为y点
         */
        ArrayList<Entry> values = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            TestBean bean = data.get(i);
            values.add(new Entry(i, Float.valueOf(bean.getValue()), bean));
        }

        //LineDataSet每一个对象就是一条连接线
        LineDataSet set;
        //判断图表中原来是否有数据
        if (mLineChart.getData() != null &&
                mLineChart.getData().getDataSetCount() > 0) {
            //获取数据1
            set = (LineDataSet) mLineChart.getData().getDataSetByIndex(0);
            set.setValues(values);
            //刷新数据
            mLineChart.getData().notifyDataChanged();
            mLineChart.notifyDataSetChanged();
        } else {
            set = new LineDataSet(values, null);
            // 设置是否绘制值数据
            set.setDrawValues(false);
            // 设置是否显示点击某个点时，横竖的两条线
            set.setHighlightEnabled(true);
            set.setHighLightColor(Color.parseColor("#999999"));
            //点击折现点是否出现 交叉提示线
            set.setDrawHorizontalHighlightIndicator(false); //横轴
            set.setDrawVerticalHighlightIndicator(true); //竖轴
            // 设置折线颜色
            set.setColor(Color.parseColor("#828798"));

            // 设置折线宽度
            set.setLineWidth(1.5f);

            // 设置是否绘制圆点
            set.setDrawCircles(true);
            set.setCircleRadius(6f);
            set.setCircleColor(Color.parseColor("#f28a4b"));

            // 设置是否绘制圆孔
            set.setDrawCircleHole(true);
            set.setCircleHoleRadius(4f);
            set.setCircleColorHole(Color.WHITE);

            // 设置是否绘制填充
            set.setDrawFilled(false);

            //保存LineDataSet集合
            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(set);
            //创建LineData对象 属于LineChart折线图的数据集合
            LineData lineData = new LineData(dataSets);
            // 添加到图表中
            mLineChart.setData(lineData);
            //绘制图表
            mLineChart.invalidate();
        }
    }

}
