package dev.nebalus.libary.logging.handler;

import dev.nebalus.libary.logging.formatter.LogFormatterInterface;

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
