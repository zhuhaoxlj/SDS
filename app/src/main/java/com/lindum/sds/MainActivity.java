package com.lindum.sds;


import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.xuexiang.xui.XUI;
import com.xuexiang.xui.utils.StatusBarUtils;

import java.util.ArrayList;

/**
 * 启动界面
 *
 * @author MarkGosling
 * @date 2022/3/12 13:50
 **/
public class MainActivity extends DemoBase implements OnChartValueSelectedListener {
    volatile int heartBeats = 80;
    private LineChart chart;
    private final int[] colors = ColorTemplate.VORDIPLOM_COLORS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        XUI.initTheme(this);
        setContentView(R.layout.activity_main);
        StatusBarUtils.fullScreen(this);

        chart = findViewById(R.id.chart1);
        chart.setOnChartValueSelectedListener(this);
        chart.setDrawGridBackground(false);
        chart.getDescription().setEnabled(false);
        chart.setNoDataText("No chart data available. Use the menu to add entries and data sets!");

//        chart.getXAxis().setDrawLabels(false);
//        chart.getXAxis().setDrawGridLines(false);

        chart.invalidate();
        generateHeartBeats();
        printHeartBeats();

    }

    @Override
    protected void saveToGallery() {

    }


    private void addEntry() {

        LineData data = chart.getData();

        if (data == null) {
            data = new LineData();
            chart.setData(data);
        }

        ILineDataSet set = data.getDataSetByIndex(0);
        // set.addEntry(...); // can be called as well

        if (set == null) {
            set = createSet();
            data.addDataSet(set);
        }

        // choose a random dataSet
        int randomDataSetIndex = (int) (Math.random() * data.getDataSetCount());
        ILineDataSet randomSet = data.getDataSetByIndex(randomDataSetIndex);
//        float value = (float) (Math.random() * 50) + 50f * (randomDataSetIndex + 1);
        int value = heartBeats;

        data.addEntry(new Entry(randomSet.getEntryCount(), value), randomDataSetIndex);
        data.notifyDataChanged();

        // let the chart know it's data has changed
        chart.notifyDataSetChanged();

        chart.setVisibleXRangeMaximum(6);
        //chart.setVisibleYRangeMaximum(15, AxisDependency.LEFT);
//
//            // this automatically refreshes the chart (calls invalidate())
        chart.moveViewTo(data.getEntryCount() - 7, 50f, YAxis.AxisDependency.LEFT);

    }

    private LineDataSet createSet() {

        LineDataSet set = new LineDataSet(null, "DataSet 1");
        set.setLineWidth(2.5f);
        set.setCircleRadius(4.5f);
        set.setColor(Color.rgb(240, 99, 99));
        set.setCircleColor(Color.rgb(240, 99, 99));
        set.setHighLightColor(Color.rgb(190, 190, 190));
        set.setAxisDependency(YAxis.AxisDependency.LEFT);
        set.setValueTextSize(10f);

        return set;
    }

    /**
     * 产生心跳
     */
    public void generateHeartBeats() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    heartBeats = generateRandomNumber(60, 100);
                    addEntry();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * 打印心率
     */
    public void printHeartBeats() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                while (true) {
                    Log.e("心率", heartBeats + "");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    /**
     * 生成从a到b的随机整数 即返回值[a,b]
     *
     * @param start 起始数值
     * @param end   结束数值
     * @return 返回的随机数
     */
    public int generateRandomNumber(int start, int end) {
        return start + (int) (Math.random() * (end - start + 1));
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {

    }

    @Override
    public void onNothingSelected() {

    }

}