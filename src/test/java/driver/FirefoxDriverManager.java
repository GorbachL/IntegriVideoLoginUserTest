package driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {


    protected void createDriver() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/webdrivers/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        //options.addArguments("--headless");
        driver = new FirefoxDriver(options);
    }
}
