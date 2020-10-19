package com.hemebiotech.analytics.symptomscounter;

import com.hemebiotech.analytics.FileHandler;

import java.io.*;
import java.util.logging.Level;

/**
 * File handler specific to symptoms counter that implements {@link FileHandler} methods.
 *
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public class SymptomsFileHandler implements FileHandler {
    private static final String dataDirectoryPath = "Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/data/";
    private static final String symptomsDataFile = "symptoms.txt";

    private static final SymptomsCounterLogger logger = new SymptomsCounterLogger();

    private static BufferedWriter tryWritingFile() {
        BufferedWriter bufferedWriter = null;
        try {
            Writer writer = new FileWriter(dataDirectoryPath + "results.out");
            bufferedWriter = new BufferedWriter(writer);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Cannot write result file into " + dataDirectoryPath + ". Please check the path.", e);
        }
        return bufferedWriter;
    }

    private static void tryWritingLineIntoFile(BufferedWriter bufferedWriter, String lineToWrite) {
        try {
            bufferedWriter.write(lineToWrite + "\n");
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Cannot write lines into result file " + dataDirectoryPath + ". Please check lines.", e);
        }
    }

    private static void tryClosingFile(Object reader) {
        try {
            if (reader != null) {
                ((Closeable) reader).close();
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Trying to close the " + symptomsDataFile + " file but treatment is not done.", e);
        }
    }

    /**
     * Read symptoms file from symptoms file path.
     *
     * @return the buffered reader.
     */
    @Override
    public BufferedReader readFile() {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(dataDirectoryPath + symptomsDataFile));
        } catch (FileNotFoundException e) {
            logger.log(Level.SEVERE, "Please check if file is in path: " + dataDirectoryPath + symptomsDataFile, e);
        }
        return reader;
    }

    /**
     * Write symptoms file with {@link BufferedWriter}.
     *
     * @param linesToWrite the lines to write
     */
    @Override
    public void writeFile(String[] linesToWrite) {
        BufferedWriter bufferedWriter = tryWritingFile();

        for (String lineToWrite : linesToWrite) {
            tryWritingLineIntoFile(bufferedWriter, lineToWrite);
        }
        tryClosingFile(bufferedWriter);
    }
}
