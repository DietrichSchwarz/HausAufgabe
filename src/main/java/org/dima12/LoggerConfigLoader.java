package org.dima12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoggerConfigLoader extends AbstractLoggerConfigLoader{

    public LoggerConfig load(String con){
        LoggerConfig fileLoggerConfiguration =new LoggerConfig();
        try(BufferedReader read = new BufferedReader(new FileReader(con))) {
            String str = read.readLine();
            while (str != null){
                String[] array = str.split(":");
                if (array.length == 2){
                    String key = array[0].trim();
                    String value = array[1].trim();
                    switch (key) {
                        case "FILE" -> fileLoggerConfiguration.setPath(value);
                        case "LEVEL" -> fileLoggerConfiguration.setLevel(LoginLevel.valueOf(value));
                        case "MAX-SIZE" -> fileLoggerConfiguration.setMaxSize(Integer.parseInt(value));
                        case "FORMAT" -> fileLoggerConfiguration.setFormat(value);

                    }
                }
                str = read.readLine();

            }

        }catch (IOException ex){
            throw new RuntimeException(ex);
        }
        return fileLoggerConfiguration;

    }

}
