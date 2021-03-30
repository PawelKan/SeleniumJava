package pageObjects.MyAccountMyAddresses;

import drivers.DriverUtils;
import helpers.SeleniumHelper;
import helpers.WaitForElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertEquals;

public class MyAccountMyAddressesPage {

    @FindBy(className = "page-heading")
    WebElement labHeaderMyAddresses;

    @FindBy(css = "a[title=\"Update\"] > span")
    WebElement btnFirstAddressUpdateButton;

    @FindBy(css = "a[title=\"Delete\"] > span")
    WebElement btnFirstAddressDeleteButton;

    @FindBy(css = "a[title=\"Add an address\"] > span")
    WebElement btnAddNewAddress;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/a")
    WebElement btnBackToYourAccount;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/a/span")
    WebElement btnHome;

    @FindBy(css = "#center_column > div.addresses > div > div:nth-child(2) > ul")
    WebElement sectionSecondAddress;

//    @FindBy(linkText = "Update")
//    WebElement btnSecondAddressUpdate;
//
//    @FindBy(linkText = "Delete")
//    WebElement btnSecondAddressDelete;


    public MyAccountMyAddressesPage(){
        PageFactory.initElements(DriverUtils.setDriver(), this);
    }

    public void verifyPage(){
        assertEquals(labHeaderMyAddresses.getText().trim(), "MY ADDRESSES");
        assertEquals(btnFirstAddressUpdateButton.getText().trim(), "Update");
        assertEquals(btnFirstAddressDeleteButton.getText().trim(), "Delete");
        assertEquals(btnAddNewAddress.getText().trim(), "Add a new address");
        assertEquals(btnBackToYourAccount.getText().trim(), "Back to your account");
        assertEquals(btnHome.getText().trim(), "Home");
    }

    public void clickOnNewAddressButton() {
        btnAddNewAddress.click();
    }

    public void verifySecondAddressSection(){
        WaitForElement.waitUntilElementIsVisible(sectionSecondAddress);
        String update = sectionSecondAddress.findElement(By.linkText("Update")).getText();
        String delete = sectionSecondAddress.findElement(By.linkText("Delete")).getText();

        assertEquals(update,"Update");
        assertEquals(delete,"Delete");
    }

    public void deleteSecondAddress(){
        sectionSecondAddress.findElement(By.linkText("Delete")).click();
        SeleniumHelper.acceptAlert();
    }

    public void verifySecondAddressIsNotVisible(){
        WaitForElement.waitUntilElementIsNotVisible(sectionSecondAddress);
    }
}