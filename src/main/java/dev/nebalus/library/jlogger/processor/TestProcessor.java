package dev.nebalus.library.jlogger.processor;

import dev.nebalus.library.jlogger.LogRecord;

public class TestProcessor implements LogProcessorInterface {

	@Override
	public LogRecord process(LogRecord logRecord) throws Exception
	{
		logRecord.extras.put("TEST", "HALLO WELT");
		logRecord.extras.put("42", "Die Antwort auf alles");
		return logRecord;
	}

}
