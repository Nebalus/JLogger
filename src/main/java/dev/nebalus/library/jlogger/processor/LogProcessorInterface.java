package dev.nebalus.library.jlogger.processor;

import dev.nebalus.library.jlogger.LogRecord;

public interface LogProcessorInterface
{
	public LogRecord process(LogRecord logRecord) throws Exception;
}
