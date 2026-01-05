package dev.nebalus.libary.logging.job;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import dev.nebalus.libary.logging.LogRecord;
import dev.nebalus.libary.logging.ansi.AnsiFormatingCode;
import dev.nebalus.libary.logging.formatter.LogFormatterInterface;

@SuppressWarnings("unused")
public final class AsyncLoggingJob implements Runnable
{

	private final BlockingQueue<LogRecord> queue;

	public AsyncLoggingJob()
	{
		this.queue = new LinkedBlockingQueue<LogRecord>();
	}

	@Override
	public void run()
	{
		/*
		int id = 0;

		while (!Thread.currentThread().isInterrupted()) {
			try {
				LogEntry entry = queue.take();
				String formatted = entry.getFormatter().format(entry);
				System.out.println(formatted + " QUEUESIZE:" + queue.size() + " LOGID:" + id + " NANO:" + System.nanoTime());
				// System.out.println(formatted.replaceAll(AnsiFormatingCode.getAnsiRegex(), "")
				// + " QUEUESIZE:" + queue.size() + " LOGID:" + i);
			} catch (InterruptedException e) {
			}
			id++;
		}

		// printWriter.flush();
		// printWriter.close();
		 
		 */
	};

	public synchronized void queueLogEntry(LogRecord logRecord)
	{
		queue.add(logRecord);
	}
}
