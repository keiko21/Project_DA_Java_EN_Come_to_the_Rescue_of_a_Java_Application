package com.hemebiotech.analytics;

/**
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public enum Path {
    /**
     * Project repository path.
     */
    PROJECT_REPOSITORY("Project02Eclipse/src/com/hemebiotech/analytics/symptomscounter/"),
    /**
     * Data repository path.
     */
    DATA_REPOSITORY(PROJECT_REPOSITORY.getPath() + "data/"),
    /**
     * symptoms.txt file path.
     */
    SYMPTOMS_FILE(DATA_REPOSITORY.getPath() + "symptoms.txt"),
    /**
     * results.out file path.
     */
    RESULTS_OUT_FILE(DATA_REPOSITORY.getPath() + "results.out"),
    /**
     * Logs repository path.
     */
    LOGS_REPOSITORY(PROJECT_REPOSITORY.getPath() + "logs/");

    private final String path;

    Path(String path) {
        this.path = path;
    }

    /**
     * Gets path.
     *
     * @return the path
     */
    public String getPath() {
        return this.path;
    }
}