package dev.nebalus.library.jlogger.formatter;

import dev.nebalus.library.jlogger.LogRecord;

public interface LogFormatterInterface {
	abstract LogRecord format(LogRecord logRecord) throws Exception;
}
