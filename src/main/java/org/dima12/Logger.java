package org.dima12;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger extends AbstractLogger{

    LoggerConfig config;
    public File fileLog;

    public File getFileLog() {
        return fileLog;
    }

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a ");
    SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("dd_MM_yyyy-hh_mm_ss_ms");

    public Logger(LoggerConfig config) throws IOException {
        this.config = config;
        Files.createDirectories(Paths.get(config.getPath()));
        fileLog = new File(config.getPath() + "logos" + config.getFormat());
    }

    public void debug(String message) throws IOException {
        if (config.getLevel().ordinal() >= LoginLevel.DEBUG.ordinal())
            safeLogMessage(LoginLevel.DEBUG,message);

    }

    public void info(String message) throws IOException {
        if (config.getLevel().ordinal() >= LoginLevel.INFO.ordinal())
            safeLogMessage(LoginLevel.INFO,message);
    }


    private void safeLogMessage(LoginLevel level,String message) throws IOException {
        try {
            if (fileLog.length() > config.getMaxSize()) {
                logMessage(level,message);
            } else {
                throw new FileMaxSizeReachedException("file size ");
            }

        } catch (FileMaxSizeReachedException ex) {
            fileLog = new File(config.getPath() + "LOG_" + simpleTimeFormat.format(new Date()) + config.getFormat());
            logMessage(level, message);
        }

    }

    private void logMessage(LoginLevel level,String message) throws IOException {

        try (FileWriter fileWriter = new FileWriter(fileLog, true)) {
            fileWriter.write("[" + simpleDateFormat.format(new Date()) + "]" + "[" + level + "]" + "notification: " + message + "\n");
            fileWriter.write("\n");

        }
    }
}

