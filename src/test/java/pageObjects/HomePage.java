package pageObjects;

import drivers.DriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private Logger logger = LogManager.getRootLogger();

    @FindBy(css = "#contact-link > a[title=\"Contact Us\"]")
    private WebElement ContactUs;

    @FindBy(css = ".login")
    private WebElement SignIn;

    @FindBy(css = ".logout")
    private WebElement SignOut;

    public HomePage(){
        PageFactory.initElements(DriverUtils.setDriver(),this);
    }

    public void clickOnSignIn(){
        logger.info("Click on Sign In Button");
        SignIn.click();
    }

    public void clickOnContactUs(){
        logger.info("Click on Contact Us");
        ContactUs.click();
    }




}
