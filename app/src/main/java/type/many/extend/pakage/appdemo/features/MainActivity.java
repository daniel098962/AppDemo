package type.many.extend.pakage.appdemo.features;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import type.many.extend.pakage.appdemo.R;
import type.many.extend.pakage.appdemo.data.AppProperties;
import type.many.extend.pakage.appdemo.features.photo.GridViewActivity;
import type.many.extend.pakage.appdemo.features.weather.WeatherActivity;

public class MainActivity extends AppCompatActivity {

    /*=================================================================*/
    // Constructor
    /*=================================================================*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //region view
        {
            mPhotoPageButton = findViewById(R.id.next_page_button);
        }
        //endregion

        //region Data
        {
            if (AppProperties.AppDemoShared.GLOBAL_SHARED.getBoolean(AppProperties.AppDemoShared.FIRST_TIME_OPEN, true)) {

                AppProperties.AppDemoShared.GLOBAL_SHARED.edit().putBoolean(AppProperties.AppDemoShared.FIRST_TIME_OPEN, false).commit();
            } else {

                Toast.makeText(MainActivity.this, "歡迎回來", Toast.LENGTH_SHORT).show();
            }
        }
        //endregion

        //region Event
        {
            //圖片頁 點擊監聽事件
            mPhotoPageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    GridViewActivity.startActivity(MainActivity.this);
                }
            });

            //氣象頁 點擊監聽事件
            findViewById(R.id.weather_button).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    WeatherActivity.startActivity(MainActivity.this);
                }
            });
        }
        //endregion
    }

     /*=================================================================*/
    // View
    /*=================================================================*/
    private Button mPhotoPageButton;     //下一頁按鈕

    /*=================================================================*/
    // Data
    /*=================================================================*/

     /*=================================================================*/
    // Function
    /*=================================================================*/
}
