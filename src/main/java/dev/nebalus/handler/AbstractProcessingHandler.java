package dev.nebalus.libary.logging.handler;

import java.util.Stack;

import dev.nebalus.libary.logging.LogLevel;
import dev.nebalus.libary.logging.LogRecord;
import dev.nebalus.libary.logging.ResettableInterface;
import dev.nebalus.libary.logging.exception.LoggingLogicException;
import dev.nebalus.libary.logging.formatter.LineFormatter;
import dev.nebalus.libary.logging.formatter.LogFormatterInterface;
import dev.nebalus.libary.logging.processor.LogProcessorInterface;

public abstract class AbstractProcessingHandler extends AbstractHandler implements FormattableHandlerInterface, ProcessableHandlerInterface {

	protected final Stack<LogProcessorInterface> processors;
	protected LogFormatterInterface formatter;

	public AbstractProcessingHandler(LogLevel logLevel, boolean bubble) {
		super(logLevel, bubble);
		processors = new Stack<>();
	}

	@Override
	public boolean handle(LogRecord logRecord) throws Exception
	{
		if (!isHandling(logRecord.getLogLevel())) {
			return false;
		}
		
		if(processors.size() > 0) {
			for (LogProcessorInterface processor : processors) {
				logRecord = processor.process(logRecord);
			}
		}
		
		logRecord = getFormatter().format(logRecord);

		write(logRecord);

		return !bubble;
	}

	@Override
	public LogHandlerInterface setFormatter(LogFormatterInterface formatter)
	{
		this.formatter = formatter;

		return this;
	}

	@Override
	public LogFormatterInterface getFormatter()
	{
		if (formatter == null) {
			formatter = getDefaultFormatter();
		}

		return formatter;
	}

	protected LogFormatterInterface getDefaultFormatter()
	{
		return new LineFormatter();
	}

	@Override
	public LogHandlerInterface pushProcessor(LogProcessorInterface processor)
	{
		if (processor == null) {
			return this;
		}
		processors.push(processor);
		return this;
	}

	@Override
	public LogProcessorInterface popProcessor() throws LoggingLogicException
	{
		if (processors.size() == 0) {
			throw new LoggingLogicException("You tried to pop from an empty processor stack.");
		}
		return processors.pop();
	}

	protected void resetProcessors()
	{
		processors.forEach(processor -> {
			if (processor instanceof ResettableInterface) {
				((ResettableInterface) processor).reset();
			}
		});
	}

	@Override
	public void reset() {
		super.reset();
		
		resetProcessors();
	}
	
	/**
	 * Writes the (already formatted) record down to the log of the implementing
	 * handler
	 */
	protected abstract void write(LogRecord logRecord);	
}
