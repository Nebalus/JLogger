package dev.nebalus.library.jlogger.job;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import dev.nebalus.library.jlogger.LogRecord;
import dev.nebalus.library.jlogger.ansi.AnsiFormatingCode;
import dev.nebalus.library.jlogger.formatter.LogFormatterInterface;

/**
 * A runnable job for asynchronous logging operations.
 * Uses a blocking queue to buffer log records for processing in a separate
 * thread.
 */
@SuppressWarnings("unused")
public final class AsyncLoggingJob implements Runnable {

	/** Queue of log records waiting to be processed. */
	private final BlockingQueue<LogRecord> queue;

	/**
	 * Creates a new AsyncLoggingJob with an empty log record queue.
	 */
	public AsyncLoggingJob() {
		this.queue = new LinkedBlockingQueue<LogRecord>();
	}

	/**
	 * Runs the asynchronous logging job.
	 * Processes log records from the queue until interrupted.
	 * Currently contains placeholder implementation.
	 */
	@Override
	public void run() {
		/*
		 * int id = 0;
		 * 
		 * while (!Thread.currentThread().isInterrupted()) {
		 * try {
		 * LogEntry entry = queue.take();
		 * String formatted = entry.getFormatter().format(entry);
		 * System.out.println(formatted + " QUEUESIZE:" + queue.size() + " LOGID:" + id
		 * + " NANO:" + System.nanoTime());
		 * } catch (InterruptedException e) {
		 * }
		 * id++;
		 * }
		 */
	}

	/**
	 * Queues a log record for asynchronous processing.
	 *
	 * @param logRecord the log record to add to the queue
	 */
	public synchronized void queueLogEntry(LogRecord logRecord) {
		queue.add(logRecord);
	}
}
