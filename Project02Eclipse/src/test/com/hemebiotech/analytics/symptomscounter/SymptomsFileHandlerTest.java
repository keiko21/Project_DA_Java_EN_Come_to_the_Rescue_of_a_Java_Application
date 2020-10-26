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
    void shouldReadSymptomsFile() throws IOException {
        BufferedReader symptomsBufferedReader = new SymptomsFileHandler().readFile();
        List<String> symptomsLineList = symptomsBufferedReader.lines().collect(Collectors.toList());
        List<String> symptomsLineListDataTest = getLinesFromSymptoms(Path.DATA_SYMPTOMS.getPath());

        symptomsBufferedReader.close();

        assertEquals(symptomsLineListDataTest.size(), symptomsLineList.size());

        for (int line = 0; line < symptomsLineListDataTest.size(); line++) {
            assertEquals(symptomsLineListDataTest.get(line), symptomsLineList.get(line));
        }
    }

    @Test
    void writeFile() throws IOException {
        BufferedReader symptomsBufferedReaderDataTest = getBufferReaderFromFile(Path.DATA_SYMPTOMS.getPath());
        new SymptomsFileHandler().writeFile(SymptomsHandler.handle(symptomsBufferedReaderDataTest));
        symptomsBufferedReaderDataTest.close();

        List<String> resultsLineList = getLinesFromSymptoms(Path.DATA_RESULTS_OUT.getPath());
        List<String> resultsLineListDataTest = getLinesFromSymptoms(PathDataTest.DATA_RESULTS_OUT.getPath());

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