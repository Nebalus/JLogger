package dev.nebalus.library.jlogger.formatter.colorscheme;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;

/**
 * Default color scheme with distinct colors and styles for each log level.
 * Uses a variety of colors and formatting styles (blinking, bold, italic)
 * to clearly differentiate between severity levels.
 */
public class DefaultColorScheme extends ColorScheme {

	/**
	 * Creates a new DefaultColorScheme with predefined color mappings.
	 * <ul>
	 * <li>EMERGENCY: Blinking bright yellow on red background</li>
	 * <li>ALERT: Bright yellow on bright red background</li>
	 * <li>FATAL: Bright white on bright red background</li>
	 * <li>ERROR: Bright red</li>
	 * <li>WARNING: Yellow</li>
	 * <li>INFO: Bright blue</li>
	 * <li>DEBUG: Italic gray</li>
	 * </ul>
	 */
	public DefaultColorScheme() {
		super();
		registerScheme(LogLevel.EMERGENCY, AnsiFormatingCode.STYLE_SLOW_BLINK, AnsiFormatingCode.STYLE_INTENSITY_BRIGHT,
				AnsiFormatingCode.COLOR_YELLOW_FG_BRIGHT, AnsiFormatingCode.COLOR_RED_BG);
		registerScheme(LogLevel.ALERT, AnsiFormatingCode.STYLE_INTENSITY_BRIGHT, AnsiFormatingCode.COLOR_YELLOW_FG,
				AnsiFormatingCode.COLOR_RED_BG_BRIGHT);
		registerScheme(LogLevel.FATAL, AnsiFormatingCode.STYLE_INTENSITY_BRIGHT, AnsiFormatingCode.COLOR_WHITE_FG,
				AnsiFormatingCode.COLOR_RED_BG_BRIGHT);
		registerScheme(LogLevel.ERROR, AnsiFormatingCode.STYLE_INTENSITY_BRIGHT, AnsiFormatingCode.COLOR_RED_FG);
		registerScheme(LogLevel.WARNING, AnsiFormatingCode.COLOR_YELLOW_FG);
		registerScheme(LogLevel.INFO, AnsiFormatingCode.COLOR_BLUE_FG_BRIGHT);
		registerScheme(LogLevel.DEBUG, AnsiFormatingCode.STYLE_ITALIC, AnsiFormatingCode.COLOR_GRAY_FG);
	}
}
