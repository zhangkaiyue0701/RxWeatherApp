package com.zhangkaiyue.rxweatherapp.weather;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangkaiyue.rxweatherapp.R;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public class NowWeatherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int AIR = 0;
    public static final int WIND = 1;
    public static final int LIFE = 2;

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

        } else if (holder.getItemViewType() == WIND) {

        } else {

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
        public AirViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class WindViewHolder extends RecyclerView.ViewHolder {
        public WindViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class LifeViewHolder extends RecyclerView.ViewHolder {
        public LifeViewHolder(View itemView) {
            super(itemView);
        }
    }
}
