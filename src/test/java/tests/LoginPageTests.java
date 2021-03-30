package tests;

import drivers.DriverUtils;
import helpers.TestData;
import helpers.Urls;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

import static org.testng.Assert.assertEquals;

public class LoginPageTests extends TestBase{

    @Test(groups = {"positiveTests"})
    public void goToLoginPageAndTryToLoginUserWithInvalidCredentialsTest(){
        DriverUtils.visitPage(Urls.LOGIN_PAGE);

        LoginPage loginPage = new LoginPage();
        MyAccountPage myAccountPage = new MyAccountPage();

        loginPage
                .typeIntoEmailField(TestData.validUserLogin)
                .typeIntoPasswordField(TestData.validUserPass)
                .clickOnSubmitBtn();

        myAccountPage.verifyMyAccountPage();
    }

    @Test(groups = {"negativeTests"})
    public void goToLoginPageAndTryToLoginUserWithValidCredentialsTest(){
        DriverUtils.visitPage(Urls.LOGIN_PAGE);

        LoginPage loginPage = new LoginPage();
        loginPage
                .typeIntoEmailField("userDoesNotExist@notexist.com")
                .typeIntoPasswordField("FalsePassword")
                .clickOnSubmitBtn();
        assertEquals(loginPage.checkAuthenticationError(), "Authentication failed.");
    }
}
