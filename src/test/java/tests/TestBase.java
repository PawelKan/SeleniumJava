package tests;
import drivers.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeMethod
    public void beforeTest(){
        DriverUtils.setDriver();
    }

    @AfterMethod
    public void afterTest(){
        DriverUtils.closeAndQuitDriver();
    }
}
