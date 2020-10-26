package test.com.hemebiotech.analytics.symptomscounter;

public enum PathDataTest {
    DATA_RESULTS_OUT("Project02Eclipse/src/test/com/hemebiotech/analytics/symptomscounter/data/results.out");

    private final String path;

    PathDataTest(String path) {
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }
}