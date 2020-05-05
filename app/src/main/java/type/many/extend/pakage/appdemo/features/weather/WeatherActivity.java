package type.many.extend.pakage.appdemo.features.weather;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import type.many.extend.pakage.appdemo.R;
import type.many.extend.pakage.appdemo.custom.AppDemoApplication;
import type.many.extend.pakage.appdemo.custom.DemoActivity;
import type.many.extend.pakage.appdemo.custom.view_holder.PhotoDetailViewHolder;
import type.many.extend.pakage.appdemo.custom.view_holder.WeatherDetailViewHolder;
import type.many.extend.pakage.appdemo.data.AppProperties;
import type.many.extend.pakage.appdemo.data.api.weather.SyncWeatherResult;
import type.many.extend.pakage.appdemo.data.model.WeatherElementDetail;
import type.many.extend.pakage.appdemo.data.model.WeatherLocationDetail;
import type.many.extend.pakage.appdemo.data.model.WeatherRecyclerDetail;
import type.many.extend.pakage.appdemo.data.model.WeatherTimeDetail;

public class WeatherActivity extends DemoActivity {

    /*=================================================================*/
    // Global
    /*=================================================================*/

    //跳頁
    public static void startActivity(Context context) {

        Intent intent = new Intent(context, WeatherActivity.class);
        context.startActivity(intent);
    }

    /*=================================================================*/
    // Constructor
    /*=================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        //region View
        {
            mRecyclerView = findViewById(R.id.recycler_view);
        }
        //endregion

        //region Data
        {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(WeatherActivity.this));
        }
        //endregion

        //region Function
        {
            syncWeather();
        }
        //endregion

    }

    /*=================================================================*/
    // View
    /*=================================================================*/
    private RecyclerView mRecyclerView;

    /*=================================================================*/
    // Data
    /*=================================================================*/
    private List<WeatherTimeDetail> mWeatherTimeDetailList;
    private List<WeatherRecyclerDetail> mWeatherRecyclerDetailList = new ArrayList<>();

    //RecyclerView 適配器
    private RecyclerView.Adapter mAdapter = new RecyclerView.Adapter() {
        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view;

            if (viewType == 0) {
                view = View.inflate(parent.getContext(), R.layout.item_weather_word_detail, null);
            } else {
                view = View.inflate(parent.getContext(), R.layout.item_weather_image, null);
            }

            final WeatherDetailViewHolder vh = new WeatherDetailViewHolder(view);
            vh.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            if (viewType == 0) {

                vh.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        itemClick(mWeatherRecyclerDetailList.get(vh.getPosition()).getWeatherTimeDetail());
                    }
                });
            }

            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            if (getItemViewType(position) == 0) {

                WeatherDetailViewHolder weatherDetailViewHolder = (WeatherDetailViewHolder) holder;
                weatherDetailViewHolder.setItem(mWeatherRecyclerDetailList.get(position).getWeatherTimeDetail());
            }
        }

        @Override
        public int getItemCount() {

            Log.d("///", "WeatherRecyclerDetail size: " + mWeatherRecyclerDetailList.size());
            return mWeatherRecyclerDetailList.size();
        }

        @Override
        public int getItemViewType(int position) {

            return mWeatherRecyclerDetailList.get(position).getViewType();
        }
    };

    /*=================================================================*/
    // Event
    /*=================================================================*/
    private void itemClick(WeatherTimeDetail detail) {

        WeatherDetailActivity.startActivity(WeatherActivity.this, detail);
    }

    /*=================================================================*/
    // Function
    /*=================================================================*/

    //同步氣象資訊
    private void syncWeather() {
        //顯示Loading
        showProgressDialog();

        Callback<SyncWeatherResult> apiCallback = new Callback<SyncWeatherResult>() {
            @Override
            public void onResponse(Call<SyncWeatherResult> call, Response<SyncWeatherResult> response) {

                hideProgressDialog();
                Log.d("///", "Success: " + new Gson().toJson(response.body()));

                if (TextUtils.equals(response.body().getStatus(), AppProperties.SUCCESS)) {

                    for (WeatherLocationDetail locationDetail : response.body().getRecordDetail().getWeatherLocationDetailList()) {

                        if (TextUtils.equals(locationDetail.getLocationName(), AppProperties.Location.TAIPEI)) {

                            for(WeatherElementDetail elementDetail : locationDetail.getWeatherElementDetailList()) {

                                if (TextUtils.equals(elementDetail.getElementName(), AppProperties.ElementName.MIN_TEMPERATURE)) {

                                    for (WeatherTimeDetail timeDetail : elementDetail.getWeatherTimeDetailList()) {

                                        WeatherRecyclerDetail typeADetail = new WeatherRecyclerDetail();
                                        typeADetail.setWeatherTimeDetail(timeDetail);
                                        typeADetail.setViewType(0);

                                        mWeatherRecyclerDetailList.add(typeADetail);

                                        WeatherRecyclerDetail typeBDetail = new WeatherRecyclerDetail();
                                        typeBDetail.setWeatherTimeDetail(timeDetail);
                                        typeBDetail.setViewType(1);

                                        mWeatherRecyclerDetailList.add(typeBDetail);
                                    }
                                }
                            }
                        }
                    }
                    Log.d("///", "recyclerview setAdapter");
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<SyncWeatherResult> call, Throwable t) {

                hideProgressDialog();
                Log.d("///", "Fail: " + t.getMessage());
            }
        };

        Map<String, String> locationMap = new HashMap<>();
        locationMap.put("locationName", AppProperties.Location.TAIPEI);

        AppDemoApplication
                .instance()
                .getDemoWeatherApiManager()
                .getApi()
                .callWeatherApi(AppProperties.WEATHER_AUTHORIZATION, locationMap)
                .enqueue(apiCallback);
    }
}
