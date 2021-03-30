package pageObjects.MyAccountMyAddresses;

import drivers.DriverUtils;
import helpers.SeleniumHelper;
import helpers.WaitForElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.MyAccountPage;

public class AddNewAddressFormSection extends MyAccountMyAddressesPage{

    public AddNewAddressFormSection(){
        PageFactory.initElements(DriverUtils.setDriver(), this);
    }

    @FindBy (id = "firstname")
    WebElement txtFirstNameRequired;

    @FindBy(id = "lastname")
    WebElement txtLastNameRequired;

    @FindBy(id = "company")
    WebElement txtCompany;

    @FindBy(id = "address1")
    WebElement txtAddressesRequired;

    @FindBy(id = "address2")
    WebElement txtAddresses2ndLine;

    @FindBy(id = "city")
    WebElement txtCityRequired;

    @FindBy(id = "id_state")
    WebElement dropDownStateRequired;

    @FindBy(id = "postcode")
    WebElement zipPostalCodeRequired;

    @FindBy(id = "id_country")
    WebElement dropDownCountryRequired;

    @FindBy(id = "phone")
    WebElement txtHomePhoneRequired;

    @FindBy(id = "phone_mobile")
    WebElement txtMobilePhoneRequired;

    @FindBy(id = "other")
    WebElement txtAddtionalInfo;

    @FindBy(id = "alias")
    WebElement txtAddressReference;

    @FindBy(css= "#submitAddress > span")
    WebElement btnSave;



    public AddNewAddressFormSection fillFormWithData(){
        WaitForElement.waitUntilElementIsVisible(txtFirstNameRequired);

        SeleniumHelper.clearAndType(txtFirstNameRequired, "SeleniumFirstName");
        SeleniumHelper.clearAndType(txtLastNameRequired, "SeleniumLastName");
        SeleniumHelper.clearAndType(txtCompany, "SeleniumCompanyName");
        SeleniumHelper.clearAndType(txtAddressesRequired, "SeleniumAddressRequired");
        SeleniumHelper.clearAndType(txtAddresses2ndLine, "SeleniumAddressSecondLine");
        SeleniumHelper.clearAndType(txtCityRequired, "SeleniumCityName");
        SeleniumHelper.selectElementInDropDownByText(dropDownStateRequired, "Alaska");
        SeleniumHelper.clearAndType(zipPostalCodeRequired, "12345");
        SeleniumHelper.selectElementInDropDownByText(dropDownCountryRequired, "United States");
        SeleniumHelper.clearAndType(txtHomePhoneRequired, "789456123");
        SeleniumHelper.clearAndType(txtMobilePhoneRequired, "+48123456789");
        SeleniumHelper.clearAndType(txtAddtionalInfo, "SeleniumAdditionalInformation");
        SeleniumHelper.clearAndType(txtAddressReference, "SelniumAddressReferenceE");

        return this;
    }

    public MyAccountPage clickOnSave(){
        WaitForElement.waitUntilElementIsClickable(btnSave);
        btnSave.click();

        return new MyAccountPage();
    }




}

