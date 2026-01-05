# JLogger

A lightweight, flexible Java logging library with ANSI color support, multiple output handlers, and customizable formatters.

## Features

- **8 Log Levels**: EMERGENCY, ALERT, FATAL, ERROR, WARNING, INFO, DEFAULT, DEBUG
- **ANSI Color Support**: Colorized console output with customizable color schemes
- **Multiple Handlers**: Console (SyslogHandler), File (FileStreamHandler)
- **Flexible Formatters**: Plain text, colored, and JSON output
- **Processors**: Transform log records before output
- **Channel-based Logging**: Organize logs by named channels
- **Handler Bubbling**: Route logs through multiple handlers

## Installation

### Maven

Add to your `pom.xml`:

```xml
<dependency>
    <groupId>dev.nebalus.library.jlogger</groupId>
    <artifactId>jlogger</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Quick Start

```java
import dev.nebalus.library.jlogger.Logger;
import dev.nebalus.library.jlogger.LogLevel;
import dev.nebalus.library.jlogger.handler.SyslogHandler;

public class App {
    public static void main(String[] args) {
        // Create logger
        Logger logger = new Logger("MyApp");
        
        // Add console handler
        logger.pushHandler(new SyslogHandler(LogLevel.DEBUG, false));
        
        // Log messages
        logger.info("Application started");
        logger.warning("Low memory: %d MB remaining", 256);
        logger.error(MyClass.class, "Connection failed");
        
        logger.close();
    }
}
```

## Log Levels

| Level | Priority | Description |
|-------|----------|-------------|
| EMERGENCY | 0 | System is unusable |
| ALERT | 1 | Immediate action required |
| FATAL | 2 | Critical error |
| ERROR | 3 | Error condition |
| WARNING | 4 | Warning condition |
| INFO | 5 | Informational |
| DEFAULT | 6 | Default messages |
| DEBUG | 7 | Debug information |

## Formatters

### LineFormatter (Default)
Plain text format: `[HH:mm:ss] [thread LEVEL] (channel): message`

```java
handler.setFormatter(new LineFormatter());
```

### ColorLineFormatter
ANSI-colored console output:

```java
handler.setFormatter(new ColorLineFormatter(
    new DefaultColorScheme(), 
    null, 
    "HH:mm:ss"
));
```

### JsonFormatter
Structured JSON output for log aggregation:

```java
handler.setFormatter(new JsonFormatter());
// Output: {"timestamp":"...","log_level":"INFO","message":"...","extras":{}}
```

## Handlers

### SyslogHandler
Console output (stdout/stderr based on level):

```java
// Log INFO and above to console
SyslogHandler console = new SyslogHandler(LogLevel.INFO, false);
logger.pushHandler(console);
```

### FileStreamHandler
File output:

```java
FileStreamHandler file = new FileStreamHandler(
    new File("app.log"), 
    LogLevel.DEBUG, 
    false
);
logger.pushHandler(file);
```

### Multiple Handlers
Combine handlers with bubbling:

```java
// File handler logs everything
logger.pushHandler(new FileStreamHandler(logFile, LogLevel.DEBUG, true));
// Console shows INFO+ (bubble=true passes to next handler)
logger.pushHandler(new SyslogHandler(LogLevel.INFO, false));
```

## Examples

See the [`examples/`](examples/) directory for runnable demonstrations:

- **BasicLoggingExample.java** - All log levels and message formatting
- **ColoredOutputExample.java** - ANSI color schemes
- **FileLoggingExample.java** - File logging with multiple handlers
- **JsonLoggingExample.java** - Structured JSON output with processors

## Building

```bash
mvn compile
```

## License

MIT License - see [LICENSE](LICENSE)
