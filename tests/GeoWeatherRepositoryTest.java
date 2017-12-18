import com.weather.requests.WeatherRequest;
import com.weather.reports.GeoWeatherReport;
import com.weather.repositories.GeoWeatherRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
class GeoWeatherRepositoryTest {
    @Test
    void checkGeoWeatherResponse() {
        try {
            WeatherRequest request = new WeatherRequest(50.0, 100.0, "metric");

            GeoWeatherRepository repository = new GeoWeatherRepository();

            GeoWeatherReport report = repository.getGeoWeather(request);

            assertEquals(request.getLatitude(), report.getLatitude());
            assertEquals(request.getLongtitude(), report.getLongtitude());
            assertNotNull(report.getCurrentTemperature());
            assertNotNull(report.getMaximumTemperature());
            assertNotNull(report.getMinimalTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void checkGeoWeatherMockResponse() {
        try {
            WeatherRequest request = new WeatherRequest(50.0, 100.0, "metric");

            GeoWeatherRepository.mock();
            GeoWeatherRepository repository = new GeoWeatherRepository();

            GeoWeatherReport report = repository.getGeoWeather(request);

            assertEquals(request.getLatitude(), report.getLatitude());
            assertEquals(request.getLongtitude(), report.getLongtitude());
            assertNotNull(report.getCurrentTemperature());
            assertNotNull(report.getMaximumTemperature());
            assertNotNull(report.getMinimalTemperature());
        } catch (Exception e) {
            fail("Failure cause: " + e.getMessage());
        }
    }
}