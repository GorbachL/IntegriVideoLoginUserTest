package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class IntegriProjectsPage extends BasePage {

    private By ADD_PROJECT_BUTTON = By.xpath("//div[text()='Add project']");
    private By SINGLE_PROJECT_ELEMENTS = By.className("project");
    private By COMPONENTS_COUNT = By.cssSelector(".components-count");
    private By ADD_NEW_COMPONENT = By.xpath("//div[text()='Add new component']");
    private By EDIT_PROJECT_BUTTON = By.xpath("//a[contains(text(), 'Edit')]");
    private By ACTIVE_PROJECT = By.xpath("//div[@class='project']");
    private By COMPONENT_TYPE = By.id("select2-type-in-container");
    private By COMPONENT_NAME = By.name("name");
    private By CREATE_COMPONENT_BUTTON = By.xpath("//*[text()='Create']");
    private By COMPONENT_LIST = By.id("component-list");
    private By UPDATE_COMPONENT_BUTTON = By.xpath("//button[contains(text(), 'Update')]");

    @FindBy(xpath = "//button[contains(text(), 'Update')]")
    WebElement updateComponent;

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


    public IntegriProjectsPage createComponent(String componentName) {
        driver.findElement(ADD_NEW_COMPONENT).click();
        List<WebElement> options = driver.findElements(COMPONENT_TYPE);
        options.get(1).click();
        driver.findElement(COMPONENT_NAME).sendKeys(componentName);
        driver.findElement(CREATE_COMPONENT_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOf(updateComponent));
        return this;
    }
}
