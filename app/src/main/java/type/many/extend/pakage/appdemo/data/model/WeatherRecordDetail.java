package type.many.extend.pakage.appdemo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2020/5/5.
 */

//"datasetDescription": "三十六小時天氣預報",
//        "location": [

public class WeatherRecordDetail {

    @SerializedName("datasetDescription")
    private String mDateDescription = "";

    public String getDateDescription() {
        return mDateDescription;
    }

    public void setDateDescription(String dateDescription) {
        mDateDescription = dateDescription;
    }

    @SerializedName("location")
    private List<WeatherLocationDetail> mWeatherLocationDetailList = new ArrayList<>();

    public List<WeatherLocationDetail> getWeatherLocationDetailList() {
        return mWeatherLocationDetailList;
    }

    public void setWeatherLocationDetailList(List<WeatherLocationDetail> weatherLocationDetailList) {
        mWeatherLocationDetailList = weatherLocationDetailList;
    }
}
