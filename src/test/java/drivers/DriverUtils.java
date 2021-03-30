package drivers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class DriverUtils {

    private static WebDriver driver;
    private static final BrowserType BROWSER_TYPE = BrowserType.FIREFOX;
    private static Logger logger = LogManager.getRootLogger();

    private DriverUtils(){
    }

    public static WebDriver setDriver(){
        if (driver == null){
            logger.info("Create driver");
            driver = BrowserFactory.getBrowser(BROWSER_TYPE);

            logger.info("Maximize driver window");
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeAndQuitDriver(){
        logger.info("Close driver");
        driver.close();

        if(!BROWSER_TYPE.equals(BrowserType.FIREFOX)){
            logger.info("Quit driver");
            driver.quit();
        }

        logger.info("Delete driver (null)");
        driver = null;
    }

    public static void visitPage(String urlToPage){
        logger.info("Visit page {}", urlToPage);
        setDriver().navigate().to(urlToPage);
    }

    public static String returnPageTitleText(){
        logger.info("Return page title");
        return setDriver().getTitle();
    }
}
