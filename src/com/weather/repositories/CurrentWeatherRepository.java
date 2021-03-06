package com.weather.repositories;

import org.json.*;
import com.weather.requests.WeatherRequest;
import com.weather.reports.CurrentWeatherReport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
public class CurrentWeatherRepository extends Repository {
    public CurrentWeatherReport getCurrentWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("q", request.getCity() + "," + request.getCode());
        params.put("units", request.getUnits());

        if(! this.isMock()) {
            String response = this.readUrl("/weather", params);
            return new CurrentWeatherReport(new JSONObject(response));
        }
        else {
            String response = this.getMockString(request);;
            return new CurrentWeatherReport(new JSONObject(response));
        }
    }

    @Override
    public String getMockString(WeatherRequest request) {
        return "{\"coord\":{\"lon\":24.75,\"lat\":59.44},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":1,\"pressure\":1001,\"humidity\":100,\"temp_min\":1,\"temp_max\":1},\"visibility\":9000,\"wind\":{\"speed\":2.6,\"deg\":160},\"clouds\":{\"all\":90},\"dt\":1513439400,\"sys\":{\"type\":1,\"id\":5014,\"message\":0.0022,\"country\":\"" + request.getCode() + "\",\"sunrise\":1513408478,\"sunset\":1513430357},\"id\":590447,\"name\":\"" + request.getCity() + "\",\"cod\":200}";
    }
}
