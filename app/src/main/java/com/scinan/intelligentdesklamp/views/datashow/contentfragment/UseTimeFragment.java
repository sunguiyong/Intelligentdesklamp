package com.scinan.intelligentdesklamp.views.datashow.contentfragment;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.scinan.intelligentdesklamp.BaseFragment;
import com.scinan.intelligentdesklamp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.Bind;

public class UseTimeFragment extends BaseFragment implements View.OnClickListener {
    @Bind(R.id.tv_1)
    TextView tv1;
    @Bind(R.id.tv_2)
    TextView tv2;
    @Bind(R.id.tv_3)
    TextView tv3;
    @Bind(R.id.tv_4)
    TextView tv4;
    @Bind(R.id.chart1)
    LineChart chart1;
    @Bind(R.id.num_tv11)
    TextView numTv11;
    @Bind(R.id.tv11)
    TextView tv11;
    @Bind(R.id.num_tv22)
    TextView numTv22;
    @Bind(R.id.tv22)
    TextView tv22;
    @Bind(R.id.num_tv33)
    TextView numTv33;
    @Bind(R.id.tv33)
    TextView tv33;
    @Bind(R.id.num_tv44)
    TextView numTv44;
    @Bind(R.id.tv44)
    TextView tv44;
    @Bind(R.id.nearlweek_ll)
    LinearLayout nearlweekLl;
    @Bind(R.id.num_tv111)
    TextView numTv111;
    @Bind(R.id.tv111)
    TextView tv111;
    @Bind(R.id.num_tv222)
    TextView numTv222;
    @Bind(R.id.tv222)
    TextView tv222;
    @Bind(R.id.nearlymonth_ll)
    LinearLayout nearlymonthLl;
    @Bind(R.id.num_tv1111)
    TextView numTv1111;
    @Bind(R.id.tv1111)
    TextView tv1111;
    @Bind(R.id.num_tv2222)
    TextView numTv2222;
    @Bind(R.id.tv2222)
    TextView tv2222;
    @Bind(R.id.nearlyhalfyear_ll)
    LinearLayout nearlyhalfyearLl;
    @Bind(R.id.num_tv11111)
    TextView numTv11111;
    @Bind(R.id.tv11111)
    TextView tv11111;
    @Bind(R.id.num_tv22222)
    TextView numTv22222;
    @Bind(R.id.tv22222)
    TextView tv22222;
    @Bind(R.id.nearlyyear_ll)
    LinearLayout nearlyyearLl;
    private int x = R.layout.fragment_usetime;
    private void initChart() {
        Description description = chart1.getDescription();
        Legend legend = chart1.getLegend();
        legend.setEnabled(false);

        description.setEnabled(true);
        description.setPosition(1f, 1f);
        description.setText("时间");
        chart1.setDrawGridBackground(false);
        chart1.setDrawBorders(false);
        chart1.setDragEnabled(false);
        chart1.setTouchEnabled(false);
        chart1.animateY(1000);
        chart1.setDescription(description);

        XAxis xAxis = chart1.getXAxis();
        YAxis leftYAxis = chart1.getAxisLeft();
        YAxis rightYAxis = chart1.getAxisRight();
        rightYAxis.setEnabled(false);
        leftYAxis.setDrawGridLines(false);
        rightYAxis.setDrawAxisLine(false);

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        xAxis.setDrawGridLines(false);

        leftYAxis.setAxisMinimum(0f);
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            entries.add(new Entry(i, new Random().nextInt(80)));
        }
        LineDataSet lineDataSet = new LineDataSet(entries, "");
        lineDataSet.setDrawFilled(false);//去除面积图，折线下的阴影区域
        lineDataSet.setColor(getResources().getColor(R.color.chartcircle));//折线颜色
        lineDataSet.setCircleHoleColor(getResources().getColor(R.color.chartcircle));//折线数据点中心圆形颜色
        lineDataSet.setCircleColor(getResources().getColor(R.color.chartcircle));//折线数据点圆形颜色
        lineDataSet.setCircleSize(5f);//折线数据点圆形大小
        lineDataSet.setDrawCircleHole(true);
        lineDataSet.setDrawIcons(false);

