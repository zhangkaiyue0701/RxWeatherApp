package com.zhangkaiyue.rxweatherapp.weather.ui;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;

import com.db.chart.Tools;
import com.db.chart.model.LineSet;
import com.db.chart.view.AxisController;
import com.db.chart.view.LineChartView;
import com.db.chart.view.animation.Animation;
import com.db.chart.view.animation.easing.BounceEase;
import com.zhangkaiyue.rxweatherapp.R;

public class LineCardOne extends CardController {


    private final LineChartView mChart;


    private final Context mContext;


    private final String[] mLabels= {"Jan", "Fev", "Mar", "Apr", "Jun", "May", "Jul", "Aug", "Sep"};
    private final float[] mValues = {3.5f, 4.7f, 4.3f, 8f, 6.5f, 9.9f, 7f, 8.3f, 7.0f};

    private Runnable mBaseAction;


    public LineCardOne(CardView card, Context context){
        super(card);

        mContext = context;
        mChart = (LineChartView) card.findViewById(R.id.chart1);
    }


    @Override
    public void show(Runnable action) {
        super.show(action);

        // Data
        LineSet dataset = new LineSet(mLabels, mValues);
        dataset.setColor(Color.parseColor("#758cbb"))
                .setDotsColor(Color.parseColor("#758cbb"))
                .setThickness(4)
                .setDashed(new float[]{10f,10f})
                .beginAt(5);
        mChart.addData(dataset);


        int [] colors = {Color.parseColor("#265A34"),Color.parseColor("#234567")};
        float [] numbers = {1,2};

        dataset = new LineSet(mLabels, mValues);
        dataset.setColor(Color.parseColor("#b3b5bb"))
                .setDotsColor(Color.parseColor("#ffc755"))
                .setThickness(4)
                .endAt(6)
                .setGradientFill(colors,numbers);
        mChart.addData(dataset);

        // Chart
        mChart.setBorderSpacing(Tools.fromDpToPx(15))
                .setAxisBorderValues(0, 20)
                .setYLabels(AxisController.LabelPosition.NONE)
                .setLabelsColor(Color.parseColor("#6a84c3"))
                .setXAxis(false)
                .setYAxis(false);

        mBaseAction = action;
        Runnable chartAction = new Runnable() {
            @Override
            public void run() {
                mBaseAction.run();
            }
        };

        Animation anim = new Animation()
                .setEasing(new BounceEase())
                .setEndAction(chartAction);

        mChart.show(anim);
    }

}
