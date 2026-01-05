package dev.nebalus.libary.logging.formatter;

import dev.nebalus.libary.logging.LogRecord;
import dev.nebalus.libary.logging.ansi.AnsiFormatingCode;
import dev.nebalus.libary.logging.formatter.colorscheme.ColorScheme;
import dev.nebalus.libary.logging.formatter.colorscheme.DefaultColorScheme;

public class ColorLineFormatter extends LineFormatter {

	private ColorScheme colorScheme;

	public ColorLineFormatter(ColorScheme colorScheme, String format, String dateFormat) {
		super(format, dateFormat);
		this.colorScheme = colorScheme != null ? colorScheme : new DefaultColorScheme();
	}

	@Override
	public LogRecord format(LogRecord logRecord) 
	{
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

	public void setColorScheme(ColorScheme colorScheme)
	{
		this.colorScheme = colorScheme;
	}

	public ColorScheme getColorScheme()
	{
		return colorScheme;
	}
}
