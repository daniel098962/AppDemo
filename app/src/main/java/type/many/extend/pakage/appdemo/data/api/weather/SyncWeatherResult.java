package type.many.extend.pakage.appdemo.data.api.weather;

import com.google.gson.annotations.SerializedName;

import type.many.extend.pakage.appdemo.data.model.WeatherRecordDetail;

/**
 * Created by User on 2020/5/5.
 */

public class SyncWeatherResult {

    @SerializedName("success")
    private String mStatus = "";

    public String getStatus() {
        return mStatus;
    }

    public void setStatus(String status) {
        mStatus = status;
    }

    @SerializedName("records")
    private WeatherRecordDetail mRecordDetail = new WeatherRecordDetail();

    public WeatherRecordDetail getRecordDetail() {
        return mRecordDetail;
    }

    public void setRecordDetail(WeatherRecordDetail recordDetail) {
        mRecordDetail = recordDetail;
    }
}
