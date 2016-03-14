package com.zhangkaiyue.rxweatherapp.weather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangkaiyue.rxweatherapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HourlyWeatherFragment extends Fragment {


    public HourlyWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hourly_weather, container, false);
    }

}
