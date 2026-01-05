package dev.nebalus.libary.logging.formatter;

import dev.nebalus.libary.logging.LogRecord;

public interface LogFormatterInterface 
{
	abstract LogRecord format(LogRecord logRecord) throws Exception;
}
