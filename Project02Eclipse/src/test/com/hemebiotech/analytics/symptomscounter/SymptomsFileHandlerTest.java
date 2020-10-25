package test.com.hemebiotech.analytics.symptomscounter;

import com.hemebiotech.analytics.symptomscounter.SymptomsFileHandler;
import com.hemebiotech.analytics.symptomscounter.SymptomsHandler;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymptomsFileHandlerTest {

    @Test
    void shouldReadSymptomsFile() throws IOException {
        BufferedReader symptomsBufferedReader = new SymptomsFileHandler().readFile();
        List<String> symptomsLineList = symptomsBufferedReader.lines().collect(Collectors.toList());
        List<String> symptomsLineListDataTest = getLinesFromSymptomsDataTest("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/data/symptoms.txt");

        symptomsBufferedReader.close();

        assertEquals(symptomsLineListDataTest.size(), symptomsLineList.size());

        for (int line = 0; line < symptomsLineListDataTest.size(); line++) {
            assertEquals(symptomsLineListDataTest.get(line), symptomsLineList.get(line));
        }
    }

    @Test
    void writeFile() throws IOException {
        BufferedReader symptomsBufferedReaderDataTest = getBufferReaderFromFile("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/data/symptoms.txt");
        new SymptomsFileHandler().writeFile(SymptomsHandler.handle(symptomsBufferedReaderDataTest));
        symptomsBufferedReaderDataTest.close();

        List<String> resultsLineList = getLinesFromSymptomsDataTest("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/data/results.out");
        writeBufferWriterFromFile();
        List<String> resultsLineListDataTest = getLinesFromSymptomsDataTest("Project02Eclipse/src/test/com/hemebiotech/analytics/symptomscounter/data/results.out");

        for (int line = 0; line < resultsLineListDataTest.size(); line++) {
            assertEquals(resultsLineListDataTest.get(line), resultsLineList.get(line));
        }
    }

    private BufferedReader getBufferReaderFromFile(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath));
    }

    private void writeBufferWriterFromFile() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Project02Eclipse/src/test/com/hemebiotech/analytics/symptomscounter/data/results.out"));
        bufferedWriter.close();
    }

    private List<String> getLinesFromSymptomsDataTest(String filePath) throws IOException {
        BufferedReader bufferedReader = getBufferReaderFromFile(filePath);
        List<String> lines = bufferedReader.lines().collect(Collectors.toList());
        bufferedReader.close();

        return lines;
    }
}