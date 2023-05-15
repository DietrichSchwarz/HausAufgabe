package org.dima12;

import java.io.IOException;

public abstract class AbstractLogger {
    public abstract void info (String massage) throws IOException;
    public abstract void debug(String message) throws IOException;
}

