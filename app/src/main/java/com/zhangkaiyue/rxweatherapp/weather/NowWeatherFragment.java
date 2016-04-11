package com.zhangkaiyue.rxweatherapp.weather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhangkaiyue.rxweatherapp.Constants;
import com.zhangkaiyue.rxweatherapp.R;
import com.zhangkaiyue.rxweatherapp.RxApplication;
import com.zhangkaiyue.rxweatherapp.db.RealmHelper;
import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;
import com.zhangkaiyue.rxweatherapp.network.Api;
import com.zhangkaiyue.rxweatherapp.network.ApiUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

/**
 * A simple {@link Fragment} subclass.
 */
public class NowWeatherFragment extends Fragment {


    @Bind(R.id.rv_now_weather)
    RecyclerView rvNowWeather;

    private NowWeatherAdapter adapter;

    public NowWeatherFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_now_weather, container, false);
        ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new NowWeatherAdapter();
        rvNowWeather.setAdapter(adapter);
        rvNowWeather.setLayoutManager(layoutManager);
        adapter.setData((WeatherEntity.HeWeatherEntity) getArguments().getSerializable("weather"));
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
