package type.many.extend.pakage.appdemo.data;

/**
 * Created by User on 2020/5/4.
 */

import android.content.SharedPreferences;

/**
 * 專案常用屬性
 */
public class AppProperties {

    public static String SLASH = "/";
    public static String COMMA = ",";

    public static String PHOTO_BASE_URL = "https://jsonplaceholder.typicode.com/";
    public static String WEATHER_BASE_URL = "https://opendata.cwb.gov.tw/api/";

    public static String WEATHER_AUTHORIZATION = "CWB-51E04758-25CD-4F00-B5AA-498BAC533606";

    public static String PLACEHOLDER_IMAGE_URL = "https://via.placeholder.com/";
    public static String IPSUNIMAGE_URL = "https://ipsumimage.appspot.com/";

    public static String SUCCESS = "true";

    public static class Intent {

        public static String STRING = "intenT_sTring";
    }

    public static class Location {

        public static String TAIPEI = "臺北市";
    }

    public static class ElementName {

        public static String MIN_TEMPERATURE = "MinT";
    }

    public static class AppDemoShared {

        public static SharedPreferences GLOBAL_SHARED;
        public static String SHARED_NAME = "AppDemo_Shared";
        public static String FIRST_TIME_OPEN = "firsT_timE_opeN";
    }
}
