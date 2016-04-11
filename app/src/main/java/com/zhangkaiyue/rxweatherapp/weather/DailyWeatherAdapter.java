package com.zhangkaiyue.rxweatherapp.weather;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;

/**
 * Description:
 *
 * @author zhangkaiyue
 * @version 1.0
 * @time 4/11/16 16:07
 */
public class DailyWeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private WeatherEntity.HeWeatherEntity weatherEntity;

    public void setData(WeatherEntity.HeWeatherEntity weatherEntity) {
        this.weatherEntity = weatherEntity;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return weatherEntity.getDaily_forecast().size();
    }
}
