package com.zhangkaiyue.rxweatherapp.weather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangkaiyue.rxweatherapp.R;
import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HourlyWeatherFragment extends Fragment {


    @Bind(R.id.rv_hourly_weather)
    RecyclerView rvHourlyWeather;

    private HourlyWeatherAdapter hourlyWeatherAdapter;

    public HourlyWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hourly_weather, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        hourlyWeatherAdapter = new HourlyWeatherAdapter();
        rvHourlyWeather.setAdapter(hourlyWeatherAdapter);
        rvHourlyWeather.setLayoutManager(layoutManager);
        hourlyWeatherAdapter.setData((WeatherEntity.HeWeatherEntity) getArguments().getSerializable("weather"));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
