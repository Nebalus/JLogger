package dev.nebalus.libary.logging.formatter;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dev.nebalus.libary.logging.LogRecord;

public class JsonFormatter implements LogFormatterInterface {

	@Override
	public LogRecord format(LogRecord logRecord)
	{
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(buildJsonFieldString("timestamp", logRecord.getDate()) + ",");
		sb.append(buildJsonFieldString("log_level", logRecord.getLogLevel().name()) + ",");
		sb.append(buildJsonFieldString("channel_name", logRecord.getChannelName()) + ",");
		sb.append(buildJsonFieldString("thread_name", logRecord.getThreadName()) + ",");
		sb.append(buildJsonFieldString("message", logRecord.getMessage()) + ",");
		sb.append(buildJsonField("is_a_throwable", logRecord.isAThrowable()) + ",");
		sb.append(buildJsonFieldString("throwable", logRecord.getThrowable()) + ",");
		
		Gson gson = new Gson();
	    @SuppressWarnings("rawtypes")
		Type typeObject = new TypeToken<HashMap>() {}.getType();
		sb.append(buildJsonField("extras", gson.toJson(logRecord.extras, typeObject)));
		
		sb.append("}");
		logRecord.formatted = sb.toString();
		return logRecord;
	}

	private String buildJsonFieldString(String fieldName, Object content)
	{
		return "\"" + fieldName + "\":\"" + content + "\"";
	}

	private String buildJsonField(String fieldName, Object content)
	{
		return "\"" + fieldName + "\":" + content + "";
	}

}
