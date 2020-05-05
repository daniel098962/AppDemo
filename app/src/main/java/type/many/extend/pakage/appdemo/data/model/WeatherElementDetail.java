package type.many.extend.pakage.appdemo.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2020/5/5.
 */

//"elementName": "Wx",
//        "time": [

public class WeatherElementDetail {

    @SerializedName("elementName")
    private String mElementName = "";

    public String getElementName() {
        return mElementName;
    }

    public void setElementName(String elementName) {
        mElementName = elementName;
    }

    @SerializedName("time")
    private List<WeatherTimeDetail> mWeatherTimeDetailList = new ArrayList<>();

    public List<WeatherTimeDetail> getWeatherTimeDetailList() {
        return mWeatherTimeDetailList;
    }

    public void setWeatherTimeDetailList(List<WeatherTimeDetail> weatherTimeDetailList) {
        mWeatherTimeDetailList = weatherTimeDetailList;
    }
}
