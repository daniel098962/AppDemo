package type.many.extend.pakage.appdemo.manager;

import java.util.List;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import type.many.extend.pakage.appdemo.custom.AppDemoApplication;
import type.many.extend.pakage.appdemo.data.api.weather.SyncWeatherResult;
import type.many.extend.pakage.appdemo.data.model.PhotoDetail;
import type.many.extend.pakage.appdemo.data.model.WeatherRecordDetail;

/**
 * Created by User on 2020/5/4.
 */

public class DemoApiManager {

    /*=================================================================*/
    // Constructor
    /*=================================================================*/
    public DemoApiManager(Retrofit retrofit) {
        mApi = retrofit.create(Api.class);
    }


    /*=================================================================*/
    // Data
    /*=================================================================*/
    private Api mApi;
    public Api getApi() {
        return mApi;
    }


    /*=================================================================*/
    // interface Api
    /*=================================================================*/
    public interface Api {

        @GET("photos")
        Call<List<PhotoDetail>> callSyncPhoto();

        @GET("v1/rest/datastore/F-C0032-001")
        Call<SyncWeatherResult> callWeatherApi(@Query("Authorization") String authorization,
                                               @QueryMap Map<String, String> locationMap);
    }
}
