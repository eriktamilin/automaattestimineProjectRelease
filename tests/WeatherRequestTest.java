import com.weather.requests.WeatherRequest;
import com.weather.reports.ThreeDayWeatherReport;
import com.weather.repositories.ThreeDayWeatherRepository;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
class WeatherRequestTest {

    @Test
    void testRequestFromFile() {
        try {
            List<WeatherRequest> requests = WeatherRequest.requestsFromFile();

            requests.forEach(request -> {
                request.setUnits("metric");

                ThreeDayWeatherRepository threeDayWeatherRepository = new ThreeDayWeatherRepository();

                try {
                    ThreeDayWeatherReport report = threeDayWeatherRepository.getThreeDayWeather(request);

                    report.writeToFile();
                } catch (Exception e) {
                    fail("Failure cause: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testRequestFromMockFile() {
        try {
            List<WeatherRequest> requests = WeatherRequest.requestsFromFile();

            requests.forEach(request -> {
                request.setUnits("metric");

                ThreeDayWeatherRepository.mock();
                ThreeDayWeatherRepository threeDayWeatherRepository = new ThreeDayWeatherRepository();

                try {
                    ThreeDayWeatherReport report = threeDayWeatherRepository.getThreeDayWeather(request);

                    report.writeToFile();
                } catch (Exception e) {
                    fail("Failure cause: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testRequestFromConsole() {
        String data = "Tallinn,EE";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        WeatherRequest request = WeatherRequest.requestFromConsole();

        assertEquals("Tallinn", request.getCity());
        assertEquals("EE", request.getCode());
    }
}