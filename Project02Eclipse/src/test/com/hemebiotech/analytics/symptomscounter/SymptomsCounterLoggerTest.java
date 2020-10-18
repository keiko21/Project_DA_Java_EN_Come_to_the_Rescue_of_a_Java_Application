package test.com.hemebiotech.analytics.symptomscounter;

import com.hemebiotech.analytics.symptomscounter.SymptomsCounterLogger;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SymptomsCounterLoggerTest {

    @Test
    void should_add_conform_file_logger() throws IOException {
        new SymptomsCounterLogger();

        String creationFileDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
        final Path symptomsCounterFilePath = Paths.get(
                "Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/logs/SymptomsCounterLogger_"
                        + creationFileDate
                        + ".xml");

        assertEquals(
                SymptomsCounterLogger.class.getSimpleName()
                        + "_"
                        + creationFileDate
                        + ".xml",
                symptomsCounterFilePath.getFileName().toString()
        );

        new Scanner(symptomsCounterFilePath).close();
    }
}