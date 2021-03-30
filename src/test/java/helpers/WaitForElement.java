package helpers;

import drivers.DriverUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitForElement {

    private static WebDriverWait getWebDriverWait(){
        return new WebDriverWait(DriverUtils.setDriver(), Duration.ofSeconds(15));
    }

    public static void waitUntilElementIsVisible(WebElement element){
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebElement element){
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitUntilElementIsNotVisible(WebElement element){
            getWebDriverWait()
                    .ignoring(NoSuchElementException.class)
                    .until(ExpectedConditions.invisibilityOf(element));
    }
}
