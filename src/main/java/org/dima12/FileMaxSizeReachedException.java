package org.dima12;

public class FileMaxSizeReachedException extends RuntimeException{
    public FileMaxSizeReachedException(String message){
        super(message);
    }
}
