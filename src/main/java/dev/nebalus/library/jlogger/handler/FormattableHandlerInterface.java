package dev.nebalus.library.jlogger.handler;

import dev.nebalus.library.jlogger.formatter.LogFormatterInterface;

public interface FormattableHandlerInterface {

	/**
	 * Sets the formatter.
	 *
	 * @return HandlerInterface this
	 */
	public abstract LogHandlerInterface setFormatter(LogFormatterInterface formatter);

	/**
	 * Gets the formatter.
	 */
	public abstract LogFormatterInterface getFormatter();

}
