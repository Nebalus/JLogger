package dev.nebalus.libary.logging.processor;

import dev.nebalus.libary.logging.LogRecord;

public class TestProcessor implements LogProcessorInterface {

	@Override
	public LogRecord process(LogRecord logRecord) throws Exception
	{
		logRecord.extras.put("TEST", "HALLO WELT");
		logRecord.extras.put("42", "Die Antwort auf alles");
		return logRecord;
	}

}
