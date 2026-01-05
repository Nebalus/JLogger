package dev.nebalus.library.jlogger;

import java.util.Stack;

import dev.nebalus.library.jlogger.exception.LoggingLogicException;
import dev.nebalus.library.jlogger.handler.LogHandlerInterface;
import dev.nebalus.library.jlogger.processor.LogProcessorInterface;

public class LogChannel implements ResettableInterface {
	protected final String channelName;

	protected final Stack<LogHandlerInterface> handlers;
	protected final Stack<LogProcessorInterface> processors;

	public LogChannel(String channelName) {
		this.channelName = channelName;

		handlers = new Stack<>();
		processors = new Stack<>();
	}

	public LogChannel setHandlers(LogHandlerInterface... handlers) {
		this.handlers.clear();
		for (LogHandlerInterface handler : handlers) {
			pushHandler(handler);
		}
		return this;
	}

	public LogChannel pushHandler(LogHandlerInterface handler) {
		if (handler == null) {
			return this;
		}
		handlers.push(handler);
		return this;
	}

	public LogHandlerInterface popHandler() throws LoggingLogicException {
		if (handlers.size() == 0) {
			throw new LoggingLogicException("You tried to pop from an empty handler stack.");
		}
		return handlers.pop();
	}

	public LogChannel setProcessors(LogProcessorInterface... processors) {
		this.processors.clear();
		for (LogProcessorInterface processor : processors) {
			pushProcessor(processor);
		}
		return this;
	}

	public LogChannel pushProcessor(LogProcessorInterface processor) {
		if (processor == null) {
			return this;
		}
		processors.push(processor);
		return this;
	}

	public LogProcessorInterface popProcessor() throws LoggingLogicException {
		if (processors.size() == 0) {
			throw new LoggingLogicException("You tried to pop from an empty processor stack.");
		}
		return processors.pop();
	}

	public boolean isHandling(LogLevel logLevel) {
		for (LogHandlerInterface handler : handlers) {
			if (handler.isHandling(logLevel)) {
				return true;
			}
		}
		return false;
	}

	public String getChannelName() {
		return channelName;
	}

	public boolean addRecord(LogRecord logRecord, boolean isAsync) {
		if (!isHandling(logRecord.getLogLevel())) {
			return false;
		}

		boolean recordInitialized = processors.size() == 0;
		boolean isHandled = false;

		for (LogHandlerInterface handler : handlers) {
			if (recordInitialized == false) {
				if (!handler.isHandling(logRecord.getLogLevel())) {
					continue;
				}

				try {
					for (LogProcessorInterface processor : processors) {
						logRecord = processor.process(logRecord);
					}
				} catch (Throwable e) {
					e.printStackTrace();
					return true;
				}
			}

			// once the logRecord is initialized, send it to all handlers as long as the
			// bubbling chain is not interrupted
			try {
				isHandled = true;
				if (true == handler.handle((LogRecord) logRecord.clone())) {
					break;
				}
			} catch (Throwable e) {
				e.printStackTrace();
				return true;
			}
		}
		return isHandled;
	}

	/**
	 * Ends a log cycle and frees all resources used by handlers.
	 *
	 * Closing a Handler means flushing all buffers and freeing any open
	 * resources/handles. Handlers that have been closed should be able to accept
	 * log records again and re-open themselves on demand, but this may not always
	 * be possible depending on implementation.
	 *
	 * This is useful at the end of a request and will be called automatically on
	 * every handler when they get destructed.
	 */
	public void close() {
		for (LogHandlerInterface handler : handlers) {
			handler.close();
		}
	}

	/**
	 * Ends a log cycle and resets all handlers and processors to their initial
	 * state.
	 *
	 * Resetting a Handler or a Processor means flushing/cleaning all buffers,
	 * resetting internal state, and getting it back to a state in which it can
	 * receive log records again.
	 */
	@Override
	public void reset() {
		for (LogHandlerInterface handler : handlers) {
			if (handler instanceof ResettableInterface) {
				((ResettableInterface) handler).reset();
			}
		}

		for (LogProcessorInterface processor : processors) {
			if (processor instanceof ResettableInterface) {
				((ResettableInterface) processor).reset();
			}
		}
	}
}
