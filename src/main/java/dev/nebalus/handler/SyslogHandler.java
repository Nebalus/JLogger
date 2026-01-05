package dev.nebalus.libary.logging.handler;

import dev.nebalus.libary.logging.LogLevel;
import dev.nebalus.libary.logging.LogRecord;

public class SyslogHandler extends AbstractProcessingHandler {

	public SyslogHandler(LogLevel logLevel, boolean bubble) {
		super(logLevel, bubble);
	}

	@Override
	protected void write(LogRecord logRecord)
	{
		if(logRecord.getLogLevel().isAnErrorIdentifier()) {
			System.err.println(logRecord.formatted);
		} else {
			System.out.println(logRecord.formatted);
		}
	}
}
