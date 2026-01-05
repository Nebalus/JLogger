package dev.nebalus.library.jlogger.formatter.colorscheme;

import java.util.HashMap;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;

/**
 * Abstract base class for color schemes used in log formatting.
 * Subclasses define color mappings for different log levels.
 */
public abstract class ColorScheme {

	private HashMap<LogLevel, String> schemes;

	/**
	 * Creates a new ColorScheme with an empty scheme mapping.
	 */
	public ColorScheme() {
		this.schemes = new HashMap<>();
	}

	/**
	 * Registers a color scheme for a specific log level.
	 *
	 * @param logLevel the log level to associate with the color scheme
	 * @param scheme   the ANSI formatting codes to apply for this level
	 */
	protected void registerScheme(LogLevel logLevel, AnsiFormatingCode... scheme) {
		String ansiScheme = AnsiFormatingCode.buildAnsiCode(scheme);

		if (schemes.containsKey(logLevel)) {
			schemes.replace(logLevel, ansiScheme);
		} else {
			schemes.put(logLevel, ansiScheme);
		}
	}

	/**
	 * Removes the color scheme for a specific log level.
	 *
	 * @param logLevel the log level to remove the scheme for
	 */
	protected void unregisterScheme(LogLevel logLevel) {
		schemes.remove(logLevel);
	}

	/**
	 * Gets the ANSI color code string for a specific log level.
	 *
	 * @param loglevel the log level to get the color for
	 * @return the ANSI escape sequence for the color, or empty string if none
	 *         registered
	 */
	public String getColorizedString(LogLevel loglevel) {
		String ansiScheme = schemes.get(loglevel);
		if (ansiScheme != null) {
			return ansiScheme;
		}
		return "";
	}

	/**
	 * Gets the ANSI reset code to restore default terminal formatting.
	 *
	 * @return the ANSI reset escape sequence
	 */
	public String getResetString() {
		return AnsiFormatingCode.RESET.getAnsiCode();
	}
}
