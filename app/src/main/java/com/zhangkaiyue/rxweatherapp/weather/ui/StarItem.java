package com.zhangkaiyue.rxweatherapp.weather.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import com.zhangkaiyue.rxweatherapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public class StarItem extends LinearLayoutCompat {
    @Bind(R.id.one_star)
    AppCompatImageView oneStar;
    @Bind(R.id.two_star)
    AppCompatImageView twoStar;
    @Bind(R.id.three_star)
    AppCompatImageView threeStar;
    @Bind(R.id.four_star)
    AppCompatImageView fourStar;
    @Bind(R.id.five_star)
    AppCompatImageView fiveStar;
    @Bind(R.id.tv_level)
    AppCompatTextView tvLevel;
    @Bind(R.id.life_text)
    AppCompatTextView lifeText;

    public StarItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public StarItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public StarItem(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.item_star, this);
        ButterKnife.bind(this);
    }

    public void setStars(String life, int number, String level) {
        lifeText.setText(life);
        tvLevel.setText(level);
        if (number <= 4) {
            fiveStar.setVisibility(INVISIBLE);
            if (number <= 3) {
                fourStar.setVisibility(INVISIBLE);
                if (number <= 2) {
                    threeStar.setVisibility(INVISIBLE);
                    if (number == 1) {
                        twoStar.setVisibility(INVISIBLE);
                    }
                }
            }
        }
    }

}
