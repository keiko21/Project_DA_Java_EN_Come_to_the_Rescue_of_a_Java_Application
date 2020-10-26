package com.hemebiotech.analytics;

public enum Path {
    DATA_REPOSITORY("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/data/"),
    DATA_SYMPTOMS("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/data/symptoms.txt"),
    DATA_RESULTS_OUT("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/data/results.out"),
    LOGS_REPOSITORY("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/logs/");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}