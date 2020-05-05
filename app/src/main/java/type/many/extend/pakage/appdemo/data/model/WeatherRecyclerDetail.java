package type.many.extend.pakage.appdemo.data.model;

/**
 * Created by User on 2020/5/5.
 */

public class WeatherRecyclerDetail {

    private WeatherTimeDetail mWeatherTimeDetail;

    public WeatherTimeDetail getWeatherTimeDetail() {
        return mWeatherTimeDetail;
    }

    public void setWeatherTimeDetail(WeatherTimeDetail weatherTimeDetail) {
        mWeatherTimeDetail = weatherTimeDetail;
    }

    private int mViewType = 0;

    public int getViewType() {
        return mViewType;
    }

    public void setViewType(int viewType) {
        mViewType = viewType;
    }
}
