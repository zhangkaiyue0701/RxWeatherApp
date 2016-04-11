package com.zhangkaiyue.rxweatherapp.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangkaiyue on 3/15/16.
 */
public class WeatherEntity implements Serializable {

    /**
     * aqi : {"city":{"aqi":"77","co":"2","no2":"50","o3":"70","pm10":"102","pm25":"53","qlty":"良","so2":"58"}}
     * basic : {"city":"大连","cnty":"中国","id":"CN101070201","lat":"38.944000","lon":"121.576000","update":{"loc":"2016-03-27 12:51","utc":"2016-03-27 04:51"}}
     * daily_forecast : [{"astro":{"sr":"05:45","ss":"18:12"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-03-27","hum":"38","pcpn":"0.0","pop":"0","pres":"1018","tmp":{"max":"16","min":"7"},"vis":"10","wind":{"deg":"214","dir":"西风","sc":"4-5","spd":"17"}},{"astro":{"sr":"05:43","ss":"18:13"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2016-03-28","hum":"38","pcpn":"0.0","pop":"0","pres":"1013","tmp":{"max":"16","min":"6"},"vis":"10","wind":{"deg":"224","dir":"西南风","sc":"5-6","spd":"30"}},{"astro":{"sr":"05:42","ss":"18:14"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-03-29","hum":"29","pcpn":"0.0","pop":"16","pres":"1018","tmp":{"max":"14","min":"6"},"vis":"10","wind":{"deg":"317","dir":"西北风","sc":"4-5","spd":"21"}},{"astro":{"sr":"05:40","ss":"18:15"},"cond":{"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"},"date":"2016-03-30","hum":"43","pcpn":"0.0","pop":"0","pres":"1018","tmp":{"max":"16","min":"6"},"vis":"10","wind":{"deg":"172","dir":"南风","sc":"4-5","spd":"19"}},{"astro":{"sr":"05:39","ss":"18:16"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2016-03-31","hum":"68","pcpn":"0.0","pop":"9","pres":"1012","tmp":{"max":"15","min":"5"},"vis":"10","wind":{"deg":"158","dir":"南风","sc":"4-5","spd":"17"}},{"astro":{"sr":"05:37","ss":"18:17"},"cond":{"code_d":"101","code_n":"101","txt_d":"多云","txt_n":"多云"},"date":"2016-04-01","hum":"92","pcpn":"3.1","pop":"56","pres":"1013","tmp":{"max":"13","min":"5"},"vis":"9","wind":{"deg":"243","dir":"北风","sc":"4-5","spd":"19"}},{"astro":{"sr":"05:36","ss":"18:18"},"cond":{"code_d":"100","code_n":"104","txt_d":"晴","txt_n":"阴"},"date":"2016-04-02","hum":"34","pcpn":"0.0","pop":"25","pres":"1025","tmp":{"max":"12","min":"5"},"vis":"10","wind":{"deg":"328","dir":"北风","sc":"4-5","spd":"20"}}]
     * hourly_forecast : [{"date":"2016-03-27 13:00","hum":"39","pop":"0","pres":"1019","tmp":"14","wind":{"deg":"210","dir":"西南风","sc":"微风","spd":"12"}},{"date":"2016-03-27 16:00","hum":"40","pop":"0","pres":"1018","tmp":"14","wind":{"deg":"223","dir":"西南风","sc":"微风","spd":"13"}},{"date":"2016-03-27 19:00","hum":"45","pop":"0","pres":"1018","tmp":"11","wind":{"deg":"229","dir":"西南风","sc":"微风","spd":"11"}},{"date":"2016-03-27 22:00","hum":"47","pop":"0","pres":"1018","tmp":"9","wind":{"deg":"209","dir":"西南风","sc":"微风","spd":"11"}}]
     * now : {"cond":{"code":"100","txt":"晴"},"fl":"18","hum":"19","pcpn":"0","pres":"1018","tmp":"15","vis":"10","wind":{"deg":"160","dir":"西南风","sc":"5-6","spd":"32"}}
     * status : ok
     * suggestion : {"comf":{"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"},"cw":{"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"},"drsg":{"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"},"flu":{"brf":"极易发","txt":"昼夜温差极大，且风力较强，极易发生感冒，请特别注意增减衣服保暖防寒。"},"sport":{"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"},"trav":{"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"},"uv":{"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}}
     */

    @SerializedName("HeWeather data service 3.0")
    private List<HeWeatherEntity> HeWeather;

    public List<HeWeatherEntity> getHeWeather() {
        return HeWeather;
    }

