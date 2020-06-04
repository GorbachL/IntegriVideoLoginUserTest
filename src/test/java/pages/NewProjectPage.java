package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewProjectPage extends BasePage {

    private By NAME = By.name("name");
    private By DESCRIPTION = By.xpath("//textarea[@name='description']");
    private By DOMAINS_INPUT = By.name("domains[]");
    private By CREATE_BUTTON = By.xpath("//button[text()='Create']");

    public NewProjectPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/app/projects/new");
        isPageOpened();
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CREATE_BUTTON));
        } catch (TimeoutException ex) {
            throw new TimeoutException("Page is not opened");
        }
    }

    public NewProjectPage fillInFields(Project project) {
        driver.findElement(NAME).sendKeys(project.getName());
        driver.findElement(DESCRIPTION).sendKeys(project.getDescription());
        for (int i = 0; i < project.getDomains().size(); i++) {
            driver.findElements(DOMAINS_INPUT).get(i).sendKeys(project.getDomains().get(i));
        }
        return this;
    }

    public NewProjectPage clickCreate() {
        driver.findElement(CREATE_BUTTON).click();
        return this;
    }
}
