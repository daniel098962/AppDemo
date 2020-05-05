package type.many.extend.pakage.appdemo.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 2020/5/5.
 */

//"parameterName": "多雲時晴",
//        "parameterValue": "3"

public class WeatherParameterDetail {

    @SerializedName("parameterName")
    private String mParameterName = "";

    public String getParameterName() {
        return mParameterName;
    }

    public void setParameterName(String parameterName) {
        mParameterName = parameterName;
    }

    @SerializedName("parameterValue")
    private String mParameterValue = "";

    public String getParameterValue() {
        return mParameterValue;
    }

    public void setParameterValue(String parameterValue) {
        mParameterValue = parameterValue;
    }

    @SerializedName("parameterUnit")
    private String mParameterUnit = "";

    public String getParameterUnit() {
        return mParameterUnit;
    }

    public void setParameterUnit(String parameterUnit) {
        mParameterUnit = parameterUnit;
    }
}
