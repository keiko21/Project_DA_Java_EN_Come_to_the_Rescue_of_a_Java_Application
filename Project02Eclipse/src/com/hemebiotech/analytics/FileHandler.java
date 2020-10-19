package com.hemebiotech.analytics;

import java.io.BufferedReader;


/**
 * Handler that expose methods to handle it.
 *
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public interface FileHandler {

	/**
	 * Read file with {@link BufferedReader}.
	 *
	 * @return the buffered reader
	 */
	BufferedReader readFile();

	/**
	 * Write file.
	 *
	 * @param linesToWrite the lines to write
	 */
	void writeFile(String[] linesToWrite);
}
