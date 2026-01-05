package dev.nebalus.library.jlogger;

public enum LogLevel {
	EMERGENCY(0, true, true),
	ALERT(1, true, true),
	FATAL(2, true, true),
	ERROR(3, true, true),
	WARNING(4, true, false),
	INFO(5, true, false),
	DEFAULT(6, false, false),
	DEBUG(7, true, false),;

	private final int priority;
	private final boolean showNameInConsole;
	private final boolean isAnErrorIdentifier;

	LogLevel(int priority, boolean showNameInConsole, boolean isAnErrorIdentifier) {
		this.priority = priority;
		this.showNameInConsole = showNameInConsole;
		this.isAnErrorIdentifier = isAnErrorIdentifier;
	}

	public int getPriority() {
		return priority;
	}

	public boolean showNameInConsole() {
		return showNameInConsole;
	}

	public boolean isAnErrorIdentifier() {
		return isAnErrorIdentifier;
	}
}
