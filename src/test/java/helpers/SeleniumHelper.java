package helpers;

import drivers.DriverUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumHelper {

    public static void clearAndType(WebElement element, String textToType){
        LoggerTool.logInfo("Clear and type into Field");
        element.clear();
        element.sendKeys(textToType);
    }

    public static void selectElementInDropDownByValue(WebElement element, String value){
        LoggerTool.logInfo("Choose value in drop down");
        Select select = new Select(element);
        select.selectByValue(value);
    }

    public static void selectElementInDropDownByText(WebElement element, String visibleText){
        LoggerTool.logInfo("Choose value in drop down");
        Select select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void acceptAlert(){
        DriverUtils.setDriver().switchTo().alert().accept();
    }

    public static Boolean isElementVisible(WebElement element){
        try{
            return element.isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }
}
