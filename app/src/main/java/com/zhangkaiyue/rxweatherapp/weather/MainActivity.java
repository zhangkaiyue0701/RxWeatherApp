package com.zhangkaiyue.rxweatherapp.weather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.google.gson.Gson;
import com.zhangkaiyue.rxweatherapp.R;
import com.zhangkaiyue.rxweatherapp.RxApplication;
import com.zhangkaiyue.rxweatherapp.addcity.AddCityActivity;
import com.zhangkaiyue.rxweatherapp.entity.CityEntity;
import com.zhangkaiyue.rxweatherapp.entity.WeatherEntity;
import com.zhangkaiyue.rxweatherapp.network.ApiUtil;
import com.zhangkaiyue.rxweatherapp.utils.FileUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.tab_layout)
    TabLayout tabLayout;
    @Bind(R.id.fab)
    FloatingActionButton fab;
    @Bind(R.id.nav_view)
    NavigationView navView;
    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @Bind(R.id.view_pager)
    ViewPager viewPager;
    @Bind(R.id.tv_weather)
    AppCompatTextView tvWeather;
    @Bind(R.id.tv_location)
    AppCompatTextView tvLocation;
    @Bind(R.id.tv_temperature)
    AppCompatTextView tvTemperature;

    private ViewPagerAdapter viewPagerAdapter;
    private String district;
    private String city;
    private boolean isMunicipality;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressDialog = new ProgressDialog(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        initLocation();

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddCityActivity.class));
            }
        });

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navView.setNavigationItemSelectedListener(this);
    }

    public void initTabLayout(WeatherEntity.HeWeatherEntity weather) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("weather", weather);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 3, bundle);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void getWeather(String cityId) {
        Subscriber<WeatherEntity> subscriber = new Subscriber<WeatherEntity>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.e("error", e.toString());

            }

            @Override
            public void onNext(WeatherEntity weatherEntity) {
                progressDialog.dismiss();
                tvWeather.setText(weatherEntity.getHeWeather().get(0).getNow().getCond().getTxt());
                tvLocation.setText(city + " " + district);
                tvTemperature.setText(weatherEntity.getHeWeather().get(0).getNow().getTmp() + "℃ ");
                initTabLayout(weatherEntity.getHeWeather().get(0));
            }
        };
        ApiUtil.getInstance().getWeather(subscriber, cityId);
    }

    private void initLocation() {
        progressDialog.setMessage("正在定位当前位置");
        progressDialog.show();
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
                        if (district != null && district.endsWith("区")) {
                            district = district.substring(0, district.length() - 1);
                        }
                        if (city != null && city.endsWith("市")) {
                            city = city.substring(0, city.length() - 1);
                        }
                        if (district != null && city != null) {
                            String json = FileUtil.readAssets(MainActivity.this, "city.json");
                            CityEntity cityEntity = (new Gson()).fromJson(json, CityEntity.class);
                            if (cityEntity != null) {
                                for (int i = 0; i < cityEntity.getCity_info().size(); i++) {
                                    if (cityEntity.getCity_info().get(i).getCity().equals(city)) {
                                        getWeather(cityEntity.getCity_info().get(i).getId());
                                        break;
                                    }
                                }
                            }
                        }
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

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
