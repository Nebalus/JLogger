package dev.nebalus.libary.logging;

import java.util.Date;
import java.util.HashMap;

public class LogRecord implements Cloneable
{

	protected final Date date;
	protected final LogLevel logLevel;
	protected final String channelName;
	protected final String threadName;
	protected final String[] labels;
	protected final String msg;
	protected final Throwable throwable;

	public final HashMap<String, String> extras;
	public String formatted = null;

	public LogRecord(Date date, LogLevel logLevel, String channelName, String threadName, String[] labels, String msg, Throwable throwable)
	{
		this.date = date != null ? date : new Date();
		this.logLevel = logLevel != null ? logLevel : LogLevel.DEFAULT;
		this.channelName = channelName;
		this.threadName = threadName;
		this.labels = labels != null ? labels : new String[] {};
		this.msg = msg != null ? msg : throwable != null ? throwable.getMessage() : null;
		this.throwable = throwable;

		extras = new HashMap<>();
		formatted = null;
	}

	public LogRecord(Date date, LogLevel logLevel, String channelName, String threadName, String[] labels, String msg)
	{
		this(date, logLevel, channelName, threadName, labels, msg, null);
	}

	public LogRecord(Date date, LogLevel logLevel, String channelName, String threadName, String[] labels, Throwable throwable)
	{
		this(date, logLevel, channelName, threadName, labels, null, throwable);
	}

	public Date getDate()
	{
		return date;
	}

	public LogLevel getLogLevel()
	{
		return logLevel;
	}

	public String getChannelName()
	{
		return channelName;
	}

	public String getThreadName()
	{
		return threadName;
	}

	public String[] getLabels()
	{
		return labels;
	}

	public String getMessage()
	{
		return msg;
	}

	public Throwable getThrowable()
	{
		return throwable;
	}

	public boolean isAThrowable()
	{
		return throwable != null;
	}

	@Override
	public Object clone()
	{
		LogRecord clonedInstance = new LogRecord(date, logLevel, channelName, threadName, labels, msg, throwable);
		clonedInstance.formatted = this.formatted;
		clonedInstance.extras.putAll(extras);
		return clonedInstance;
	}
}
