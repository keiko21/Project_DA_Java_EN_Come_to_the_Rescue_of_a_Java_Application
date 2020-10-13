package com.hemebiotech.analytics;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AnalyticsCounter {
	private static final Logger logger = Logger.getLogger(AnalyticsCounter.class.getName());
	private static final String dataDirectoryPath = "Project02Eclipse/src/com/hemebiotech/analytics/data/";
	private static final String symptomsDataFile = "symptoms.txt";
	private static int headacheCount = 0;
	private static int rashCount = 0;
	private static int pupilCount = 0;

	public static void main(String[] args) {
		addFileLogger();

		BufferedReader reader = tryReadingFile();
		treatReadingLines(reader);
		tryClosingFile(reader);

		FileWriter writer = generateOutput();
		tryClosingFile(writer);

		Arrays.stream(logger.getHandlers()).findFirst().ifPresent(Handler::close);
	}

	private static FileWriter generateOutput() {
		FileWriter writer = tryWritingFile();
		try {
			if (writer != null) {
				writer.write("headache: " + headacheCount + "\n");
				writer.write("rash: " + rashCount + "\n");
				writer.write("dialated pupils: " + pupilCount + "\n");
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot write result sentence.", e);
		}
		return writer;
	}

	private static FileWriter tryWritingFile() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(dataDirectoryPath + "result.out");
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Cannot write result file into " + dataDirectoryPath + ". Please check the path.", e);
		}
		return writer;
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

	private static void treatReadingLines(BufferedReader reader) {
		String line = null;
		do {
			line = tryReadingLines(reader, line);
			if (line != null) {
				if (line.equals("headache")) {
					headacheCount++;
				} else if (line.equals("rash")) {
					rashCount++;
				} else if (line.contains("dialated pupils")) {
					pupilCount++;
				}
			}
		} while (line != null);
	}

	private static String tryReadingLines(BufferedReader reader, String line) {
		if (reader != null) {
			try {
				line = reader.readLine();    // get another symptom
			} catch (IOException e) {
				logger.log(Level.SEVERE, "The " + symptomsDataFile + " text file contains lines that cannot be readable. Please correct the file.", e);
			}
		}
		return line;
	}

	private static BufferedReader tryReadingFile() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(dataDirectoryPath + symptomsDataFile));
		} catch (FileNotFoundException e) {
			logger.log(Level.SEVERE, "Please check if file is in path: " + dataDirectoryPath + symptomsDataFile, e);
		}
		return reader;
	}

	private static void addFileLogger() {
		try {
			logger.addHandler(new FileHandler("Project02Eclipse/src/com/hemebiotech/analytics/log/logger" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) + ".xml"));
		} catch (IOException e) {
			logger.log(Level.WARNING, "Cannot create a logger file. Please check path.", e);
		}
	}
}
