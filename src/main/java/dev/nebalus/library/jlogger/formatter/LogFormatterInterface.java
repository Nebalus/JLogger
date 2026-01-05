package dev.nebalus.library.jlogger.formatter;

import dev.nebalus.library.jlogger.LogRecord;

/**
 * Interface for log record formatters.
 * Implementations transform log records into formatted output strings.
 */
public interface LogFormatterInterface {
	/**
	 * Formats a log record for output.
	 *
	 * @param logRecord the log record to format
	 * @return the formatted log record with the formatted field populated
	 * @throws Exception if formatting fails
	 */
	LogRecord format(LogRecord logRecord) throws Exception;
}
