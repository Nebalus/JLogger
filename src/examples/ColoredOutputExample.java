package src.examples;

import dev.nebalus.library.jlogger.Logger;
import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.handler.SyslogHandler;
import dev.nebalus.library.jlogger.formatter.ColorLineFormatter;
import dev.nebalus.library.jlogger.formatter.colorscheme.DefaultColorScheme;
import dev.nebalus.library.jlogger.formatter.colorscheme.TrafficLightColorScheme;

/**
 * JLogger example demonstrating colored console output with different color
 * schemes.
 * 
 * Run with: java -cp "target/classes:examples" ColoredOutputExample
 * Note: Colors require a terminal that supports ANSI escape codes.
 */
public class ColoredOutputExample {

    public static void main(String[] args) {
        // Create logger
        Logger logger = new Logger("ColorDemo");

        // --- Using Default Color Scheme ---
        System.out.println("=== Default Color Scheme ===\n");

        SyslogHandler colorHandler = new SyslogHandler(LogLevel.DEBUG, false);
        ColorLineFormatter colorFormatter = new ColorLineFormatter(
                new DefaultColorScheme(),
                null,
                "HH:mm:ss");
        colorHandler.setFormatter(colorFormatter);
        logger.setHandlers(colorHandler);

        // Each level has its own color styling
        logger.emergency("EMERGENCY: Blinking yellow on red background");
        logger.alert("ALERT: Yellow on bright red background");
        logger.fatal("FATAL: White on bright red background");
        logger.error("ERROR: Bright red text");
        logger.warning("WARNING: Yellow text");
        logger.info("INFO: Bright blue text");
        logger.log("DEFAULT: No special coloring");
        logger.debug("DEBUG: Italic gray text");

        // --- Using Traffic Light Color Scheme ---
        System.out.println("\n=== Traffic Light Color Scheme ===\n");

        colorFormatter.setColorScheme(new TrafficLightColorScheme());

        logger.error("ERROR: Red");
        logger.warning("WARNING: Yellow");
        logger.info("INFO: Green");
        logger.debug("DEBUG: Gray");

        logger.close();

        System.out.println("\n✓ Colored output example completed!");
    }
}
