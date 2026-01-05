package src.examples;

import dev.nebalus.library.jlogger.Logger;
import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.handler.SyslogHandler;
import dev.nebalus.library.jlogger.formatter.LineFormatter;

/**
 * Basic JLogger example demonstrating all log levels and message formatting.
 * 
 * Run with: java -cp "target/classes:examples" BasicLoggingExample
 */
public class BasicLoggingExample {

    public static void main(String[] args) {
        // Create a logger with a channel name
        Logger logger = new Logger("MyApp");

        // Add a console handler that shows all log levels (DEBUG has lowest priority)
        SyslogHandler consoleHandler = new SyslogHandler(LogLevel.DEBUG, false);
        consoleHandler.setFormatter(new LineFormatter());
        logger.pushHandler(consoleHandler);

        // Log at different severity levels
        logger.emergency("System is unusable!");
        logger.alert("Immediate action required!");
        logger.fatal("Critical error occurred!");
        logger.error("An error happened");
        logger.warning("Something might be wrong");
        logger.info("Informational message");
        logger.log("Default log message");
        logger.debug("Debug information");

        // Message formatting with arguments
        String username = "john_doe";
        int itemCount = 42;
        logger.info("User %s has %d items in cart", username, itemCount);

        // Class-context logging (adds class name as label)
        logger.info(BasicLoggingExample.class, "Processing started");
        logger.warning(BasicLoggingExample.class, "Slow operation detected: %dms", 1500);

        // Using custom log level
        logger.log(LogLevel.WARNING, "Custom level log message");

        // Exception logging
        try {
            throw new RuntimeException("Something went wrong!");
        } catch (Exception e) {
            logger.error(e);
            logger.error(BasicLoggingExample.class, e);
        }

        // Clean up resources
        logger.close();

        System.out.println("\n✓ Basic logging example completed!");
    }
}
