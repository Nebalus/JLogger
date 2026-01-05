package dev.nebalus.library.jlogger.handler;

import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.LogRecord;

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
