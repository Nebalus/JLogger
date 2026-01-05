package dev.nebalus.library.jlogger.formatter;

import dev.nebalus.library.jlogger.LogRecord;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;
import dev.nebalus.library.jlogger.formatter.colorscheme.ColorScheme;
import dev.nebalus.library.jlogger.formatter.colorscheme.DefaultColorScheme;

/**
 * A line formatter that adds ANSI color codes to log output.
 * Extends {@link LineFormatter} to provide colorized console output
 * based on configurable color schemes.
 */
public class ColorLineFormatter extends LineFormatter {

	private ColorScheme colorScheme;

	/**
	 * Creates a new ColorLineFormatter with the specified color scheme.
	 *
	 * @param colorScheme the color scheme to use (uses {@link DefaultColorScheme}
	 *                    if null)
	 * @param format      the format string for log messages (null for default)
	 * @param dateFormat  the date format pattern (null for default)
	 */
	public ColorLineFormatter(ColorScheme colorScheme, String format, String dateFormat) {
		super(format, dateFormat);
		this.colorScheme = colorScheme != null ? colorScheme : new DefaultColorScheme();
	}

	/**
	 * Formats a log record with ANSI color codes based on the log level.
	 *
	 * @param logRecord the log record to format
	 * @return the formatted log record with color codes applied
	 */
	@Override
	public LogRecord format(LogRecord logRecord) {
		StringBuilder sb = new StringBuilder();
		if (colorScheme != null) {
			sb.append(colorScheme.getColorizedString(logRecord.getLogLevel()));
		}
		sb.append(super.format(logRecord).formatted);
		if (colorScheme != null) {
			sb.append(AnsiFormatingCode.RESET.getAnsiCode());
		}

		logRecord.formatted = sb.toString();

		return logRecord;
	}

	/**
	 * Sets the color scheme used for formatting.
	 *
	 * @param colorScheme the new color scheme to use
	 */
	public void setColorScheme(ColorScheme colorScheme) {
		this.colorScheme = colorScheme;
	}

	/**
	 * Gets the current color scheme.
	 *
	 * @return the current color scheme
	 */
	public ColorScheme getColorScheme() {
		return colorScheme;
	}
}
