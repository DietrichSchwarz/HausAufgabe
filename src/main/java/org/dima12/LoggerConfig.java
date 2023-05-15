package org.dima12;

public class LoggerConfig extends AbstractLoggerConfig{
    public LoginLevel level;
    String format;
    int maxSize;
    String path;

    public void setLevel(LoginLevel level) {
        this.level = level;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LoggerConfig(){

    }
    public LoggerConfig(LoginLevel level, String format, int maxSize, String path) {
        this.level = level;
        this.format = format;
        this.maxSize = maxSize;
        this.path = path;
    }

    public LoginLevel getLevel() {
        return level;
    }

    public String getFormat() {
        return format;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getPath() {
        return path;
    }
}

