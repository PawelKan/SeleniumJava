package tests;

import drivers.DriverUtils;
import helpers.Urls;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import static org.testng.Assert.assertEquals;

public class HomePageTests {
    @Test
    public void verifyHomePageAndClickOnContactUsButtonTest(){
        DriverUtils.visitPage(Urls.BASE_URL);
        String titleMessage;

        HomePage homePage = new HomePage();

        titleMessage = DriverUtils.returnPageTitleText();
        assertEquals(titleMessage, "My Store");

        homePage.clickOnContactUs();

        titleMessage = DriverUtils.returnPageTitleText();
        assertEquals(titleMessage, "Contact us - My Store");
    }

    @Test
    public void verifyHomePageAndClickOnSignInButtonTest(){
        DriverUtils.visitPage(Urls.BASE_URL);
        String titleMessage;

        HomePage homePage = new HomePage();

        titleMessage = DriverUtils.returnPageTitleText();
        assertEquals(titleMessage, "My Store");

        homePage.clickOnSignIn();
        titleMessage = DriverUtils.returnPageTitleText();
        assertEquals(titleMessage, "Login - My Store");
    }
}
