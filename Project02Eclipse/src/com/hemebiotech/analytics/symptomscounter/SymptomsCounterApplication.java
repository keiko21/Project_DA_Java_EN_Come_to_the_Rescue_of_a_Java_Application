package com.hemebiotech.analytics.symptomscounter;

/**
 * {@link SymptomsCounterApplication} count symptoms from a file and write results with an alphabetical order.
 *
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public class SymptomsCounterApplication {

	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SymptomsFileHandler symptomsFileHandler = new SymptomsFileHandler();

		String[] symptomsCounterLines = SymptomsHandler.handle(symptomsFileHandler.readFile());
		symptomsFileHandler.writeFile(symptomsCounterLines);
	}
}
