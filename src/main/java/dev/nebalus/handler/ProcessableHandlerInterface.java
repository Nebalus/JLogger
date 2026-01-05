package dev.nebalus.libary.logging.handler;

import dev.nebalus.libary.logging.exception.LoggingLogicException;
import dev.nebalus.libary.logging.processor.LogProcessorInterface;

public interface ProcessableHandlerInterface {

	public abstract LogHandlerInterface pushProcessor(LogProcessorInterface logProcessor);

	public abstract LogProcessorInterface popProcessor() throws LoggingLogicException;

}
