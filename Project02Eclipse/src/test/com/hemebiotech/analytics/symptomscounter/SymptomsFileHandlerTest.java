package test.com.hemebiotech.analytics.symptomscounter;

import com.hemebiotech.analytics.Path;
import com.hemebiotech.analytics.symptomscounter.SymptomsFileHandler;
import com.hemebiotech.analytics.symptomscounter.SymptomsHandler;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymptomsFileHandlerTest {

    @Test
    void should_read_symptoms_file() throws IOException {
        BufferedReader symptomsBufferedReader = new SymptomsFileHandler().readFile();
        List<String> symptomsLineList = symptomsBufferedReader.lines().collect(Collectors.toList());
        List<String> symptomsLineListDataTest = getLinesFromSymptoms(Path.SYMPTOMS_FILE.getPath());

        symptomsBufferedReader.close();

        assertEquals(symptomsLineListDataTest.size(), symptomsLineList.size());

        for (int line = 0; line < symptomsLineListDataTest.size(); line++) {
            assertEquals(symptomsLineListDataTest.get(line), symptomsLineList.get(line));
        }
    }

    @Test
    void should_write_results_file() throws IOException {
        BufferedReader symptomsBufferedReaderDataTest = getBufferReaderFromFile(Path.SYMPTOMS_FILE.getPath());
        new SymptomsFileHandler().writeFile(SymptomsHandler.handle(symptomsBufferedReaderDataTest));
        symptomsBufferedReaderDataTest.close();

        List<String> resultsLineList = getLinesFromSymptoms(Path.RESULTS_OUT_FILE.getPath());
        List<String> resultsLineListDataTest = getLinesFromSymptoms(PathDataTest.RESULTS_OUT_FILE.getPath());

        assertEquals(resultsLineListDataTest.size(), resultsLineList.size());

        for (int line = 0; line < resultsLineListDataTest.size(); line++) {
            assertEquals(resultsLineListDataTest.get(line), resultsLineList.get(line));
        }
    }

    private BufferedReader getBufferReaderFromFile(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }

    private List<String> getLinesFromSymptoms(String filePath) throws IOException {
        BufferedReader bufferedReader = getBufferReaderFromFile(filePath);
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        return lines;
    }
}