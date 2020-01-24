package tests;

import driver.DriverFactory;
import driver.DriverManager;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class FactoryPatternTest {
    private DriverManager driverManager;
    private WebDriver driver;

    @AfterMethod
    public void afterMethod() {
        driverManager.quitDriver();
    }

    @Test
    public void launchTestAutomationGuruTest() {
        driverManager = DriverFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("http://testautomationguru.com");
        Assert.assertEquals("Vinsguru", driver.getTitle());
    }

    @Test
    public void launchGoogleTest() {
        driverManager = DriverFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("https://www.google.com");
        Assert.assertEquals("Google", driver.getTitle());
    }

    @Test
    public void launchYahooTest() {
        driverManager = DriverFactory.getManager(DriverType.CHROME);
        driver = driverManager.getDriver();
        driver.get("https://www.yahoo.com");
        Assert.assertEquals("Yahoo", driver.getTitle());
    }
}
