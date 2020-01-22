package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IntegriProjectsPage extends BasePage {


    By ADD_PROJECT_BUTTON = By.xpath("//div[text()='Add project']");
    By SINGLE_PROJECT_ELEMENTS = By.className("project");

    public IntegriProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/app/projects");
        isPageOpened();
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ADD_PROJECT_BUTTON));
        } catch (TimeoutException ex) {
            throw new TimeoutException("Page is not opened");
        }
    }

    public IntegriProjectsPage createProject(Project project) {
        driver.findElement(ADD_PROJECT_BUTTON).click();
        NewProjectPage projectPage = new NewProjectPage(driver);
        projectPage.isPageOpened();
        projectPage
                .fillInFields(project)
                .clickCreate();
        isPageOpened();
        return this;
    }

    public int getProjectCount() {
        return driver.findElements(SINGLE_PROJECT_ELEMENTS).size();
    }
}
