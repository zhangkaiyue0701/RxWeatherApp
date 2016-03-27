package com.zhangkaiyue.rxweatherapp.weather.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;

import com.zhangkaiyue.rxweatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public class WindItem extends CardView {
    @Bind(R.id.tv_wind_sc)
    AppCompatTextView tvWindSc;
    @Bind(R.id.tv_wind_dir)
    AppCompatTextView tvWindDir;
    @Bind(R.id.tv_wind_spd)
    AppCompatTextView tvWindSpd;

    public WindItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_wind, this);
        ButterKnife.bind(this);
    }
}