    public void setHeWeather(List<HeWeatherEntity> HeWeather) {
        this.HeWeather = HeWeather;
    }

    public static class HeWeatherEntity implements Serializable {
        /**
         * city : {"aqi":"77","co":"2","no2":"50","o3":"70","pm10":"102","pm25":"53","qlty":"良","so2":"58"}
         */

        private AqiEntity aqi;
        /**
         * city : 大连
         * cnty : 中国
         * id : CN101070201
         * lat : 38.944000
         * lon : 121.576000
         * update : {"loc":"2016-03-27 12:51","utc":"2016-03-27 04:51"}
         */

        private BasicEntity basic;
        /**
         * cond : {"code":"100","txt":"晴"}
         * fl : 18
         * hum : 19
         * pcpn : 0
         * pres : 1018
         * tmp : 15
         * vis : 10
         * wind : {"deg":"160","dir":"西南风","sc":"5-6","spd":"32"}
         */

        private NowEntity now;
        private String status;
        /**
         * comf : {"brf":"舒适","txt":"白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。"}
         * cw : {"brf":"较不宜","txt":"较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。"}
         * drsg : {"brf":"较冷","txt":"建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。"}
         * flu : {"brf":"极易发","txt":"昼夜温差极大，且风力较强，极易发生感冒，请特别注意增减衣服保暖防寒。"}
         * sport : {"brf":"较适宜","txt":"天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。"}
         * trav : {"brf":"适宜","txt":"天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。"}
         * uv : {"brf":"中等","txt":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
         */

        private SuggestionEntity suggestion;
        /**
         * astro : {"sr":"05:45","ss":"18:12"}
         * cond : {"code_d":"100","code_n":"100","txt_d":"晴","txt_n":"晴"}
         * date : 2016-03-27
         * hum : 38
         * pcpn : 0.0
         * pop : 0
         * pres : 1018
         * tmp : {"max":"16","min":"7"}
         * vis : 10
         * wind : {"deg":"214","dir":"西风","sc":"4-5","spd":"17"}
         */

        private List<DailyForecastEntity> daily_forecast;
        /**
         * date : 2016-03-27 13:00
         * hum : 39
         * pop : 0
         * pres : 1019
         * tmp : 14
         * wind : {"deg":"210","dir":"西南风","sc":"微风","spd":"12"}
         */

        private List<HourlyForecastEntity> hourly_forecast;

        public AqiEntity getAqi() {
            return aqi;
        }

        public void setAqi(AqiEntity aqi) {
            this.aqi = aqi;
        }

        public BasicEntity getBasic() {
            return basic;
        }

        public void setBasic(BasicEntity basic) {
            this.basic = basic;
        }

        public NowEntity getNow() {
            return now;
        }

