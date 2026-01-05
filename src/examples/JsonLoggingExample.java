package src.examples;

import dev.nebalus.library.jlogger.Logger;
import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.LogRecord;
import dev.nebalus.library.jlogger.handler.SyslogHandler;
import dev.nebalus.library.jlogger.formatter.JsonFormatter;
import dev.nebalus.library.jlogger.processor.LogProcessorInterface;

/**
 * JLogger example demonstrating JSON structured logging with custom processors.
 * 
 * Run with: java -cp "target/classes:examples" JsonLoggingExample
 * Ideal for log aggregation systems like ELK Stack, Splunk, or CloudWatch.
 */
public class JsonLoggingExample {

    /**
     * Runs the JSON logging example with custom processors.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create logger
        Logger logger = new Logger("JsonDemo");

        // Console handler with JSON formatter
        SyslogHandler jsonHandler = new SyslogHandler(LogLevel.DEBUG, false);
        jsonHandler.setFormatter(new JsonFormatter());

        // Add a custom processor to enrich logs with metadata
        jsonHandler.pushProcessor(new LogProcessorInterface() {
            @Override
            public LogRecord process(LogRecord logRecord) {
                // Add custom fields to every log record
                logRecord.extras.put("app_version", "1.0.0");
                logRecord.extras.put("environment", "development");
                logRecord.extras.put("hostname", getHostname());
                return logRecord;
            }

            private String getHostname() {
                try {
                    return java.net.InetAddress.getLocalHost().getHostName();
                } catch (Exception e) {
                    return "unknown";
                }
            }
        });

        logger.pushHandler(jsonHandler);

        System.out.println("=== JSON Structured Logging ===\n");

        // Basic JSON log
        logger.info("Application started");

        // Log with formatting
        logger.info("User %s authenticated from %s", "admin", "192.168.1.100");

        // Error with class context
        logger.error(JsonLoggingExample.class, "Failed to process request");

        // Exception logging in JSON format
        try {
            throw new IllegalArgumentException("Invalid parameter: userId cannot be null");
        } catch (Exception e) {
            logger.error(e);
        }

        // Different log levels
        logger.warning("High memory usage detected: 85%%");
        logger.debug("Cache size: 1024 entries");

        logger.close();

        System.out.println("\n✓ JSON logging example completed!");
    }
}
