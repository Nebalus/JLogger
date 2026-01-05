package dev.nebalus.library.jlogger.processor;

import dev.nebalus.library.jlogger.LogRecord;

public class Test2Processor implements LogProcessorInterface {

	@Override
	public LogRecord process(LogRecord logRecord) throws Exception
	{
		logRecord.extras.put("1", "Nah du nudel");
		return logRecord;
	}

}
