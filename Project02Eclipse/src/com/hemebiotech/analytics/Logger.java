package com.hemebiotech.analytics;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.MissingResourceException;
import java.util.logging.FileHandler;
import java.util.logging.Level;


/**
 * This custom logger class inherits {@link java.util.logging.Logger} class to allow adding logger files that match a
 * specific template in order to keep conformity trough all logger files.
 *
 * @author <a href="https://www.linkedin.com/in/anastaciya-migal/">Anastaciya Migal</a>
 * @version 1.0
 */
public abstract class Logger extends java.util.logging.Logger {
    /**
     * Protected method to construct a logger for a named subsystem.
     * <p>
     * The logger will be initially configured with a null Level
     * and with useParentHandlers set to true.
     *
     * @param name               A name for the logger.  This should
     *                           be a dot-separated name and should normally
     *                           be based on the package name or class name
     *                           of the subsystem, such as java.net
     *                           or javax.swing.  It may be null for anonymous Loggers.
     * @param resourceBundleName name of ResourceBundle to be used for localizing
     *                           messages for this logger.  May be null if none
     *                           of the messages require localization.
     * @throws MissingResourceException if the resourceBundleName is non-null and
     *                                  no corresponding resource can be found.
     */
    protected Logger(String name, String resourceBundleName) {
        super(name, resourceBundleName);
    }

    /**
     * Add file logger. If it catches an exception, it allows program to continue even if it can't add a logger file.
     *
     * @param logger              the logger
     * @param loggerDirectoryPath the logger directory path
     * @param loggerClassName     the logger class name
     */
    public void addFileLogger(java.util.logging.Logger logger, String loggerDirectoryPath, String loggerClassName) {
        try {
            logger.addHandler(
                    new FileHandler(loggerDirectoryPath
                            + loggerClassName
                            + "_"
                            + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"))
                            + ".xml"));
        } catch (IOException e) {
            logger.log(Level.WARNING, "Cannot create a logger file. Please check path.");
        }
    }
}
