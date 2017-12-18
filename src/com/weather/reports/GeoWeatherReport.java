package com.weather.reports;

import org.json.JSONObject;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
public class GeoWeatherReport extends Report {
    public GeoWeatherReport(JSONObject json) {
        this.city = json.getString("name");
        this.code = json.getJSONObject("sys").getString("country");

        this.latitude = json.getJSONObject("coord").getDouble("lat");
        this.longtitude = json.getJSONObject("coord").getDouble("lon");

        this.currentTemperature = json.getJSONObject("main").getDouble("temp");
        this.minimalTemperature = json.getJSONObject("main").getDouble("temp_min");
        this.maximumTemperature = json.getJSONObject("main").getDouble("temp_max");
    }
}
