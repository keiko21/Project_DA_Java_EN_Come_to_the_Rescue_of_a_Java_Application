package com.hemebiotech.analytics.symptomscounter;

import java.io.BufferedReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Handler that process symptoms from a file.
 *
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public class SymptomsHandler {

    /**
     * Handle symptoms an return them into an alphabetical order with counted symptoms.
     *
     * @param symptomsFile the symptoms file
     * @return collected, sorted and split symptoms.
     */
    public static String[] handle(BufferedReader symptomsFile) {
        Stream<String> fileLines = collect(symptomsFile);
        TreeMap<String, Long> symptomOccurrenceTreeMap = sort(fileLines);

        return split(symptomOccurrenceTreeMap);
    }

    private static String[] split(TreeMap<String, Long> symptomOccurrenceTreeMap) {
        StringBuffer symptomOccurrenceString = new StringBuffer();
        symptomOccurrenceTreeMap
                .forEach((symptom, occurrence)
                        -> symptomOccurrenceString
                        .append(symptom)
                        .append(": ")
                        .append(occurrence)
                        .append("\n"));

        return symptomOccurrenceString.toString().split("\n");
    }

    private static Stream<String> collect(BufferedReader symptomsFile) {
        return symptomsFile.lines();
    }

    private static TreeMap<String, Long> sort(Stream<String> fileLines) {
        Map<String, Long> symptomOccurrenceMap =
                fileLines.collect(
                        Collectors.groupingBy(
                                line -> line, Collectors.counting()));

        return new TreeMap<>(symptomOccurrenceMap);
    }
}
