package dev.nebalus.libary.logging;

import static dev.nebalus.common.Preconditions.requireNotNull;

import java.util.HashMap;

import dev.nebalus.common.Preconditions;

public class LoggerRegestry
{
	
	private static HashMap<String, Logger> registry;
	
	static {
		registry = new HashMap<>();
	}
	
    /**
     * Adds new logging channel to the registry
     *
     * @param  Logger                  $logger    Instance of the logging channel
     * @param  string|null             $name      Name of the logging channel (logger.getName() by default)
     * @param  boolean                 $overwrite Overwrite instance in the registry if the given name already exists?
     * 
     * @throws NullPointerException 	If the $logger is null
     * @throws InvalidArgumentException If $overwrite set to false and named Logger instance already exists
     */
	public static void addLogger(Logger logger, String name, boolean override) {
		requireNotNull(logger, "Logger");
		
		name =  Preconditions.isNull(name) ? logger.getChannelName() : name;
		
		
	}
}
