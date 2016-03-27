package com.zhangkaiyue.rxweatherapp.weather;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zhangkaiyue.rxweatherapp.R;
import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;
import com.zhangkaiyue.rxweatherapp.weather.ui.StarItem;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public class NowWeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private com.zhangkaiyue.rxweatherapp.entity.WeatherEntity.HeWeatherEntity weatherEntity;
    public static final int AIR = 0;
    public static final int WIND = 1;
    public static final int LIFE = 2;

    public void setData(WeatherEntity.HeWeatherEntity weatherEntity) {
        this.weatherEntity = weatherEntity;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == AIR) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_air, parent, false);
            return new AirViewHolder(view);
        } else if (viewType == WIND) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_wind, parent, false);
            return new WindViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_life, parent, false);
            return new LifeViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == AIR) {
            if (weatherEntity != null && weatherEntity.getAqi() != null) {
                ((AirViewHolder) holder).tvAqi.setText(weatherEntity.getAqi().getCity().getAqi());
                ((AirViewHolder) holder).tvQlty.setText(weatherEntity.getAqi().getCity().getQlty());
                ((AirViewHolder) holder).tvPm.setText(weatherEntity.getAqi().getCity().getPm25());
            }
        } else if (holder.getItemViewType() == WIND) {
            if (weatherEntity != null && weatherEntity.getNow().getWind() != null) {
                ((WindViewHolder) holder).tvWindSc.setText(weatherEntity.getNow().getWind().getSc()+"级");
                ((WindViewHolder) holder).tvWindDir.setText(weatherEntity.getNow().getWind().getDir());
                ((WindViewHolder) holder).tvWindSpd.setText(weatherEntity.getNow().getWind().getSpd());
            }
        } else {
            if (weatherEntity != null && weatherEntity.getSuggestion() != null) {
                ((LifeViewHolder) holder).comfortableItem.setStars("舒适指数", 3, weatherEntity.getSuggestion().getComf().getBrf());
                ((LifeViewHolder) holder).washCarItem.setStars("洗车指数", 3, weatherEntity.getSuggestion().getCw().getBrf());
                ((LifeViewHolder) holder).clothesItem.setStars("穿衣指数", 3, weatherEntity.getSuggestion().getDrsg().getBrf());
                ((LifeViewHolder) holder).sportItem.setStars("运动指数", 3, weatherEntity.getSuggestion().getSport().getBrf());
                ((LifeViewHolder) holder).travelItem.setStars("旅行指数", 3, weatherEntity.getSuggestion().getTrav().getBrf());
                ((LifeViewHolder) holder).skinItem.setStars("紫外线指数", 3, weatherEntity.getSuggestion().getUv().getBrf());
                ((LifeViewHolder) holder).coldItem.setStars("感冒指数", 3, weatherEntity.getSuggestion().getFlu().getBrf());
            }
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public static class AirViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvAqi;
        AppCompatTextView tvQlty;
        AppCompatTextView tvPm;

        public AirViewHolder(View itemView) {
            super(itemView);
            tvAqi = (AppCompatTextView) itemView.findViewById(R.id.tv_aqi);
            tvQlty = (AppCompatTextView) itemView.findViewById(R.id.tv_qlty);
            tvPm = (AppCompatTextView) itemView.findViewById(R.id.tv_pm);
        }
    }

    public static class WindViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvWindSc;
        AppCompatTextView tvWindDir;
        AppCompatTextView tvWindSpd;

        public WindViewHolder(View itemView) {
            super(itemView);
            tvWindSc = (AppCompatTextView) itemView.findViewById(R.id.tv_wind_sc);
            tvWindDir = (AppCompatTextView) itemView.findViewById(R.id.tv_wind_dir);
            tvWindSpd = (AppCompatTextView) itemView.findViewById(R.id.tv_wind_spd);
        }
    }

    public static class LifeViewHolder extends RecyclerView.ViewHolder {
        StarItem comfortableItem;
        StarItem clothesItem;
        StarItem sportItem;
        StarItem travelItem;
        StarItem washCarItem;
        StarItem skinItem;
        StarItem coldItem;

        public LifeViewHolder(View itemView) {
            super(itemView);
            comfortableItem = (StarItem) itemView.findViewById(R.id.comfortable_item);
            clothesItem = (StarItem) itemView.findViewById(R.id.clothes_item);
            sportItem = (StarItem) itemView.findViewById(R.id.sport_item);
            travelItem = (StarItem) itemView.findViewById(R.id.travel_item);
            washCarItem = (StarItem) itemView.findViewById(R.id.wash_car_item);
            skinItem = (StarItem) itemView.findViewById(R.id.skin_item);
            coldItem = (StarItem) itemView.findViewById(R.id.cold_item);
        }
    }
}
