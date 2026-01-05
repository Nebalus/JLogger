package dev.nebalus.libary.logging.handler;

import dev.nebalus.libary.logging.LogLevel;
import dev.nebalus.libary.logging.LogRecord;

public interface LogHandlerInterface {

	public abstract boolean isHandling(LogLevel logLevel);

	public abstract boolean handle(LogRecord logRecord) throws Exception;

	public abstract void handleBatch(LogRecord... logRecords) throws Exception;

	public abstract void close();

}
