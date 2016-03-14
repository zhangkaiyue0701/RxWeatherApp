package com.zhangkaiyue.rxweatherapp.weather.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;

import com.zhangkaiyue.rxweatherapp.R;

import butterknife.ButterKnife;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public class AirItem extends CardView {
    public AirItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_air, this);
        ButterKnife.bind(this);
    }
}
