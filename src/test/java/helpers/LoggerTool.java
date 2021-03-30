package helpers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTool {

    private static Logger getLogger(){
         Logger log = LogManager.getRootLogger();
         return log;
    }

    public static void logInfo(String message){
        getLogger().info(message);
    }
}
