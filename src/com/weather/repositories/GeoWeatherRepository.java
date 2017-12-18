package com.weather.repositories;

import org.json.*;
import com.weather.WeatherRequest;
import com.weather.reports.GeoWeatherReport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
public class GeoWeatherRepository extends Repository {
    public GeoWeatherReport getGeoWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("lat", String.valueOf(request.getLatitude()));
        params.put("lon", String.valueOf(request.getLongtitude()));
        params.put("units", request.getUnits());

        if(! this.isMock()) {
            String response = this.readUrl("/weather", params);
            return new GeoWeatherReport(new JSONObject(response));
        }
        else {
            String response = this.getMockString(request);
            return new GeoWeatherReport(new JSONObject(response));
        }

    }

    @Override
    public String getMockString(WeatherRequest request) {
        return "{\"coord\":{\"lon\":" + request.getLongtitude() + ",\"lat\":" + request.getLatitude() + "},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"base\":\"stations\",\"main\":{\"temp\":281.461,\"pressure\":1025.65,\"humidity\":100,\"temp_min\":281.461,\"temp_max\":281.461,\"sea_level\":1035.44,\"grnd_level\":1025.65},\"wind\":{\"speed\":3.46,\"deg\":58.5011},\"clouds\":{\"all\":36},\"dt\":1513531446,\"sys\":{\"message\":0.0022,\"country\":\"JP\",\"sunrise\":1513460765,\"sunset\":1513496077},\"id\":1851632,\"name\":\"Shuzenji\",\"cod\":200}";
    }
}
