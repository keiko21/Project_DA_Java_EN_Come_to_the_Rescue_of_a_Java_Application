package test.com.hemebiotech.analytics.symptomscounter;

/**
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public enum PathDataTest {
    /**
     * results.out file data test path.
     */
    RESULTS_OUT_FILE("Project02Eclipse/src/test/com/hemebiotech/analytics/symptomscounter/data/results.out");

    private final String path;

    PathDataTest(String path) {
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