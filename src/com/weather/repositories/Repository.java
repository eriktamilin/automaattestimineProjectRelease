package com.weather.repositories;

import com.weather.requests.WeatherRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
abstract public class Repository {
    private String url = "http://api.openweathermap.org/data/2.5";
    private String key = "e17e7c7a5086ae0d1f08f10bf0ee1ec3";

    protected static boolean mock = false;

    protected String getUrl(String resource, Map<String, String> params) {
        params.put("id", "524901");
        params.put("APPID", this.key);

        String query = "";

        for (Map.Entry<String, String> param: params.entrySet()) {
            if (query.length() != 0) {
                query += "&";
            }

            query += param.getKey() + "=" + param.getValue();
        }

        return this.url + resource + "?" + query;
    }


    protected String readUrl(String resource, Map<String, String> params) throws Exception {
        BufferedReader reader = null;

        try {
            URL url = new URL(this.getUrl(resource, params));
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();

            int read;
            char[] chars = new char[1024];

            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    public boolean isMock() {
        return mock;
    }

    public static void mock() {
        mock = true;
    }

    public abstract String getMockString(WeatherRequest request);
}
