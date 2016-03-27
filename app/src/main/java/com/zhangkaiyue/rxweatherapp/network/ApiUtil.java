package com.zhangkaiyue.rxweatherapp.network;

import com.zhangkaiyue.rxweatherapp.Constants;
import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangkaiyue on 3/27/16.
 */
public class ApiUtil {
    public static final String BASE_URL = "https://api.heweather.com/x3/";
    private static final int DEFAULT_TIMEOUT = 5;
    private Retrofit retrofit;
    private Api api;

    public ApiUtil() {
//        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
//        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
//                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    //在访问HttpMethods时创建单例
    private static class SingletonHolder{
        private static final ApiUtil INSTANCE = new ApiUtil();
    }

    //获取单例
    public static ApiUtil getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public void getWeather(Subscriber<WeatherEntity> subscriber, String cityId) {
        api.getWeather(cityId, Constants.KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
