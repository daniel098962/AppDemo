package type.many.extend.pakage.appdemo.features.weather;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import type.many.extend.pakage.appdemo.R;
import type.many.extend.pakage.appdemo.data.AppProperties;
import type.many.extend.pakage.appdemo.data.model.WeatherTimeDetail;

public class WeatherDetailActivity extends AppCompatActivity {

    /*=================================================================*/
    // Global
    /*=================================================================*/

    //跳頁
    public static void startActivity(Context context, WeatherTimeDetail detail) {

        Intent intent = new Intent(context, WeatherDetailActivity.class);
        intent.putExtra(AppProperties.Intent.STRING, new Gson().toJson(detail));
        context.startActivity(intent);
    }

    /*=================================================================*/
    // Constructor
    /*=================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);

        //region View
        {
            mStartTimeTextView = findViewById(R.id.start_time_text_view);
            mEndTimeTextView = findViewById(R.id.end_time_text_view);
            mMinTempTextView = findViewById(R.id.min_temp_text_view);
        }
        //endregion

        //region Data
        {
            mWeatherTimeDetail = new Gson().fromJson(this.getIntent().getStringExtra(AppProperties.Intent.STRING), new TypeToken<WeatherTimeDetail>(){}.getType());

            mStartTimeTextView.setText(mWeatherTimeDetail.getStartTime());
            mEndTimeTextView.setText(mWeatherTimeDetail.getEndTime());
            mMinTempTextView.setText(mWeatherTimeDetail.getWeatherParameterDetail().getParameterName() + mWeatherTimeDetail.getWeatherParameterDetail().getParameterUnit());
        }
        //endregion

    }

    /*=================================================================*/
    // View
    /*=================================================================*/
    private TextView mStartTimeTextView;
    private TextView mEndTimeTextView;
    private TextView mMinTempTextView;

    /*=================================================================*/
    // Data
    /*=================================================================*/
    private WeatherTimeDetail mWeatherTimeDetail;
}
