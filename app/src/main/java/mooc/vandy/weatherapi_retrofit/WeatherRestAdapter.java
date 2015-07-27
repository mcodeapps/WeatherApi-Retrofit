package mooc.vandy.weatherapi_retrofit;

import android.util.Log;

import retrofit.Callback;
import retrofit.RestAdapter;


/**
 * Created by muba on 7/24/15.
 */
public class WeatherRestAdapter {
    protected final String TAG = getClass().getSimpleName();
    protected RestAdapter mRestAdapter;
    protected GetWeatherApi mApi;
    static final String WEATHER_URL="http://api.openweathermap.org";

    public WeatherRestAdapter() {
        mRestAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(WEATHER_URL)
                .setErrorHandler(new WeatherApiErrorHandler())
                .build();
        mApi = mRestAdapter.create(GetWeatherApi.class); // create the interface
        Log.d(TAG, "GetWeatherRestAdapter -- created");
    }

    public void WeatherApiAsync(String city, Callback<WeatherData> callback){
        Log.d(TAG, "testWeatherApi: for city:" + city);
        mApi.getWeatherAsync(city, callback);
    }

    public WeatherData WeatherApiSync(String city) {
        WeatherData result=null;
        Log.d(TAG, "testWeatherApi: for city:" + city);
        result = mApi.getWeatherSync(city);
        return result;
    }
}