package dev.nebalus.libary.logging.formatter.colorscheme;

import java.util.HashMap;

import org.jetbrains.annotations.NotNull;

import dev.nebalus.libary.logging.LogLevel;
import dev.nebalus.libary.logging.ansi.AnsiFormatingCode;

public abstract class ColorScheme {

	private HashMap<LogLevel, String> schemes;

	public ColorScheme() {
		this.schemes = new HashMap<>();
	}

	protected void registerScheme(@NotNull LogLevel logLevel, AnsiFormatingCode... scheme)
	{
		String ansiScheme = AnsiFormatingCode.buildAnsiCode(scheme);

		if (schemes.containsKey(logLevel)) {
			schemes.replace(logLevel, ansiScheme);
		} else {
			schemes.put(logLevel, ansiScheme);
		}
	}

	protected void unregisterScheme(@NotNull LogLevel logLevel)
	{
		schemes.remove(logLevel);
	}

	public String getColorizedString(LogLevel loglevel)
	{
		String ansiScheme = schemes.get(loglevel);
		if (ansiScheme != null) {
			return ansiScheme;
		}
		return "";
	}
	
	public String getResetString()
	{
		return AnsiFormatingCode.RESET.getAnsiCode();
	}
}
