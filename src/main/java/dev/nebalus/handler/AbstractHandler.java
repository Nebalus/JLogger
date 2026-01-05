package dev.nebalus.libary.logging.handler;

import dev.nebalus.libary.logging.LogLevel;
import dev.nebalus.libary.logging.ResettableInterface;

public abstract class AbstractHandler extends LogHandler implements ResettableInterface {

	protected LogLevel logLevel = LogLevel.DEBUG;
	protected boolean bubble = true;

	public AbstractHandler(LogLevel logLevel, boolean bubble) {
		this.logLevel = logLevel;
		this.bubble = bubble;
	}

	@Override
	public boolean isHandling(LogLevel logLevel)
	{
		return logLevel.getPriority() <= this.logLevel.getPriority();
	}

	public void setLogLevel(LogLevel logLevel)
	{
		this.logLevel = logLevel;
	}

	public LogLevel getLogLevel()
	{
		return logLevel;
	}

	public void setBubble(boolean bubble)
	{
		this.bubble = bubble;
	}

	public boolean getBubble()
	{
		return bubble;
	}

	@Override
	public void reset()
	{
	}
}
