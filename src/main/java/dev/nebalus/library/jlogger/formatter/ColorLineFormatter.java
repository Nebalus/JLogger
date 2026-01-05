package dev.nebalus.library.jlogger.formatter;

import dev.nebalus.library.jlogger.LogRecord;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;
import dev.nebalus.library.jlogger.formatter.colorscheme.ColorScheme;
import dev.nebalus.library.jlogger.formatter.colorscheme.DefaultColorScheme;

public class ColorLineFormatter extends LineFormatter {

	private ColorScheme colorScheme;

	public ColorLineFormatter(ColorScheme colorScheme, String format, String dateFormat) {
		super(format, dateFormat);
		this.colorScheme = colorScheme != null ? colorScheme : new DefaultColorScheme();
	}

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

	public void setColorScheme(ColorScheme colorScheme) {
		this.colorScheme = colorScheme;
	}

	public ColorScheme getColorScheme() {
		return colorScheme;
	}
}
