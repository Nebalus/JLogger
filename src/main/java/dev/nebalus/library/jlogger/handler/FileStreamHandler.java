package dev.nebalus.library.jlogger.handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.LogRecord;

/**
 * A handler that writes log records to a file.
 * Uses buffered writing for improved performance.
 */
public class FileStreamHandler extends AbstractProcessingHandler {

	/** The target log file. */
	protected File file;

	/** The file writer for the log file. */
	protected FileWriter fileWriter;

	/** Buffered writer for efficient file writing. */
	protected BufferedWriter bufferedWriter;

	/**
	 * Creates a new FileStreamHandler that writes to the specified file.
	 *
	 * @param file     the file to write logs to
	 * @param logLevel the minimum log level to handle
	 * @param bubble   whether to pass records to subsequent handlers
	 */
	public FileStreamHandler(File file, LogLevel logLevel, boolean bubble) {
		super(logLevel, bubble);
		this.file = file;
		try {
			fileWriter = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bufferedWriter = new BufferedWriter(fileWriter);
	}

	/**
	 * Writes a log record to the file.
	 *
	 * @param logRecord the log record to write
	 */
	@Override
	protected void write(LogRecord logRecord) {
		try {
			streamWrite(logRecord);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Performs the actual stream write operation.
	 *
	 * @param logRecord the log record to write
	 * @throws IOException if writing fails
	 */
	protected void streamWrite(LogRecord logRecord) throws IOException {
		bufferedWriter.write(logRecord.formatted + "\n");
		bufferedWriter.flush();
	}

	/**
	 * Closes the handler and flushes any remaining buffered content.
	 */
	@Override
	public void close() {
		try {
			bufferedWriter.flush();
		} catch (IOException e) {
			// Ignored
		}
	}
}
