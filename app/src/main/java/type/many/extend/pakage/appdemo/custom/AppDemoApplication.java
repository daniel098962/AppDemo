package type.many.extend.pakage.appdemo.custom;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.File;
import java.lang.ref.WeakReference;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import type.many.extend.pakage.appdemo.data.AppProperties;
import type.many.extend.pakage.appdemo.manager.DemoApiManager;

/**
 * Created by User on 2020/5/4.
 */

public class AppDemoApplication extends Application {

    /*=================================================================*/
    // Global
    /*=================================================================*/
    /** 初始化本體 */
    private static WeakReference<AppDemoApplication> Instance;
    public static AppDemoApplication instance(){
        if(Instance != null && Instance.get() != null) {
            return Instance.get();
        }
        else {
            return null;
        }
    }

    @Override
    public void onCreate() {

        super.onCreate();

        Instance = new WeakReference(this);

        //region 做硬碟緩衝
        {
            File cacheFile = this.getExternalCacheDir();

            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheInMemory(false)
                    .cacheOnDisk(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .displayer(new FadeInBitmapDisplayer(500))
                    .build();

            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
                    .memoryCacheExtraOptions(480, 800) // max width, max height
                    //.discCacheExtraOptions(480, 800, CompressFormat.JPEG, 75) // Can slow ImageLoader, use it carefully (Better don't use it)
                    .threadPoolSize(4) // 線程數量
                    .threadPriority(Thread.NORM_PRIORITY - 1) // 優先程級
                    .denyCacheImageMultipleSizesInMemory()
                    //.offOutOfMemoryHandling()
                    .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation
                    .diskCache(new UnlimitedDiskCache(cacheFile)) // You can pass your own disc cache implementation
                    .diskCacheSize(50 * 1024 * 1024)
                    .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                    .imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (20 s)
                    .defaultDisplayImageOptions(options)
                    //.enableLogging()
                    .build();
            ImageLoader.getInstance().init(config);
        }
        //endregion

        AppProperties.AppDemoShared.GLOBAL_SHARED = getSharedPreferences(AppProperties.AppDemoShared.SHARED_NAME, MODE_PRIVATE);
    }

    /**
     * API 管理員
     */
    private DemoApiManager mDemoApiManager;
    public DemoApiManager getDemoApiManager() {

        if(mDemoApiManager == null) {
            mDemoApiManager = new DemoApiManager(getRetrofit());
        }

        return mDemoApiManager;
    }

    /**
     * 中央氣象局 API 管理員
     */
    private DemoApiManager mDemoWeatherApiManager;
    public DemoApiManager getDemoWeatherApiManager() {

        if (mDemoWeatherApiManager == null) {
            mDemoWeatherApiManager = new DemoApiManager(getWeatherRetrofit());
        }

        return mDemoWeatherApiManager;
    }

    /**  網路 API 設定 */
    private Retrofit mRetrofit;
    public Retrofit getRetrofit() {

        if(mRetrofit == null) {
            mRetrofit = new Retrofit.Builder() // region ...
                    .baseUrl(AppProperties.PHOTO_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            // endregion
        }

        return mRetrofit;
    }

    /** 中央氣象局 API設定*/
    private Retrofit mWeatherRetrofit;
    public Retrofit getWeatherRetrofit() {

        if(mWeatherRetrofit == null) {
            mWeatherRetrofit = new Retrofit.Builder() // region ...
                    .baseUrl(AppProperties.WEATHER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            // endregion
        }

        return mWeatherRetrofit;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
