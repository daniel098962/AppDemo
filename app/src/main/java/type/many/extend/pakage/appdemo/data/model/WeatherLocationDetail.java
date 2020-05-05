package type.many.extend.pakage.appdemo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2020/5/5.
 */

//"locationName": "臺北市",
//        "weatherElement": [

public class WeatherLocationDetail {

    @SerializedName("locationName")
    private String mLocationName = "";

    public String getLocationName() {
        return mLocationName;
    }

    public void setLocationName(String locationName) {
        mLocationName = locationName;
    }

    @SerializedName("weatherElement")
    private List<WeatherElementDetail> mWeatherElementDetailList = new ArrayList<>();

    public List<WeatherElementDetail> getWeatherElementDetailList() {
        return mWeatherElementDetailList;
    }

    public void setWeatherElementDetailList(List<WeatherElementDetail> weatherElementDetailList) {
        mWeatherElementDetailList = weatherElementDetailList;
    }
}
