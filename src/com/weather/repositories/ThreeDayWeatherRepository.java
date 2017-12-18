package com.weather.repositories;

import org.json.*;
import com.weather.requests.WeatherRequest;
import com.weather.reports.ThreeDayWeatherReport;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
public class ThreeDayWeatherRepository extends Repository {
    public ThreeDayWeatherReport getThreeDayWeather(WeatherRequest request) throws Exception {
        Map<String, String> params = new HashMap<String, String>();

        params.put("q", request.getCity() + "," + request.getCode());
        params.put("units", request.getUnits());

        if(!this.isMock()){
            String response = this.readUrl("/forecast", params);
            return new ThreeDayWeatherReport(new JSONObject(response));
        }
        else {
            String response = this.getMockString(request);
            return new ThreeDayWeatherReport(new JSONObject(response));
        }
    }

    @Override
    public String getMockString(WeatherRequest request) {
        return "{\"cod\":\"200\",\"message\":0.0027,\"cnt\":40,\"list\":[{\"dt\":1513447200,\"main\":{\"temp\":-0.32,\"temp_min\":-0.32,\"temp_max\":0.01,\"pressure\":1011.22,\"sea_level\":1014.76,\"grnd_level\":1011.22,\"humidity\":100,\"temp_kf\":-0.32},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":48},\"wind\":{\"speed\":3.27,\"deg\":178.003},\"rain\":{\"3h\":0.0075},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-16 18:00:00\"},{\"dt\":1513458000,\"main\":{\"temp\":-1.5,\"temp_min\":-1.5,\"temp_max\":-1.26,\"pressure\":1011.79,\"sea_level\":1015.4,\"grnd_level\":1011.79,\"humidity\":100,\"temp_kf\":-0.24},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":1.65,\"deg\":180.005},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-16 21:00:00\"},{\"dt\":1513468800,\"main\":{\"temp\":-1.49,\"temp_min\":-1.49,\"temp_max\":-1.34,\"pressure\":1012.41,\"sea_level\":1015.96,\"grnd_level\":1012.41,\"humidity\":100,\"temp_kf\":-0.16},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":1.51,\"deg\":190.501},\"rain\":{\"3h\":0.015},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-17 00:00:00\"},{\"dt\":1513479600,\"main\":{\"temp\":-0.58,\"temp_min\":-0.58,\"temp_max\":-0.51,\"pressure\":1013.12,\"sea_level\":1016.78,\"grnd_level\":1013.12,\"humidity\":100,\"temp_kf\":-0.08},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":1.51,\"deg\":238.001},\"rain\":{\"3h\":0.155},\"snow\":{\"3h\":0.00225},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-17 03:00:00\"},{\"dt\":1513490400,\"main\":{\"temp\":0.69,\"temp_min\":0.69,\"temp_max\":0.69,\"pressure\":1014.42,\"sea_level\":1018.01,\"grnd_level\":1014.42,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":1.12,\"deg\":280.003},\"rain\":{\"3h\":0.155},\"snow\":{\"3h\":0.06625},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-17 06:00:00\"},{\"dt\":1513501200,\"main\":{\"temp\":1.54,\"temp_min\":1.54,\"temp_max\":1.54,\"pressure\":1016.3,\"sea_level\":1019.95,\"grnd_level\":1016.3,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":600,\"main\":\"Snow\",\"description\":\"light snow\",\"icon\":\"13d\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":1.61,\"deg\":297.002},\"rain\":{},\"snow\":{\"3h\":0.42375},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-17 09:00:00\"},{\"dt\":1513512000,\"main\":{\"temp\":0.72,\"temp_min\":0.72,\"temp_max\":0.72,\"pressure\":1017.99,\"sea_level\":1021.67,\"grnd_level\":1017.99,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01d\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":2.43,\"deg\":311},\"rain\":{},\"snow\":{\"3h\":0.0037500000000001},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-17 12:00:00\"},{\"dt\":1513522800,\"main\":{\"temp\":-0.75,\"temp_min\":-0.75,\"temp_max\":-0.75,\"pressure\":1020.31,\"sea_level\":1024.02,\"grnd_level\":1020.31,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":20},\"wind\":{\"speed\":3.46,\"deg\":305.002},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-17 15:00:00\"},{\"dt\":1513533600,\"main\":{\"temp\":-3.54,\"temp_min\":-3.54,\"temp_max\":-3.54,\"pressure\":1022.27,\"sea_level\":1025.99,\"grnd_level\":1022.27,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":2.61,\"deg\":294.002},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-17 18:00:00\"},{\"dt\":1513544400,\"main\":{\"temp\":-5.11,\"temp_min\":-5.11,\"temp_max\":-5.11,\"pressure\":1023.99,\"sea_level\":1027.62,\"grnd_level\":1023.99,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":2.02,\"deg\":246.002},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-17 21:00:00\"},{\"dt\":1513555200,\"main\":{\"temp\":-4.9,\"temp_min\":-4.9,\"temp_max\":-4.9,\"pressure\":1025.38,\"sea_level\":1029.03,\"grnd_level\":1025.38,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":56},\"wind\":{\"speed\":3,\"deg\":201.505},\"rain\":{\"3h\":0.02},\"snow\":{\"3h\":0.015},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-18 00:00:00\"},{\"dt\":1513566000,\"main\":{\"temp\":-1.8,\"temp_min\":-1.8,\"temp_max\":-1.8,\"pressure\":1026.34,\"sea_level\":1030.04,\"grnd_level\":1026.34,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":68},\"wind\":{\"speed\":4.46,\"deg\":196.5},\"rain\":{\"3h\":0.03},\"snow\":{\"3h\":0.0075000000000001},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-18 03:00:00\"},{\"dt\":1513576800,\"main\":{\"temp\":-0.42,\"temp_min\":-0.42,\"temp_max\":-0.42,\"pressure\":1027.68,\"sea_level\":1031.34,\"grnd_level\":1027.68,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":4.43,\"deg\":195.003},\"rain\":{\"3h\":0.02},\"snow\":{\"3h\":0.01},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-18 06:00:00\"},{\"dt\":1513587600,\"main\":{\"temp\":0.1,\"temp_min\":0.1,\"temp_max\":0.1,\"pressure\":1029.17,\"sea_level\":1032.83,\"grnd_level\":1029.17,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":4.66,\"deg\":190},\"rain\":{\"3h\":0.03},\"snow\":{\"3h\":0.0175},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-18 09:00:00\"},{\"dt\":1513598400,\"main\":{\"temp\":0.85,\"temp_min\":0.85,\"temp_max\":0.85,\"pressure\":1029.72,\"sea_level\":1033.28,\"grnd_level\":1029.72,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":80},\"wind\":{\"speed\":3.46,\"deg\":202.007},\"rain\":{\"3h\":0.01},\"snow\":{\"3h\":0.0075000000000001},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-18 12:00:00\"},{\"dt\":1513609200,\"main\":{\"temp\":-1.51,\"temp_min\":-1.51,\"temp_max\":-1.51,\"pressure\":1030.65,\"sea_level\":1034.32,\"grnd_level\":1030.65,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":20},\"wind\":{\"speed\":3.41,\"deg\":185.002},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-18 15:00:00\"},{\"dt\":1513620000,\"main\":{\"temp\":-2.84,\"temp_min\":-2.84,\"temp_max\":-2.84,\"pressure\":1031.49,\"sea_level\":1035.19,\"grnd_level\":1031.49,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.21,\"deg\":182.504},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-18 18:00:00\"},{\"dt\":1513630800,\"main\":{\"temp\":-3.94,\"temp_min\":-3.94,\"temp_max\":-3.94,\"pressure\":1032.01,\"sea_level\":1035.63,\"grnd_level\":1032.01,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.35,\"deg\":187.501},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-18 21:00:00\"},{\"dt\":1513641600,\"main\":{\"temp\":-3.45,\"temp_min\":-3.45,\"temp_max\":-3.45,\"pressure\":1032.28,\"sea_level\":1035.95,\"grnd_level\":1032.28,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":12},\"wind\":{\"speed\":4.82,\"deg\":195.001},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-19 00:00:00\"},{\"dt\":1513652400,\"main\":{\"temp\":-1.99,\"temp_min\":-1.99,\"temp_max\":-1.99,\"pressure\":1032.54,\"sea_level\":1036.28,\"grnd_level\":1032.54,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":4.07,\"deg\":194.003},\"rain\":{\"3h\":0.03},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-19 03:00:00\"},{\"dt\":1513663200,\"main\":{\"temp\":0.39,\"temp_min\":0.39,\"temp_max\":0.39,\"pressure\":1033.03,\"sea_level\":1036.74,\"grnd_level\":1033.03,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":4.06,\"deg\":204.501},\"rain\":{\"3h\":0.23},\"snow\":{\"3h\":0.0675},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-19 06:00:00\"},{\"dt\":1513674000,\"main\":{\"temp\":1.51,\"temp_min\":1.51,\"temp_max\":1.51,\"pressure\":1034.26,\"sea_level\":1038,\"grnd_level\":1034.26,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":2.46,\"deg\":237.503},\"rain\":{\"3h\":0.08},\"snow\":{\"3h\":0.05},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-19 09:00:00\"},{\"dt\":1513684800,\"main\":{\"temp\":1.79,\"temp_min\":1.79,\"temp_max\":1.79,\"pressure\":1035.45,\"sea_level\":1039.13,\"grnd_level\":1035.45,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":2.71,\"deg\":275.503},\"rain\":{\"3h\":0.01},\"snow\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-19 12:00:00\"},{\"dt\":1513695600,\"main\":{\"temp\":1.27,\"temp_min\":1.27,\"temp_max\":1.27,\"pressure\":1036.34,\"sea_level\":1040.01,\"grnd_level\":1036.34,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":2.77,\"deg\":252.001},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-19 15:00:00\"},{\"dt\":1513706400,\"main\":{\"temp\":0.5,\"temp_min\":0.5,\"temp_max\":0.5,\"pressure\":1036.88,\"sea_level\":1040.61,\"grnd_level\":1036.88,\"humidity\":99,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":3.91,\"deg\":244.505},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-19 18:00:00\"},{\"dt\":1513717200,\"main\":{\"temp\":-1.13,\"temp_min\":-1.13,\"temp_max\":-1.13,\"pressure\":1037.04,\"sea_level\":1040.75,\"grnd_level\":1037.04,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":4.31,\"deg\":234.508},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-19 21:00:00\"},{\"dt\":1513728000,\"main\":{\"temp\":0.15,\"temp_min\":0.15,\"temp_max\":0.15,\"pressure\":1036.8,\"sea_level\":1040.49,\"grnd_level\":1036.8,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":0},\"wind\":{\"speed\":5.79,\"deg\":243.503},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-20 00:00:00\"},{\"dt\":1513738800,\"main\":{\"temp\":0.74,\"temp_min\":0.74,\"temp_max\":0.74,\"pressure\":1036.16,\"sea_level\":1039.82,\"grnd_level\":1036.16,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":6.42,\"deg\":230.503},\"rain\":{\"3h\":0.02},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-20 03:00:00\"},{\"dt\":1513749600,\"main\":{\"temp\":1.31,\"temp_min\":1.31,\"temp_max\":1.31,\"pressure\":1034.58,\"sea_level\":1038.19,\"grnd_level\":1034.58,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":68},\"wind\":{\"speed\":7.31,\"deg\":222.005},\"rain\":{\"3h\":0.0099999999999998},\"snow\":{\"3h\":0.0225},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-20 06:00:00\"},{\"dt\":1513760400,\"main\":{\"temp\":2.45,\"temp_min\":2.45,\"temp_max\":2.45,\"pressure\":1032.74,\"sea_level\":1036.46,\"grnd_level\":1032.74,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":80},\"wind\":{\"speed\":7.65,\"deg\":224.502},\"rain\":{\"3h\":0.14},\"snow\":{\"3h\":0.0125},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-20 09:00:00\"},{\"dt\":1513771200,\"main\":{\"temp\":3.29,\"temp_min\":3.29,\"temp_max\":3.29,\"pressure\":1030.5,\"sea_level\":1034.12,\"grnd_level\":1030.5,\"humidity\":98,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":7.71,\"deg\":227.001},\"rain\":{\"3h\":0.38},\"snow\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-20 12:00:00\"},{\"dt\":1513782000,\"main\":{\"temp\":3.76,\"temp_min\":3.76,\"temp_max\":3.76,\"pressure\":1028.26,\"sea_level\":1031.92,\"grnd_level\":1028.26,\"humidity\":98,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":7.36,\"deg\":230.508},\"rain\":{\"3h\":0.61},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-20 15:00:00\"},{\"dt\":1513792800,\"main\":{\"temp\":4.61,\"temp_min\":4.61,\"temp_max\":4.61,\"pressure\":1026.4,\"sea_level\":1030.05,\"grnd_level\":1026.4,\"humidity\":95,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":6.75,\"deg\":247.001},\"rain\":{\"3h\":0.38},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-20 18:00:00\"},{\"dt\":1513803600,\"main\":{\"temp\":4.61,\"temp_min\":4.61,\"temp_max\":4.61,\"pressure\":1025.88,\"sea_level\":1029.41,\"grnd_level\":1025.88,\"humidity\":96,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.91,\"deg\":284.002},\"rain\":{\"3h\":0.19},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-20 21:00:00\"},{\"dt\":1513814400,\"main\":{\"temp\":3.78,\"temp_min\":3.78,\"temp_max\":3.78,\"pressure\":1026.76,\"sea_level\":1030.32,\"grnd_level\":1026.76,\"humidity\":98,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":5.66,\"deg\":317.502},\"rain\":{\"3h\":0.04},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-21 00:00:00\"},{\"dt\":1513825200,\"main\":{\"temp\":3.05,\"temp_min\":3.05,\"temp_max\":3.05,\"pressure\":1027.62,\"sea_level\":1031.21,\"grnd_level\":1027.62,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":64},\"wind\":{\"speed\":4.81,\"deg\":332.004},\"rain\":{\"3h\":0.08},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-21 03:00:00\"},{\"dt\":1513836000,\"main\":{\"temp\":0.42,\"temp_min\":0.42,\"temp_max\":0.42,\"pressure\":1027.27,\"sea_level\":1030.93,\"grnd_level\":1027.27,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"02n\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":2.41,\"deg\":321.006},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-21 06:00:00\"},{\"dt\":1513846800,\"main\":{\"temp\":-0.85,\"temp_min\":-0.85,\"temp_max\":-0.85,\"pressure\":1026.34,\"sea_level\":1030.05,\"grnd_level\":1026.34,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"clouds\":{\"all\":24},\"wind\":{\"speed\":1.87,\"deg\":218.006},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-21 09:00:00\"},{\"dt\":1513857600,\"main\":{\"temp\":0.59,\"temp_min\":0.59,\"temp_max\":0.59,\"pressure\":1023.51,\"sea_level\":1027.14,\"grnd_level\":1023.51,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":44},\"wind\":{\"speed\":4.66,\"deg\":194.003},\"rain\":{},\"snow\":{},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2017-12-21 12:00:00\"},{\"dt\":1513868400,\"main\":{\"temp\":1.33,\"temp_min\":1.33,\"temp_max\":1.33,\"pressure\":1019.01,\"sea_level\":1022.58,\"grnd_level\":1019.01,\"humidity\":100,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":92},\"wind\":{\"speed\":5.81,\"deg\":166.012},\"rain\":{\"3h\":0.64},\"snow\":{},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2017-12-21 15:00:00\"}],\"city\":{\"id\":590447,\"name\":\"" + request.getCity() + "\",\"coord\":{\"lat\":59.4372,\"lon\":24.7454},\"country\":\"" + request.getCode() + "\",\"population\":16630}}";
    }
}
