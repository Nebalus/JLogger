package dev.nebalus.library.jlogger.formatter.colorscheme;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;

/**
 * A simple traffic light color scheme using red, yellow, and green colors.
 * Maps log severity to traffic light colors for intuitive severity indication.
 */
public class TrafficLightColorScheme extends ColorScheme {

	/**
	 * Creates a new TrafficLightColorScheme with traffic light color mappings.
	 * <ul>
	 * <li>EMERGENCY, ALERT, FATAL: Red shades (highest severity)</li>
	 * <li>ERROR, WARNING: Yellow shades (medium severity)</li>
	 * <li>INFO, DEFAULT, DEBUG: Green shades (low severity/normal)</li>
	 * </ul>
	 */
	public TrafficLightColorScheme() {
		super();
		registerScheme(LogLevel.EMERGENCY, AnsiFormatingCode.STYLE_SLOW_BLINK, AnsiFormatingCode.COLOR_RED_FG);
		registerScheme(LogLevel.ALERT, AnsiFormatingCode.COLOR_RED_FG_BRIGHT);
		registerScheme(LogLevel.FATAL, AnsiFormatingCode.COLOR_RED_FG);
		registerScheme(LogLevel.ERROR, AnsiFormatingCode.COLOR_YELLOW_FG);
		registerScheme(LogLevel.WARNING, AnsiFormatingCode.COLOR_YELLOW_FG, AnsiFormatingCode.STYLE_INTENSITY_FAINT);
		registerScheme(LogLevel.INFO, AnsiFormatingCode.COLOR_GREEN_FG_BRIGHT);
		registerScheme(LogLevel.DEFAULT, AnsiFormatingCode.COLOR_GREEN_FG);
		registerScheme(LogLevel.DEBUG, AnsiFormatingCode.COLOR_GREEN_FG, AnsiFormatingCode.STYLE_INTENSITY_FAINT);
	}
}
