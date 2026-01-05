package dev.nebalus.library.jlogger.formatter.colorscheme;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;

public class TrafficLightColorScheme extends ColorScheme {

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
