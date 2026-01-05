package dev.nebalus.library.jlogger.handler;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.ResettableInterface;

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
