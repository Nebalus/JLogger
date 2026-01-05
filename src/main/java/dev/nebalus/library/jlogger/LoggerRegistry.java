package dev.nebalus.library.jlogger;

import java.util.HashMap;

public class LoggerRegistry {

    private static HashMap<String, Logger> registry;

    static {
        registry = new HashMap<>();
    }

    /**
     * Adds new logging channel to the registry.
     *
     * @param logger   the logging channel instance to add
     * @param name     the name of the logging channel (uses logger.getChannelName()
     *                 if null)
     * @param override whether to overwrite an existing logger with the same name
     * @throws NullPointerException     if the logger is null
     * @throws IllegalArgumentException if override is false and a logger with the
     *                                  same name already exists
     */
    public static void addLogger(Logger logger, String name, boolean override) {
        if (logger == null) {
            throw new NullPointerException("Logger cannot be null");
        }

        name = (name == null) ? logger.getChannelName() : name;

    }
}