        public void setNow(NowEntity now) {
            this.now = now;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SuggestionEntity getSuggestion() {
            return suggestion;
        }

        public void setSuggestion(SuggestionEntity suggestion) {
            this.suggestion = suggestion;
        }

        public List<DailyForecastEntity> getDaily_forecast() {
            return daily_forecast;
        }

        public void setDaily_forecast(List<DailyForecastEntity> daily_forecast) {
            this.daily_forecast = daily_forecast;
        }

        public List<HourlyForecastEntity> getHourly_forecast() {
            return hourly_forecast;
        }

        public void setHourly_forecast(List<HourlyForecastEntity> hourly_forecast) {
            this.hourly_forecast = hourly_forecast;
        }

        public static class AqiEntity implements Serializable {
            /**
             * aqi : 77
             * co : 2
             * no2 : 50
             * o3 : 70
             * pm10 : 102
             * pm25 : 53
             * qlty : 良
             * so2 : 58
             */

            private CityEntity city;

            public CityEntity getCity() {
                return city;
            }

            public void setCity(CityEntity city) {
                this.city = city;
            }

            public static class CityEntity implements Serializable {
                private String aqi;
                private String co;
                private String no2;
                private String o3;
                private String pm10;
                private String pm25;
                private String qlty;
                private String so2;

                public String getAqi() {
                    return aqi;
                }

                public void setAqi(String aqi) {
                    this.aqi = aqi;
                }

                public String getCo() {
                    return co;
                }

                public void setCo(String co) {
                    this.co = co;
                }

                public String getNo2() {
                    return no2;
                }

                public void setNo2(String no2) {
                    this.no2 = no2;
                }

                public String getO3() {
                    return o3;
                }

                public void setO3(String o3) {
                    this.o3 = o3;
                }

                public String getPm10() {
                    return pm10;
                }

                public void setPm10(String pm10) {
                    this.pm10 = pm10;
                }

                public String getPm25() {
                    return pm25;
                }

                public void setPm25(String pm25) {
                    this.pm25 = pm25;
                }

                public String getQlty() {
                    return qlty;
                }

                public void setQlty(String qlty) {
                    this.qlty = qlty;
                }

                public String getSo2() {
                    return so2;
                }

                public void setSo2(String so2) {
                    this.so2 = so2;
                }
            }
        }

        public static class BasicEntity implements Serializable {
            private String city;
            private String cnty;
            private String id;
            private String lat;
            private String lon;
            /**
             * loc : 2016-03-27 12:51
             * utc : 2016-03-27 04:51
             */

            private UpdateEntity update;

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getCnty() {
                return cnty;
            }

            public void setCnty(String cnty) {
                this.cnty = cnty;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getLat() {
                return lat;
            }

            public void setLat(String lat) {
                this.lat = lat;
            }

            public String getLon() {
                return lon;
            }

            public void setLon(String lon) {
                this.lon = lon;
            }

            public UpdateEntity getUpdate() {
                return update;
            }

            public void setUpdate(UpdateEntity update) {
                this.update = update;
            }

            public static class UpdateEntity implements Serializable{
                private String loc;
                private String utc;

                public String getLoc() {
                    return loc;
                }

                public void setLoc(String loc) {
                    this.loc = loc;
                }

                public String getUtc() {
                    return utc;
                }

                public void setUtc(String utc) {
                    this.utc = utc;
                }
            }
        }

        public static class NowEntity implements Serializable {
            /**
             * code : 100
             * txt : 晴
             */

            private CondEntity cond;
            private String fl;
            private String hum;
            private String pcpn;
            private String pres;
            private String tmp;
            private String vis;
            /**
             * deg : 160
             * dir : 西南风
             * sc : 5-6
             * spd : 32
             */

            private WindEntity wind;

            public CondEntity getCond() {
                return cond;
            }

            public void setCond(CondEntity cond) {
                this.cond = cond;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindEntity getWind() {
                return wind;
            }

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public static class CondEntity implements Serializable {
                private String code;
                private String txt;

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class WindEntity implements Serializable {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class SuggestionEntity implements Serializable {
            /**
             * brf : 舒适
             * txt : 白天不太热也不太冷，风力不大，相信您在这样的天气条件下，应会感到比较清爽和舒适。
             */

            private ComfEntity comf;
            /**
             * brf : 较不宜
             * txt : 较不宜洗车，未来一天无雨，风力较大，如果执意擦洗汽车，要做好蒙上污垢的心理准备。
             */

            private CwEntity cw;
            /**
             * brf : 较冷
             * txt : 建议着厚外套加毛衣等服装。年老体弱者宜着大衣、呢外套加羊毛衫。
             */

            private DrsgEntity drsg;
            /**
             * brf : 极易发
             * txt : 昼夜温差极大，且风力较强，极易发生感冒，请特别注意增减衣服保暖防寒。
             */

            private FluEntity flu;
            /**
             * brf : 较适宜
             * txt : 天气较好，但风力较大，推荐您进行室内运动，若在户外运动请注意避风保暖。
             */

            private SportEntity sport;
            /**
             * brf : 适宜
             * txt : 天气较好，风稍大，但温度适宜，是个好天气哦。适宜旅游，您可以尽情地享受大自然的无限风光。
             */

            private TravEntity trav;
            /**
             * brf : 中等
             * txt : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
             */

            private UvEntity uv;

            public ComfEntity getComf() {
                return comf;
            }

            public void setComf(ComfEntity comf) {
                this.comf = comf;
            }

            public CwEntity getCw() {
                return cw;
            }

            public void setCw(CwEntity cw) {
                this.cw = cw;
            }

            public DrsgEntity getDrsg() {
                return drsg;
            }

            public void setDrsg(DrsgEntity drsg) {
                this.drsg = drsg;
            }

            public FluEntity getFlu() {
                return flu;
            }

            public void setFlu(FluEntity flu) {
                this.flu = flu;
            }

            public SportEntity getSport() {
                return sport;
            }

            public void setSport(SportEntity sport) {
                this.sport = sport;
            }

            public TravEntity getTrav() {
                return trav;
            }

            public void setTrav(TravEntity trav) {
                this.trav = trav;
            }

            public UvEntity getUv() {
                return uv;
            }

            public void setUv(UvEntity uv) {
                this.uv = uv;
            }

            public static class ComfEntity implements Serializable {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class CwEntity implements Serializable {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class DrsgEntity implements Serializable {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class FluEntity implements Serializable {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class SportEntity implements Serializable {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class TravEntity implements Serializable {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }

            public static class UvEntity implements Serializable {
                private String brf;
                private String txt;

                public String getBrf() {
                    return brf;
                }

                public void setBrf(String brf) {
                    this.brf = brf;
                }

                public String getTxt() {
                    return txt;
                }

                public void setTxt(String txt) {
                    this.txt = txt;
                }
            }
        }

        public static class DailyForecastEntity implements Serializable {
            /**
             * sr : 05:45
             * ss : 18:12
             */

            private AstroEntity astro;
            /**
             * code_d : 100
             * code_n : 100
             * txt_d : 晴
             * txt_n : 晴
             */

            private CondEntity cond;
            private String date;
            private String hum;
            private String pcpn;
            private String pop;
            private String pres;
            /**
             * max : 16
             * min : 7
             */

            private TmpEntity tmp;
            private String vis;
            /**
             * deg : 214
             * dir : 西风
             * sc : 4-5
             * spd : 17
             */

            private WindEntity wind;

            public AstroEntity getAstro() {
                return astro;
            }

            public void setAstro(AstroEntity astro) {
                this.astro = astro;
            }

            public CondEntity getCond() {
                return cond;
            }

            public void setCond(CondEntity cond) {
                this.cond = cond;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPcpn() {
                return pcpn;
            }

            public void setPcpn(String pcpn) {
                this.pcpn = pcpn;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public TmpEntity getTmp() {
                return tmp;
            }

            public void setTmp(TmpEntity tmp) {
                this.tmp = tmp;
            }

            public String getVis() {
                return vis;
            }

            public void setVis(String vis) {
                this.vis = vis;
            }

            public WindEntity getWind() {
                return wind;
            }

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public static class AstroEntity implements Serializable {
                private String sr;
                private String ss;

                public String getSr() {
                    return sr;
                }

                public void setSr(String sr) {
                    this.sr = sr;
                }

                public String getSs() {
                    return ss;
                }

                public void setSs(String ss) {
                    this.ss = ss;
                }
            }

            public static class CondEntity implements Serializable {
                private String code_d;
                private String code_n;
                private String txt_d;
                private String txt_n;

                public String getCode_d() {
                    return code_d;
                }

                public void setCode_d(String code_d) {
                    this.code_d = code_d;
                }

                public String getCode_n() {
                    return code_n;
                }

                public void setCode_n(String code_n) {
                    this.code_n = code_n;
                }

                public String getTxt_d() {
                    return txt_d;
                }

                public void setTxt_d(String txt_d) {
                    this.txt_d = txt_d;
                }

                public String getTxt_n() {
                    return txt_n;
                }

                public void setTxt_n(String txt_n) {
                    this.txt_n = txt_n;
                }
            }

            public static class TmpEntity implements Serializable {
                private String max;
                private String min;

                public String getMax() {
                    return max;
                }

                public void setMax(String max) {
                    this.max = max;
                }

                public String getMin() {
                    return min;
                }

                public void setMin(String min) {
                    this.min = min;
                }
            }

            public static class WindEntity implements Serializable {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }

        public static class HourlyForecastEntity implements Serializable {
            private String date;
            private String hum;
            private String pop;
            private String pres;
            private String tmp;
            /**
             * deg : 210
             * dir : 西南风
             * sc : 微风
             * spd : 12
             */

            private WindEntity wind;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getHum() {
                return hum;
            }

            public void setHum(String hum) {
                this.hum = hum;
            }

            public String getPop() {
                return pop;
            }

            public void setPop(String pop) {
                this.pop = pop;
            }

            public String getPres() {
                return pres;
            }

            public void setPres(String pres) {
                this.pres = pres;
            }

            public String getTmp() {
                return tmp;
            }

            public void setTmp(String tmp) {
                this.tmp = tmp;
            }

            public WindEntity getWind() {
                return wind;
            }

            public void setWind(WindEntity wind) {
                this.wind = wind;
            }

            public static class WindEntity implements Serializable {
                private String deg;
                private String dir;
                private String sc;
                private String spd;

                public String getDeg() {
                    return deg;
                }

                public void setDeg(String deg) {
                    this.deg = deg;
                }

                public String getDir() {
                    return dir;
                }

                public void setDir(String dir) {
                    this.dir = dir;
                }

                public String getSc() {
                    return sc;
                }

                public void setSc(String sc) {
                    this.sc = sc;
                }

                public String getSpd() {
                    return spd;
                }

                public void setSpd(String spd) {
                    this.spd = spd;
                }
            }
        }
    }
}
