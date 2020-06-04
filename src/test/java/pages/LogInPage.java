package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {

    @FindBy(name = "email")
    WebElement emailInput;
    @FindBy(name = "password")
    WebElement passwordInput;
    @FindBy(id = "login-form")
    WebElement logInForm;
    @FindBy(className = "forgot")
    WebElement forgotLink;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/login");
        isPageOpened();
        PageFactory.initElements(driver, LogInPage.this);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-form")));
        } catch (TimeoutException ex) {
            System.out.println("Page is not opened");
            throw new TimeoutException("Page is not opened");
        }
    }

    public IntegriProjectsPage login(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        logInForm.submit();
        IntegriProjectsPage projects = new IntegriProjectsPage(driver);
        projects.isPageOpened();
        return projects;
    }
}
