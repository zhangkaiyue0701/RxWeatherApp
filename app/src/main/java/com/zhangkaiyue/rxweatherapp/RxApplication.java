package com.zhangkaiyue.rxweatherapp;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zhangkaiyue.rxweatherapp.db.RealmHelper;
import com.zhangkaiyue.rxweatherapp.entity.CityEntity;
import com.zhangkaiyue.rxweatherapp.entity.CityRealmObject;
import com.zhangkaiyue.rxweatherapp.network.ApiUtil;

import rx.Subscriber;

/**
 * Created by zhangkaiyue on 3/27/16.
 */
public class RxApplication extends Application {
    private Context context;
    public static String district;
    public static String city;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
        initCity();
        initLocation();
    }

    private void initLocation() {
        AMapLocationClient mLocationClient = new AMapLocationClient(getApplicationContext());
        AMapLocationClientOption mLocationOption = new AMapLocationClientOption();
        //设置是否允许模拟位置,默认为false，不允许模拟位置
        mLocationOption.setMockEnable(false);
        //设置定位间隔,单位毫秒,默认为2000ms
        mLocationOption.setInterval(200000);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.setLocationListener(new AMapLocationListener() {
            @Override
            public void onLocationChanged(AMapLocation aMapLocation) {
                if (aMapLocation != null) {
                    if (aMapLocation.getErrorCode() == 0) {
                        district = aMapLocation.getDistrict();
                        city = aMapLocation.getCity();
                    } else {
                        //显示错误信息ErrCode是错误码，errInfo是错误信息，详见错误码表。
                        Log.e("AmapError", "location Error, ErrCode:"
                                + aMapLocation.getErrorCode() + ", errInfo:"
                                + aMapLocation.getErrorInfo());
                    }
                }
            }
        });
        mLocationClient.startLocation();
        if (district != null && city != null) {
            mLocationClient.stopLocation();
        }
    }

    private void initCity() {
        Subscriber<CityEntity> subscriber = new Subscriber<CityEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(CityEntity cityEntity) {
                for (int i = 0; i < cityEntity.getCity_info().size(); i++) {
                    CityRealmObject cityObject = new CityRealmObject(cityEntity.getCity_info().get(i).getCity(), cityEntity.getCity_info().get(i).getId());
                    RealmHelper.initCity(cityObject, context);
                }
            }
        };
        ApiUtil.getInstance().getCity(subscriber, "allchina");
    }
}
