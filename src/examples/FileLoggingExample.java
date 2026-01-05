package src.examples;

import java.io.File;

import dev.nebalus.library.jlogger.Logger;
import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.handler.SyslogHandler;
import dev.nebalus.library.jlogger.handler.FileStreamHandler;
import dev.nebalus.library.jlogger.formatter.LineFormatter;
import dev.nebalus.library.jlogger.formatter.ColorLineFormatter;
import dev.nebalus.library.jlogger.formatter.colorscheme.DefaultColorScheme;

/**
 * JLogger example demonstrating file logging and combining multiple handlers.
 * 
 * Run with: java -cp "target/classes:examples" FileLoggingExample
 */
public class FileLoggingExample {

    /**
     * Runs the file logging example demonstrating multiple handlers.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create logger
        Logger logger = new Logger("FileDemo");

        // --- Console Handler (colored, shows INFO and above) ---
        SyslogHandler consoleHandler = new SyslogHandler(LogLevel.INFO, true); // bubble=true
        consoleHandler.setFormatter(new ColorLineFormatter(
                new DefaultColorScheme(),
                null,
                "HH:mm:ss"));

        // --- File Handler (plain text, shows DEBUG and above) ---
        File logFile = new File("application.log");
        FileStreamHandler fileHandler = new FileStreamHandler(logFile, LogLevel.DEBUG, false);
        fileHandler.setFormatter(new LineFormatter());

        // Add handlers (order matters for bubbling)
        logger.pushHandler(fileHandler); // First: write to file
        logger.pushHandler(consoleHandler); // Second: write to console

        System.out.println("Logging to console (INFO+) and file (DEBUG+)...\n");

        // These will appear in both console and file
        logger.error("Error: Database connection failed!");
        logger.warning("Warning: Retrying in 5 seconds...");
        logger.info("Connected to database successfully");

        // These will only appear in the file (below INFO threshold for console)
        logger.debug("Query executed in 15ms");
        logger.debug("Cache hit ratio: 78%%");

        // Log with class context
        logger.info(FileLoggingExample.class, "Application started");

        // Clean up - flushes file buffer
        logger.close();

        System.out.println("\n✓ File logging example completed!");
        System.out.println("Check 'application.log' for all logged messages including DEBUG level.");
    }
}
