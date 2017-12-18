import utils.FileHandler;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Erik Tamilin on 17.12.2017.
 */
class FileHandlerTest {

    @Test
    void testReadAndWrite() {
        FileHandler fh = new FileHandler();

        String cityWithCode = "Tallinn,EE";

        try {
            String name = "test.txt";

            fh.write(new ArrayList<>(Arrays.asList(cityWithCode)), name);
            List<String> lines = fh.read(name);

            assertEquals("Tallinn,EE", lines.get(0));

            fh.delete(name);
        } catch (IOException e) {
            fail("Failure cause: " + e.getMessage());
        }
    }

    @Test
    void testReadAndWriteWithMock() {
        FileHandler fh = new FileHandler();

        FileHandler.mock();

        try {
            List<String> lines = fh.read("inputMock.txt");

            assertEquals("Tallinn,EE", lines.get(0));
            assertEquals("London,GB", lines.get(1));
            assertTrue(fh.write(lines, "inputMock.txt"));
            assertTrue(fh.delete("inputMock.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}