package org.dima12;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            int i =0;
            LoggerConfigLoader loader =  new LoggerConfigLoader();
            LoggerConfig config = loader.load("src/main/java/org/dima12/ConfigData.yaml");
            Logger logger = new Logger(config);
            while (i++ < 30){
                logger.debug("jojo");
                logger.info("Mojo");
            }
        }catch (IOException ex){
            throw new RuntimeException();

        }

    }
}
