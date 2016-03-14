package com.zhangkaiyue.rxweatherapp.weather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by zhangkaiyue on 3/14/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {
    private int number;
    private String [] titles = {"实时天气","24小时天气","天气预报"};

    public ViewPagerAdapter(FragmentManager fm, int number) {
        super(fm);
        this.number = number;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new NowWeatherFragment();
            case 1:
                return new HourlyWeatherFragment();
            case 2:
                return new DailyWeatherFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return number;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
