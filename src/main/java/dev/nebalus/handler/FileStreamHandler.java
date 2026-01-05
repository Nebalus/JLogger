package dev.nebalus.libary.logging.handler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import dev.nebalus.libary.logging.LogLevel;
import dev.nebalus.libary.logging.LogRecord;

public class FileStreamHandler extends AbstractProcessingHandler {

	protected File file;
	protected FileWriter fileWriter;
	protected BufferedWriter bufferedWriter;

	public FileStreamHandler(File file, LogLevel logLevel, boolean bubble) {
		super(logLevel, bubble);
		this.file = file;
		try {
			fileWriter = new FileWriter(file, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		bufferedWriter = new BufferedWriter(fileWriter);
	}

	@Override
	protected void write(LogRecord logRecord)
	{
		try {
			streamWrite(logRecord);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void streamWrite(LogRecord logRecord) throws IOException
	{
		bufferedWriter.write(logRecord.formatted + "\n");
		bufferedWriter.flush();
	}

	@Override
	public void close()
	{
		try {
			bufferedWriter.flush();
		} catch (IOException e) {
		}
	}
}
