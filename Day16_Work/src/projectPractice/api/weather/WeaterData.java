package projectPractice.api.weather;

public class WeaterData {

    /**
     * success : 1
     * result : {"weaid":"1","days":"2017-12-14","week":"星期四","cityno":"beijing","citynm":"北京","cityid":"101010100","temperature":"0℃/-4℃","temperature_curr":"0℃","humidity":"39%","weather":"阴转多云","weather_curr":"阴","weather_icon":"http://api.k780.com/upload/weather/d/2.gif","weather_icon1":"","wind":"西南风","winp":"2级","temp_high":"0","temp_low":"-4","temp_curr":"0","humi_high":"0","humi_low":"0","weatid":"3","weatid1":"","windid":"16","winpid":"203"}
     */

    private String success;
    private ResultBean result;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * weaid : 1
         * days : 2017-12-14
         * week : 星期四
         * cityno : beijing
         * citynm : 北京
         * cityid : 101010100
         * temperature : 0℃/-4℃
         * temperature_curr : 0℃
         * humidity : 39%
         * weather : 阴转多云
         * weather_curr : 阴
         * weather_icon : http://api.k780.com/upload/weather/d/2.gif
         * weather_icon1 :
         * wind : 西南风
         * winp : 2级
         * temp_high : 0
         * temp_low : -4
         * temp_curr : 0
         * humi_high : 0
         * humi_low : 0
         * weatid : 3
         * weatid1 :
         * windid : 16
         * winpid : 203
         */

        private String weaid;
        private String days;
        private String week;
        private String cityno;
        private String citynm;
        private String cityid;
        private String temperature;
        private String temperature_curr;
        private String humidity;
        private String weather;
        private String weather_curr;
        private String weather_icon;
        private String weather_icon1;
        private String wind;
        private String winp;
        private String temp_high;
        private String temp_low;
        private String temp_curr;
        private String humi_high;
        private String humi_low;
        private String weatid;
        private String weatid1;
        private String windid;
        private String winpid;

        @Override
        public String toString() {
            return "{" +
                    "days='" + days + '\'' +
                    ", week='" + week + '\'' +
                    ", citynm='" + citynm + '\'' +
                    ", temperature='" + temperature + '\'' +
                    ", temperature_curr='" + temperature_curr + '\'' +
                    ", weather='" + weather + '\'' +
                    ", weather_curr='" + weather_curr + '\'' +
                    ", wind='" + wind + '\'' +
                    ", winp='" + winp + '\'' +
                    '}';
        }

        /**
         * success : 1
         * result : {"weaid":"1","days":"2017-12-14","week":"星期四","cityno":"beijing","citynm":"北京
         * ","cityid":"101010100","temperature":"0℃/-4℃","temperature_curr":"0℃","humidity":"39%",
         * "weather":"阴转多云","weather_curr":"阴","weather_icon":"http://api.k780.com/upload/weather/d/2.gif",
         * "weather_icon1":"","wind":"西南风","winp":"2级","temp_high":"0","temp_low":"-4","temp_curr":"0","humi_high":"0","humi_low":"0","weatid":"3","weatid1":"","windid":"16","winpid":"203"}
         */


        public String getWeaid() {
            return weaid;
        }

        public void setWeaid(String weaid) {
            this.weaid = weaid;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public String getCityno() {
            return cityno;
        }

        public void setCityno(String cityno) {
            this.cityno = cityno;
        }

        public String getCitynm() {
            return citynm;
        }

        public void setCitynm(String citynm) {
            this.citynm = citynm;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getTemperature_curr() {
            return temperature_curr;
        }

        public void setTemperature_curr(String temperature_curr) {
            this.temperature_curr = temperature_curr;
        }

        public String getHumidity() {
            return humidity;
        }

        public void setHumidity(String humidity) {
            this.humidity = humidity;
        }

        public String getWeather() {
            return weather;
        }

        public void setWeather(String weather) {
            this.weather = weather;
        }

        public String getWeather_curr() {
            return weather_curr;
        }

        public void setWeather_curr(String weather_curr) {
            this.weather_curr = weather_curr;
        }

        public String getWeather_icon() {
            return weather_icon;
        }

        public void setWeather_icon(String weather_icon) {
            this.weather_icon = weather_icon;
        }

        public String getWeather_icon1() {
            return weather_icon1;
        }

        public void setWeather_icon1(String weather_icon1) {
            this.weather_icon1 = weather_icon1;
        }

        public String getWind() {
            return wind;
        }

        public void setWind(String wind) {
            this.wind = wind;
        }

        public String getWinp() {
            return winp;
        }

        public void setWinp(String winp) {
            this.winp = winp;
        }

        public String getTemp_high() {
            return temp_high;
        }

        public void setTemp_high(String temp_high) {
            this.temp_high = temp_high;
        }

        public String getTemp_low() {
            return temp_low;
        }

        public void setTemp_low(String temp_low) {
            this.temp_low = temp_low;
        }

        public String getTemp_curr() {
            return temp_curr;
        }

        public void setTemp_curr(String temp_curr) {
            this.temp_curr = temp_curr;
        }

        public String getHumi_high() {
            return humi_high;
        }

        public void setHumi_high(String humi_high) {
            this.humi_high = humi_high;
        }

        public String getHumi_low() {
            return humi_low;
        }

        public void setHumi_low(String humi_low) {
            this.humi_low = humi_low;
        }

        public String getWeatid() {
            return weatid;
        }

        public void setWeatid(String weatid) {
            this.weatid = weatid;
        }

        public String getWeatid1() {
            return weatid1;
        }

        public void setWeatid1(String weatid1) {
            this.weatid1 = weatid1;
        }

        public String getWindid() {
            return windid;
        }

        public void setWindid(String windid) {
            this.windid = windid;
        }

        public String getWinpid() {
            return winpid;
        }

        public void setWinpid(String winpid) {
            this.winpid = winpid;
        }
    }
}
