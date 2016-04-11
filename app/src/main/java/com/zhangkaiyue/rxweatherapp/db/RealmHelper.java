package com.zhangkaiyue.rxweatherapp.db;

import android.content.Context;

import com.zhangkaiyue.rxweatherapp.entity.CityRealmObject;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by zhangkaiyue on 3/27/16.
 */
public class RealmHelper {

    private static Realm getRealm(Context context) {
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).name("city.realm").build();
        Realm realm = Realm.getInstance(realmConfig);
        return realm;
    }

    public static void initCity(final CityRealmObject cityRealmObject, Context context) {
        Realm realm = RealmHelper.getRealm(context);
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CityRealmObject cityRealmObject1 = realm.copyToRealm(cityRealmObject);
            }
        });
    }

    public static String getCityId(String district, String city, Context context) {
        Realm realm = RealmHelper.getRealm(context);
        if (realm.where(CityRealmObject.class).equalTo("city", district).findAll().size() != 0) {
            return realm.where(CityRealmObject.class).equalTo("city", district).findAll().first().getId();
        } else {
            return realm.where(CityRealmObject.class).equalTo("city", city).findAll().first().getId();
        }
    }
}
