package pageObjects;

import drivers.DriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helpers.WaitForElement;

public class LoginPage {

    private Logger logger = LogManager.getRootLogger();

    public LoginPage(){
        PageFactory.initElements(DriverUtils.setDriver(), this);
    }

    @FindBy (css = "#login_form > .page-subheading")
    WebElement labAlreadyRegistered;

    @FindBy (css = "#email")
    WebElement txtLoginEmailAddress;

    @FindBy (css = "#passwd")
    WebElement txtLoginPassword;

    @FindBy(css = ".lost_password > a")
    WebElement linkForgetYourPassword;

    @FindBy (css = "#SubmitLogin > span")
    WebElement btnSubmitSignIn;

    @FindBy (css = "ol > li")
    WebElement messageAuthenticationError;

    public LoginPage typeIntoEmailField(String email){
        logger.info("Clear and Type into: Email Field");
        WaitForElement.waitUntilElementIsVisible(txtLoginEmailAddress);
        txtLoginEmailAddress.clear();
        txtLoginEmailAddress.sendKeys(email);
        return this;
    }

    public LoginPage typeIntoPasswordField(String password){
        logger.info("Clear and Type into: Password");
        txtLoginPassword.clear();
        txtLoginPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickOnSubmitBtn(){
        logger.info("Click on: Submit button");
        btnSubmitSignIn.click();
        return this;
    }

    public MyAccountPage actionLoginIntoApp(String username, String password){
        typeIntoEmailField(username);
        typeIntoPasswordField(password);
        clickOnSubmitBtn();

        return new MyAccountPage();
    }

    public String checkAuthenticationError(){
        return messageAuthenticationError.getText();
    }
}
