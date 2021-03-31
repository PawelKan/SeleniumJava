package helpers;

import drivers.DriverUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Screenshooter {

    public static void createScreenshoot(String fileName){
        try {
            File screenshotFile = ((TakesScreenshot) DriverUtils.setDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshotFile, new File("src/main/resources/screenshots/" + fileName + ".jpg"));
        }
        catch(IOException e){
            LoggerTool.logInfo("Error with screenshot file");
            e.printStackTrace();
        }

    }
}
