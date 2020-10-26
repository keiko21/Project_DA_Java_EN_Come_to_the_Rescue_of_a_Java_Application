package com.hemebiotech.analytics.symptomscounter;

import com.hemebiotech.analytics.Path;

import java.util.logging.Logger;

/**
 * Logger specific class for symptoms counter project. Inherit {@link com.hemebiotech.analytics.Logger} logging
 * template.
 * This logger will create automatically a logger file when initializing this class.
 *
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public class SymptomsCounterLogger extends com.hemebiotech.analytics.Logger {
    private static final Logger logger = Logger.getLogger(SymptomsCounterApplication.class.getName());

    /**
     * Create a file logger class.
     */
    public SymptomsCounterLogger() {
        super(SymptomsCounterLogger.class.getName(), null);
        addFileLogger(logger, Path.LOGS_REPOSITORY.getPath(), SymptomsCounterLogger.class.getSimpleName());
    }
}
