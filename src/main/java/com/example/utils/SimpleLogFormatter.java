package com.example.utils;

import java.util.logging.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimpleLogFormatter extends Formatter {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String format(LogRecord record) {
        String timestamp = dtf.format(LocalDateTime.now());
        String level = record.getLevel().getName();
        String message = formatMessage(record);
        return String.format("%s [%s] %s%n", timestamp, level, message);
    }
}
