package dev.nebalus.libary.logging.processor;

import dev.nebalus.libary.logging.LogRecord;

public class Test2Processor implements LogProcessorInterface {

	@Override
	public LogRecord process(LogRecord logRecord) throws Exception
	{
		logRecord.extras.put("1", "Nah du nudel");
		return logRecord;
	}

}
