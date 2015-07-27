package mooc.vandy.weatherapi_retrofit;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by muba on 7/24/15.
 */
public interface GetWeatherApi {
    @GET("/data/2.5/weather")
        //async
    void getWeatherAsync (
            @Query("q") String cityName,
            Callback<WeatherData> callback);
    @GET("/data/2.5/weather")
        //sync
    WeatherData getWeatherSync (
            @Query("q") String cityName);
}


