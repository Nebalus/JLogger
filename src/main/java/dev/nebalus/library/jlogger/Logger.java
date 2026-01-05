package dev.nebalus.library.jlogger;

import java.util.Date;

public class Logger extends LogChannel {
	public Logger(String channelName) {
		super(channelName);
	}

	protected void dispatch(LogLevel logLevel, String[] labels, String msg, Object[] messageFormatArgs,
			boolean isAsync) {
		String msgFormatted = String.format(msg, messageFormatArgs);
		LogRecord logRecord = new LogRecord(new Date(), logLevel, channelName, Thread.currentThread().getName(), labels,
				msgFormatted);

		super.addRecord(logRecord, isAsync);
	}

	protected void dispatchThrowable(LogLevel logLevel, String[] labels, Throwable throwable, boolean isAsync) {
		LogRecord logRecord = new LogRecord(new Date(), logLevel, channelName, Thread.currentThread().getName(), labels,
				throwable);
		super.addRecord(logRecord, isAsync);
	}

	public void emergency(Object msg) {
		dispatch(LogLevel.EMERGENCY, null, msg.toString(), null, false);
	}

	public void emergency(Object msg, Object... args) {
		dispatch(LogLevel.EMERGENCY, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void emergency(Class clazz, Object msg) {
		dispatch(LogLevel.EMERGENCY, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void emergency(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.EMERGENCY, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void emergency(Throwable throwable) {
		dispatchThrowable(LogLevel.EMERGENCY, new String[] {
				throwable.getClass().getName()
		}, throwable, false);
	}

	@SuppressWarnings("rawtypes")
	public void emergency(Class clazz, Throwable throwable) {
		dispatchThrowable(LogLevel.EMERGENCY, new String[] {
				clazz.getName()
		}, throwable, false);
	}

	public void alert(Object msg) {
		dispatch(LogLevel.ALERT, null, msg.toString(), null, false);
	}

	public void alert(Object msg, Object... args) {
		dispatch(LogLevel.ALERT, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void alert(Class clazz, Object msg) {
		dispatch(LogLevel.ALERT, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void alert(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.ALERT, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void alert(Throwable throwable) {
		dispatchThrowable(LogLevel.ALERT, new String[] {
				throwable.getClass().getName()
		}, throwable, false);
	}

	@SuppressWarnings("rawtypes")
	public void alert(Class clazz, Throwable throwable) {
		dispatchThrowable(LogLevel.ALERT, new String[] {
				clazz.getName()
		}, throwable, false);
	}

	public void fatal(Object msg) {
		dispatch(LogLevel.FATAL, null, msg.toString(), null, false);
	}

	public void fatal(Object msg, Object... args) {
		dispatch(LogLevel.FATAL, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void fatal(Class clazz, Object msg) {
		dispatch(LogLevel.FATAL, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void fatal(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.FATAL, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void fatal(Throwable throwable) {
		dispatchThrowable(LogLevel.FATAL, new String[] {
				throwable.getClass().getName()
		}, throwable, false);
	}

	@SuppressWarnings("rawtypes")
	public void fatal(Class clazz, Throwable throwable) {
		dispatchThrowable(LogLevel.FATAL, new String[] {
				clazz.getName()
		}, throwable, false);
	}

	public void error(Object msg) {
		dispatch(LogLevel.ERROR, null, msg.toString(), null, false);
	}

	public void error(Object msg, Object... args) {
		dispatch(LogLevel.ERROR, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void error(Class clazz, Object msg) {
		dispatch(LogLevel.ERROR, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void error(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.ERROR, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void error(Throwable throwable) {
		dispatchThrowable(LogLevel.ERROR, new String[] {
				throwable.getClass().getName()
		}, throwable, false);
	}

	@SuppressWarnings("rawtypes")
	public void error(Class clazz, Throwable throwable) {
		dispatchThrowable(LogLevel.ERROR, new String[] {
				clazz.getName()
		}, throwable, false);
	}

	public void warning(Object msg) {
		dispatch(LogLevel.WARNING, null, msg.toString(), null, false);
	}

	public void warning(Object msg, Object... args) {
		dispatch(LogLevel.WARNING, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void warning(Class clazz, Object msg) {
		dispatch(LogLevel.WARNING, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void warning(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.WARNING, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void warning(Throwable throwable) {
		dispatchThrowable(LogLevel.WARNING, new String[] {
				throwable.getClass().getName()
		}, throwable, false);
	}

	@SuppressWarnings("rawtypes")
	public void warning(Class clazz, Throwable throwable) {
		dispatchThrowable(LogLevel.WARNING, new String[] {
				clazz.getName()
		}, throwable, false);
	}

	public void info(Object msg) {
		dispatch(LogLevel.INFO, null, msg.toString(), null, false);
	}

	public void info(Object msg, Object... args) {
		dispatch(LogLevel.INFO, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void info(Class clazz, Object msg) {
		dispatch(LogLevel.INFO, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void info(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.INFO, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void log(Object msg) {
		dispatch(LogLevel.DEFAULT, null, msg.toString(), null, false);
	}

	public void log(Object msg, Object... args) {
		dispatch(LogLevel.DEFAULT, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void log(Class clazz, Object msg) {
		dispatch(LogLevel.DEFAULT, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void log(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.DEFAULT, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void log(LogLevel logLevel, Object msg) {
		dispatch(logLevel, null, msg.toString(), null, false);
	}

	public void log(LogLevel logLevel, Object msg, Object... args) {
		dispatch(logLevel, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void log(LogLevel logLevel, Class clazz, Object msg) {
		dispatch(logLevel, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void log(LogLevel logLevel, Class clazz, Object msg, Object... args) {
		dispatch(logLevel, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}

	public void debug(Object msg) {
		dispatch(LogLevel.DEBUG, null, msg.toString(), null, false);
	}

	public void debug(Object msg, Object... args) {
		dispatch(LogLevel.DEBUG, null, msg.toString(), args, false);
	}

	@SuppressWarnings("rawtypes")
	public void debug(Class clazz, Object msg) {
		dispatch(LogLevel.DEBUG, new String[] {
				clazz.getName()
		}, msg.toString(), null, false);
	}

	@SuppressWarnings("rawtypes")
	public void debug(Class clazz, Object msg, Object... args) {
		dispatch(LogLevel.DEBUG, new String[] {
				clazz.getName()
		}, msg.toString(), args, false);
	}
}