package dev.nebalus.libary.logging.processor;

import dev.nebalus.libary.logging.LogRecord;

public interface LogProcessorInterface
{
	public LogRecord process(LogRecord logRecord) throws Exception;
}
