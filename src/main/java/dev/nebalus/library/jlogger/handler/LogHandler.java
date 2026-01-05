package dev.nebalus.library.jlogger.handler;

import dev.nebalus.library.jlogger.LogRecord;

public abstract class LogHandler implements LogHandlerInterface {

	@Override
	public void handleBatch(LogRecord... logRecords) throws Exception
	{
		for (LogRecord logRecord : logRecords) {
			handle(logRecord);
		}
	}

	@Override
	public void close()
	{
	}
}
