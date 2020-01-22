package tests;

import driver.DriverFactory;
import driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import pages.LogInPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;
    protected LogInPage logInPage;

    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver");
        //driver = new ChromeDriver();
        driver = DriverFactory.getManager(DriverType.FIREFOX).getDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

//    @AfterMethod
//    public void afterTest() {
//        driver.quit();
//    }
}
