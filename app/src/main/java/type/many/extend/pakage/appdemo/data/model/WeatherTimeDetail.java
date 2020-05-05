package type.many.extend.pakage.appdemo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2020/5/5.
 */

//"startTime": "2020-05-05 18:00:00",
//        "endTime": "2020-05-06 06:00:00",
//        "parameter": {

public class WeatherTimeDetail {

    @SerializedName("startTime")
    private String mStartTime = "";

    public String getStartTime() {
        return mStartTime;
    }

    public void setStartTime(String startTime) {
        mStartTime = startTime;
    }

    @SerializedName("endTime")
    private String mEndTime = "";

    public String getEndTime() {
        return mEndTime;
    }

    public void setEndTime(String endTime) {
        mEndTime = endTime;
    }

    @SerializedName("parameter")
    private WeatherParameterDetail mWeatherParameterDetail = new WeatherParameterDetail();

    public WeatherParameterDetail getWeatherParameterDetail() {
        return mWeatherParameterDetail;
    }

    public void setWeatherParameterDetail(WeatherParameterDetail weatherParameterDetail) {
        mWeatherParameterDetail = weatherParameterDetail;
    }
}
