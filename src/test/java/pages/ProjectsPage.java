package pages;

import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ProjectsPage extends BasePage {

    @FindBy(xpath = "//a[text()='Logout']")
    WebElement logout;
    @FindBy(xpath = "//a[text()='Billing']")
    WebElement billing;
    @FindBy(xpath = "//a[text()='Projects']")
    WebElement projects;
    @FindBy(xpath = "//div[text()='Add project']")
    WebElement addProject;
    @FindBy(name = "name")
    WebElement projectNameInput;
    @FindBy(xpath = "//textarea[@placeholder='Type here...']")
    WebElement projectDescriptionInput;
    @FindBy(name = "domains[]")
    WebElement projectDomainInput;
    @FindBy(xpath = "//button[text()='Create']")
    WebElement projectCreateButton;
    @FindBy(xpath = "//button[text()='Update']")
    WebElement projectUpdateButton;
    @FindBy(xpath = "//div[text()='Add new component']")
    WebElement addNewComponent;

    private By ACTIVE_PROJECTS = By.xpath("//div[@class='project']");
    private By EDIT_PROJECT = By.xpath("//a[text()='Edit']");
    private By REMOVE_DOMAIN = By.className("remove-domain");


    public ProjectsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://dev.integrivideo.com/app/projects");
        isPageOpened();
        PageFactory.initElements(driver, ProjectsPage.this);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Add project']")));
        } catch (TimeoutException ex) {
            throw new TimeoutException("Page is not opened");
        }
    }

    public ProjectsPage createProject(Project project) {
        NewProjectPage projectPage = new NewProjectPage(driver);
        projectPage.isPageOpened();
        projectPage
                .fillInFields(project)
                .clickCreate();
        isPageOpened();
        return this;
    }
}