        LineData lineData = new LineData(lineDataSet);

        chart1.setData(lineData);
        chart1.invalidate();
    }
    @Override
    public void bindListener() {
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        tv4.setOnClickListener(this);
    }

    @Override
    public void initData() {
        initChart();
        tv2.setBackgroundResource(R.drawable.tv_unclick);
        tv2.setTextColor(getResources().getColor(R.color.normaltextcolor));
        tv3.setBackgroundResource(R.drawable.tv_unclick);
        tv3.setTextColor(getResources().getColor(R.color.normaltextcolor));
        tv4.setBackgroundResource(R.drawable.tv_unclick);
        tv4.setTextColor(getResources().getColor(R.color.normaltextcolor));
        nearlweekLl.setVisibility(View.VISIBLE);
        nearlymonthLl.setVisibility(View.GONE);
        nearlyhalfyearLl.setVisibility(View.GONE);
        nearlyyearLl.setVisibility(View.GONE);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_usetime;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_1: {
                tv1.setBackgroundResource(R.drawable.tv_click);
                tv1.setTextColor(getResources().getColor(R.color.colorWhite));
                tv2.setBackgroundResource(R.drawable.tv_unclick);
                tv2.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv3.setBackgroundResource(R.drawable.tv_unclick);
                tv3.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv4.setBackgroundResource(R.drawable.tv_unclick);
                tv4.setTextColor(getResources().getColor(R.color.normaltextcolor));
                nearlweekLl.setVisibility(View.VISIBLE);
                nearlymonthLl.setVisibility(View.GONE);
                nearlyhalfyearLl.setVisibility(View.GONE);
                nearlyyearLl.setVisibility(View.GONE);
                initChart();
                break;
            }
            case R.id.tv_2: {
                tv1.setBackgroundResource(R.drawable.tv_unclick);
                tv1.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv2.setBackgroundResource(R.drawable.tv_click);
                tv2.setTextColor(getResources().getColor(R.color.colorWhite));
                tv3.setBackgroundResource(R.drawable.tv_unclick);
                tv3.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv4.setBackgroundResource(R.drawable.tv_unclick);
                tv4.setTextColor(getResources().getColor(R.color.normaltextcolor));
                nearlweekLl.setVisibility(View.GONE);
                nearlymonthLl.setVisibility(View.VISIBLE);
                nearlyhalfyearLl.setVisibility(View.GONE);
                nearlyyearLl.setVisibility(View.GONE);
                initChart();
                break;
            }
            case R.id.tv_3: {
                tv1.setBackgroundResource(R.drawable.tv_unclick);
                tv1.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv2.setBackgroundResource(R.drawable.tv_unclick);
                tv2.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv3.setBackgroundResource(R.drawable.tv_click);
                tv3.setTextColor(getResources().getColor(R.color.colorWhite));
                tv4.setBackgroundResource(R.drawable.tv_unclick);
                tv4.setTextColor(getResources().getColor(R.color.normaltextcolor));
                nearlweekLl.setVisibility(View.GONE);
                nearlymonthLl.setVisibility(View.GONE);
                nearlyhalfyearLl.setVisibility(View.VISIBLE);
                nearlyyearLl.setVisibility(View.GONE);
                initChart();
                break;
            }
            case R.id.tv_4: {
                tv1.setBackgroundResource(R.drawable.tv_unclick);
                tv1.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv2.setBackgroundResource(R.drawable.tv_unclick);
                tv2.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv3.setBackgroundResource(R.drawable.tv_unclick);
                tv3.setTextColor(getResources().getColor(R.color.normaltextcolor));
                tv4.setBackgroundResource(R.drawable.tv_click);
                tv4.setTextColor(getResources().getColor(R.color.colorWhite));
                nearlweekLl.setVisibility(View.GONE);
                nearlymonthLl.setVisibility(View.GONE);
                nearlyhalfyearLl.setVisibility(View.GONE);
                nearlyyearLl.setVisibility(View.VISIBLE);
                initChart();
                break;
            }
        }
    }
}
