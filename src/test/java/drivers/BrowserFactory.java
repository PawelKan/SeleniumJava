package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserFactory {

    public static WebDriver getBrowser(BrowserType BROWSER_TYPE){
        switch(BROWSER_TYPE){
            case CHROME:
                System.setProperty("webdriver.chrome.driver", "src/Drivers/chromedriver.exe");
                return new ChromeDriver();
            case FIREFOX:
                System.setProperty("webdriver.gecko.driver", "src/Drivers/geckodriver.exe");
                return new FirefoxDriver();
            case EDGE:
                System.setProperty("webdriver.edge.driver", "src/Drivers/msedgedriver.exe");
                return new EdgeDriver();
            default:
                throw new IllegalStateException("Unknown browser type! Please check configuration later");
        }
    }
}
