package dev.nebalus.library.jlogger.handler;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.LogRecord;

public interface LogHandlerInterface {

	public abstract boolean isHandling(LogLevel logLevel);

	public abstract boolean handle(LogRecord logRecord) throws Exception;

	public abstract void handleBatch(LogRecord... logRecords) throws Exception;

	public abstract void close();

}
