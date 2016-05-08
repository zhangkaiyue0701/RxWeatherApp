package com.zhangkaiyue.rxweatherapp;

import android.app.Application;
import android.content.Context;

/**
 * Description:
 *
 * @author zhangkaiyue
 * @version 1.0
 * @time 3/27/16 16:29
 */
public class RxApplication extends Application {
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this.getApplicationContext();
    }
}
