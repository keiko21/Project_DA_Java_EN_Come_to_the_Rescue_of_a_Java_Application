package test.com.hemebiotech.analytics.symptomscounter;

import com.hemebiotech.analytics.Path;
import com.hemebiotech.analytics.symptomscounter.SymptomsHandler;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SymptomsHandlerTest {

    @Test
    void should_handle_symptoms_to_produce_counted_and_alphabetically_ordered_symptoms() throws FileNotFoundException {
        String[] symptomsHandled = SymptomsHandler.handle(getBufferReaderFromFile(Path.SYMPTOMS_FILE.getPath()));

        BufferedReader bufferedReaderDataTest = getBufferReaderFromFile(PathDataTest.RESULTS_OUT_FILE.getPath());
        String[] symptomsDataTest = bufferedReaderDataTest.lines().toArray(String[]::new);

        assertArrayEquals(symptomsDataTest, symptomsHandled);
    }

    private BufferedReader getBufferReaderFromFile(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }
}