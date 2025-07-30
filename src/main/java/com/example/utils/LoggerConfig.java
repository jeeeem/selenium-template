package com.example.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerConfig {

  public static void setup() {
    Logger rootLogger = Logger.getLogger("com.example");
    rootLogger.setLevel(Level.FINE);

    // Disable parent handlers to prevent duplicate logs
    rootLogger.setUseParentHandlers(false);

    // Add new console handler with custom formatter
    ConsoleHandler handler = new ConsoleHandler();
    Formatter formatter = new SimpleLogFormatter();
    handler.setLevel(Level.FINE);
    handler.setFormatter(formatter);
    rootLogger.addHandler(handler);
    System.out.println("Logger configured: level=FINE");
  }
}
