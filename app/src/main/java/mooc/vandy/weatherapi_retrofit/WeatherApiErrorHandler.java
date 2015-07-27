package mooc.vandy.weatherapi_retrofit;

import android.util.Log;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by muba on 7/24/15.
 */
public class WeatherApiErrorHandler implements retrofit.ErrorHandler {
    protected final String TAG = getClass().getSimpleName();
    @Override
    public Throwable handleError(RetrofitError cause) {
        Response r = cause.getResponse();
        if (r != null && r.getStatus() == 401) {
            Log.e(TAG, "Error:", cause);
        }
        return cause;

    }
}
