package com.zhangkaiyue.rxweatherapp.network;

import com.zhangkaiyue.rxweatherapp.entity.CityEntity;
import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public interface Api {

    @GET("weather")
    Observable<WeatherEntity> getWeather(@Query("cityid") String cityid, @Query("key") String key);

    @GET("citylist")
    Observable<CityEntity> getCity(@Query("search") String search, @Query("key") String key);
}
