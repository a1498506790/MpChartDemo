package com.mir.mpchartdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.util.ArrayList;
import java.util.List;

import static com.mir.mpchartdemo.R.id.lineChart;

public class LineChartActivity extends AppCompatActivity implements OnChartValueSelectedListener {

    private LineChart mLineChart;
    private List<TestBean> mDatas = new ArrayList<>();
    private TextView mText;
    private MPChartHelper mMPChartHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        mLineChart = (LineChart) findViewById(lineChart);
        mText = (TextView) findViewById(R.id.text);
        mLineChart.setOnChartValueSelectedListener(this);
        getData();
        mMPChartHelper = new MPChartHelper(this);
        mMPChartHelper.initLineChart(mLineChart);
        mMPChartHelper.setLineChartData(mDatas);
    }


    private void getData(){
        TestBean bean1 = new TestBean("331", "06-17");
        mDatas.add(bean1);
        TestBean bean2 = new TestBean("233", "06-17");
        mDatas.add(bean2);
        TestBean bean3 = new TestBean("390", "06-17");
        mDatas.add(bean3);
        TestBean bean4 = new TestBean("233", "06-17");
        mDatas.add(bean4);
        TestBean bean5 = new TestBean("500", "06-17");
        mDatas.add(bean5);

        TestBean bean6 = new TestBean("689", "06-17");
        mDatas.add(bean6);
        TestBean bean7 = new TestBean("399", "06-17");
        mDatas.add(bean7);
        TestBean bean8 = new TestBean("456", "06-17");
        mDatas.add(bean8);
        TestBean bean9 = new TestBean("187", "08-17");
        mDatas.add(bean9);
        TestBean bean10 = new TestBean("245", "09-17");
        mDatas.add(bean10);

        TestBean bean11 = new TestBean("245", "11-17");
        mDatas.add(bean11);
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        TestBean bean = (TestBean) e.getData();
        mText.setText(bean.getValue());
    }

    @Override
    public void onNothingSelected() {}
}
