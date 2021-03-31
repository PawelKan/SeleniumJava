package tests;

import drivers.DriverUtils;
import helpers.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MyAccountMyAddresses.AddNewAddressFormSection;
import pageObjects.MyAccountMyAddresses.MyAccountMyAddressesPage;
import pageObjects.MyAccountPage;

@Listeners(ListenerHelper.class)
public class MyAccountTests extends TestBase{

    @Test(groups = {"positiveTests"})
    public void loginIntoAppVerifyMyAccountAddNewAddressAndDeleteIt(){

        LoginPage loginPage = new LoginPage();
        MyAccountPage myAccount = new MyAccountPage();
        MyAccountMyAddressesPage myAddressesPage = new MyAccountMyAddressesPage();
        AddNewAddressFormSection addNewAddressSection = new AddNewAddressFormSection();


        LoggerTool.logInfo("TEST STEP: Go to LoginPage");
        DriverUtils.visitPage(Urls.LOGIN_PAGE);

        LoggerTool.logInfo("TEST STEP: Login into Application");
        loginPage.actionLoginIntoApp(TestData.validUserLogin, TestData.validUserPass);

        LoggerTool.logInfo("TEST STEP: Click on My Addresses");
        myAccount.clickOnMyAddressBtn();

        LoggerTool.logInfo("TEST STEP: Verify My Addresses page");
        myAddressesPage.verifyPage();

        LoggerTool.logInfo("TEST STEP: Click on Add a new address button");
        myAddressesPage.clickOnNewAddressButton();

        LoggerTool.logInfo("TEST STEP: Fill all fields in form witch correct data");
        addNewAddressSection.fillFormWithData();

        LoggerTool.logInfo("TEST STEP: Click on Save Button");
        addNewAddressSection.clickOnSave();

        LoggerTool.logInfo("TEST STEP: Verify new address");
        addNewAddressSection.verifySecondAddressSection();

        LoggerTool.logInfo("TEST STEP: Delete second address");
        addNewAddressSection.deleteSecondAddress();

        LoggerTool.logInfo("TEST STEP: Verify - second address is not visible");
        addNewAddressSection.verifySecondAddressIsNotVisible();
        Screenshooter.createScreenshoot("loginIntoAppVerifyMyAccountAddNewAddressAndDeleteIt");
    }
}
