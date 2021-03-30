package pageObjects;

import drivers.DriverUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.MyAccountMyAddresses.MyAccountMyAddressesPage;

import static org.testng.Assert.assertEquals;

public class MyAccountPage {

    private Logger logger = LogManager.getRootLogger();

    public MyAccountPage(){
        PageFactory.initElements(DriverUtils.setDriver(), this);
    }

    @FindBy (css = ".myaccount-link-list a[title=\"Orders\"]")
    WebElement btnOrderHistoryAndDetails;

    @FindBy (css = ".myaccount-link-list a[title=\"Credit slips\"]")
    WebElement btnMyCreditSlips;

    @FindBy (css = ".myaccount-link-list a[title=\"Addresses\"]")
    WebElement btnMyAddresses;

    @FindBy (css = ".myaccount-link-list a[title=\"Information\"]")
    WebElement btnMyPersonalInformation;

    @FindBy (css = ".myaccount-link-list a[title=\"My wishlists\"]")
    WebElement btnMyWishlists;

    public MyAccountMyAddressesPage clickOnMyAddressBtn(){
        btnMyAddresses.click();
        return new MyAccountMyAddressesPage();
    }

    public MyAccountPage verifyMyAccountPage(){
        String[] textInElements = {"ORDER HISTORY AND DETAILS", "MY CREDIT SLIPS", "MY ADDRESSES", "MY PERSONAL INFORMATION", "MY WISHLISTS"};

        logger.info("Get text from field: Order history and details");
        String textOrderHistoryAndDetails = btnOrderHistoryAndDetails.getText();

        logger.info("Get text from field: My credit slips");
        String textMyCreditSlips = btnMyCreditSlips.getText();

        logger.info("Get text from field: My addresses");
        String textMyAddresses = btnMyAddresses.getText();

        logger.info("Get text from field: My personal information");
        String textMyPersonalInformation = btnMyPersonalInformation.getText();

        logger.info("Get text from field: My wishlist");
        String textMyWishlists = btnMyWishlists.getText();

        logger.info("Assert element texts");
        assertEquals(textOrderHistoryAndDetails, textInElements[0]);
        assertEquals(textMyCreditSlips, textInElements[1]);
        assertEquals(textMyAddresses, textInElements[2]);
        assertEquals(textMyPersonalInformation, textInElements[3]);
        assertEquals(textMyWishlists, textInElements[4]);

        return this;
    }
}
