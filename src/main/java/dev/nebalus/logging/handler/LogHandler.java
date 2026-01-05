package dev.nebalus.libary.logging.handler;

import dev.nebalus.libary.logging.LogRecord;

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
