package dev.nebalus.library.jlogger.formatter.colorscheme;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;

public class DefaultColorScheme extends ColorScheme {

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
