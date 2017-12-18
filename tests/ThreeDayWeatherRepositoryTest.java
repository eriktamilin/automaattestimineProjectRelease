import com.weather.WeatherRequest;
import com.weather.reports.ThreeDayWeatherReport;
import com.weather.repositories.ThreeDayWeatherRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
class ThreeDayWeatherRepositoryTest {
    @Test
    void checkThreeDayWeatherResponse() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", "EE", "metric");

            ThreeDayWeatherRepository repository = new ThreeDayWeatherRepository();

            ThreeDayWeatherReport report = repository.getThreeDayWeather(request);

            assertEquals(request.getCity(), report.getCity());
            assertEquals(request.getCode(), report.getCode());
            assertTrue(report.getTemperatures().size() == 3);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void checkThreeDayWeatherMockResponse() {
        try {
            WeatherRequest request = new WeatherRequest("Tallinn", "EE", "metric");

            ThreeDayWeatherRepository.mock();
            ThreeDayWeatherRepository repository = new ThreeDayWeatherRepository();

            ThreeDayWeatherReport report = repository.getThreeDayWeather(request);

            assertEquals(request.getCity(), report.getCity());
            assertEquals(request.getCode(), report.getCode());
            assertTrue(report.getTemperatures().size() == 3);
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}