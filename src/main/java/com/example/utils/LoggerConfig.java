package com.example.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

public class LoggerConfig {

  public static void setup() {
    Configurator.setRootLevel(Level.DEBUG);
  }
}
