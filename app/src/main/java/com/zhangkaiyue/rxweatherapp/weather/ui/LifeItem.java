package com.zhangkaiyue.rxweatherapp.weather.ui;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;

import com.zhangkaiyue.rxweatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public class LifeItem extends CardView {
    @Bind(R.id.comfortable_item)
    StarItem comfortableItem;
    @Bind(R.id.clothes_item)
    StarItem clothesItem;
    @Bind(R.id.sport_item)
    StarItem sportItem;
    @Bind(R.id.travel_item)
    StarItem travelItem;
    @Bind(R.id.wash_car_item)
    StarItem washCarItem;
    @Bind(R.id.skin_item)
    StarItem skinItem;
    @Bind(R.id.cold_item)
    StarItem coldItem;

    public LifeItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_life, this);
        ButterKnife.bind(this);
    }
}
