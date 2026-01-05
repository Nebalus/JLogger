
package dev.nebalus.library.jlogger.job;

public class FileLoggingJob implements Runnable
{

	@Override
	public void run()
	{

	}

}
/*
 * implements Runnable {
 * 
 * private final LogFormatter formatter; private final BlockingQueue<LogEntry>
 * queue;
 * 
 * public ConsoleLoggingJob(LogFormatter formatter) { this.formatter =
 * formatter; this.queue = new LinkedBlockingQueue<LogEntry>(); }
 * 
 * @Override public void run() { int id = 0;
 * 
 * while (!Thread.currentThread().isInterrupted()) { try { LogEntry entry =
 * queue.take(); String formatted = formatter.formatWithAnsi(entry);
 * System.out.println(formatted + " QUEUESIZE:" + queue.size() + " LOGID:" + id
 * + " NANO:" + System.nanoTime()); //
 * System.out.println(formatted.replaceAll(AnsiFormatingCode.getAnsiRegex(), "")
 * // + " QUEUESIZE:" + queue.size() + " LOGID:" + i); } catch
 * (InterruptedException e) {} id++; }
 * 
 * //printWriter.flush(); //printWriter.close(); };
 * 
 * public synchronized void queueLogEntry(LogEntry entry) { queue.add(entry); }
 * }
 */