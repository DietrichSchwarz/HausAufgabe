import org.dima12.Logger;
import org.dima12.LoggerConfig;
import org.dima12.LoggerConfigLoader;
import org.dima12.LoginLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerTest {
    @Test
    public void testCreateLogFile() throws IOException {
        LoggerConfigLoader loader =  new LoggerConfigLoader();
        LoggerConfig config = loader.load("src/main/java/org/dima12/ConfigData.yaml");
        Logger logger = new Logger(config);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss a ");
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("dd_MM_yyyy-hh_mm_ss_ms");

        logger.debug("haha");

        File expectedFile = new File(config.getPath() + "LOG_" + simpleTimeFormat.format(new Date()) + config.getFormat());

       Assertions.assertEquals(expectedFile.getAbsolutePath(), logger.fileLog.getAbsolutePath());
       Assertions.assertTrue(logger.getFileLog().exists());
    }




    }




