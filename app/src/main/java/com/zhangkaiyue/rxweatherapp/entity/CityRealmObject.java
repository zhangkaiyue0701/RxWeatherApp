package com.zhangkaiyue.rxweatherapp.entity;

import io.realm.RealmObject;

/**
 * Created by zhangkaiyue on 3/27/16.
 */
public class CityRealmObject extends RealmObject {
    private String city;
    private String id;

    public CityRealmObject() {
    }

    public CityRealmObject(String city, String id) {
        this.city = city;
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
