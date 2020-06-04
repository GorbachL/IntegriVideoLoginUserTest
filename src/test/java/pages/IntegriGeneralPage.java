package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IntegriGeneralPage extends BasePage {

    public static final String URL = "https://dev.integrivideo.com/login";
    public static final By LOG_IN_BUTTON = By.xpath("//button[text() = 'Log in']");
    public static final By LOG_IN_LINK = By.xpath("//*[text() = 'Log in']");
    public static final By SIGN_UP_LINK = By.xpath("//*[text() = 'Sign up']");
    public static final By SIGN_UP_BUTTON = By.xpath("//button[text() = 'Sign up']");
    public static final By FORGOT_LINK = By.cssSelector("a.forgot");


    public IntegriGeneralPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {

    }

    public void isPageOpened() {

    }
}
