package dev.nebalus.library.jlogger.handler;

import dev.nebalus.library.jlogger.exception.LoggingLogicException;
import dev.nebalus.library.jlogger.processor.LogProcessorInterface;

public interface ProcessableHandlerInterface {

	public abstract LogHandlerInterface pushProcessor(LogProcessorInterface logProcessor);

	public abstract LogProcessorInterface popProcessor() throws LoggingLogicException;

}
