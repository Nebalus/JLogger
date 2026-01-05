package dev.nebalus.library.jlogger.handler;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.LogRecord;

/**
 * Interface for log handlers that process and output log records.
 * Handlers receive log records from loggers and write them to various
 * destinations.
 */
public interface LogHandlerInterface {

	/**
	 * Checks if this handler will process records at the given log level.
	 *
	 * @param logLevel the log level to check
	 * @return true if this handler processes records at the given level
	 */
	boolean isHandling(LogLevel logLevel);

	/**
	 * Handles a single log record.
	 *
	 * @param logRecord the log record to handle
	 * @return true if the record was handled and should not bubble to other
	 *         handlers
	 * @throws Exception if handling fails
	 */
	boolean handle(LogRecord logRecord) throws Exception;

	/**
	 * Handles multiple log records in batch.
	 *
	 * @param logRecords the log records to handle
	 * @throws Exception if handling fails
	 */
	void handleBatch(LogRecord... logRecords) throws Exception;

	/**
	 * Closes this handler and releases any resources.
	 */
	void close();
}
