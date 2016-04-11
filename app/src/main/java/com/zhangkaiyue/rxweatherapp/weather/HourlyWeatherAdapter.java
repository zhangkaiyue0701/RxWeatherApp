package com.zhangkaiyue.rxweatherapp.weather;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangkaiyue.rxweatherapp.R;
import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Description:
 *
 * @author zhangkaiyue
 * @version 1.0
 * @time 4/11/16 16:29
 */
public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.HourlyViewHolder> {

    private WeatherEntity.HeWeatherEntity weatherEntity;

    public void setData(WeatherEntity.HeWeatherEntity weatherEntity) {
        this.weatherEntity = weatherEntity;
        notifyDataSetChanged();
    }

    @Override
    public HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hourly, parent, false);
        return new HourlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HourlyViewHolder holder, int position) {
        if (weatherEntity != null) {
            holder.tvTime.setText(weatherEntity.getHourly_forecast().get(position).getDate());
            holder.tvTemperature.setText(weatherEntity.getHourly_forecast().get(position).getTmp());
            holder.tvRain.setText(weatherEntity.getHourly_forecast().get(position).getHum());
            holder.tvWind.setText(weatherEntity.getHourly_forecast().get(position).getWind().getSc());
            holder.tvWindDir.setText(weatherEntity.getHourly_forecast().get(position).getWind().getDir());
        }
    }

    @Override
    public int getItemCount() {
        return weatherEntity.getHourly_forecast().size();
    }

    public static class HourlyViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvTime;
        AppCompatImageView ivPoint;
        AppCompatImageView ivLine;
        AppCompatTextView tvTemperature;
        AppCompatTextView tvRain;
        AppCompatTextView tvWind;
        AppCompatTextView tvWindDir;

        public HourlyViewHolder(View itemView) {
            super(itemView);
            tvTime = (AppCompatTextView) itemView.findViewById(R.id.tv_time);
            tvTemperature = (AppCompatTextView) itemView.findViewById(R.id.tv_temperature);
            tvRain = (AppCompatTextView) itemView.findViewById(R.id.tv_rain);
            tvWind = (AppCompatTextView) itemView.findViewById(R.id.tv_wind);
            tvWindDir = (AppCompatTextView) itemView.findViewById(R.id.tv_wind_dir);
            ivPoint = (AppCompatImageView) itemView.findViewById(R.id.iv_point);
            ivLine = (AppCompatImageView) itemView.findViewById(R.id.iv_line);
        }
    }
}
