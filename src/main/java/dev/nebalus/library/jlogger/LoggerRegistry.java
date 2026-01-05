package dev.nebalus.library.jlogger;

import java.util.HashMap;

public class LoggerRegistry {

    private static HashMap<String, Logger> registry;

    static {
        registry = new HashMap<>();
    }

    /**
     * Adds new logging channel to the registry
     *
     * @param Logger      $logger Instance of the logging channel
     * @param string|null $name Name of the logging channel (logger.getName() by
     *                    default)
     * @param boolean     $overwrite Overwrite instance in the registry if the given
     *                    name already exists?
     * 
     * @throws NullPointerException     If the $logger is null
     * @throws InvalidArgumentException If $overwrite set to false and named Logger
     *                                  instance already exists
     */
    public static void addLogger(Logger logger, String name, boolean override) {
        if (logger == null) {
            throw new NullPointerException("Logger cannot be null");
        }

        name = (name == null) ? logger.getChannelName() : name;

    }
}
