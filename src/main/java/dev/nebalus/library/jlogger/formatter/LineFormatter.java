package dev.nebalus.library.jlogger.formatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dev.nebalus.library.jlogger.LogRecord;

public class LineFormatter implements LogFormatterInterface {

	private final SimpleDateFormat dateFormatter;

	// %datetime% = Die Aktuelle Log Zeit
	// %level_name% = Der Name des LogLevels
	// %message% = Die Log nachricht
	// %thread_name% = Die Name des zu loggenden Threads

	public LineFormatter(String format, String dateFormat) {
		dateFormatter = new SimpleDateFormat(dateFormat);
	}

	public LineFormatter() {
		this(null, "HH:mm:ss");
	}

	@Override
	public LogRecord format(LogRecord logRecord) {
		StringBuilder sb = new StringBuilder();
		String formattedTimestamp = dateFormatter.format(logRecord.getDate()); // Date Managment (Timestamp generation)

		final List<String> firstValues = new ArrayList<>();
		firstValues.add(formattedTimestamp);

		final List<String> secondValues = new ArrayList<>();
		secondValues.add(logRecord.getThreadName());
		if (logRecord.getLogLevel().showNameInConsole()) {
			secondValues.add(logRecord.getLogLevel().name());
		}

		final List<String> thirdValues = new ArrayList<>();
		if (logRecord.getChannelName() != null) {
			thirdValues.add(logRecord.getChannelName());
		}
		thirdValues.addAll(Arrays.asList(logRecord.getLabels()));

		sb.append(formatField('[', ' ', ']', firstValues));
		sb.append(" ");
		sb.append(formatField('[', ' ', ']', secondValues));
		sb.append(" ");
		sb.append(formatField('(', '/', ')', thirdValues));
		sb.append(": ");
		sb.append(logRecord.getMessage());
		// sb.append(" ");
		// sb.append(logRecord.extras.toString());

		logRecord.formatted = sb.toString();
		return logRecord;
	}

	protected String formatField(char openScopeChar, char seperator, char closeScopeChar, List<String> values) {
		if (values.isEmpty()) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(openScopeChar);

		boolean isFirst = true;
		for (String content : values) {
			if (isFirst) {
				sb.append(content);
				isFirst = false;
			} else {
				sb.append(seperator);
				sb.append(content);
			}
		}

		sb.append(closeScopeChar);
		return sb.toString();
	}
}
