package tests;

import models.Project;
import models.User;
import org.testng.annotations.Test;
import pages.IntegriProjectsPage;
import pages.LogInPage;
import pages.NewProjectPage;

import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class ProjectTest extends BaseTest {

    @Test
    public void createPage() {
        User user = new User("lenag@mailinator.com", "qwerty12345");
        Project project = new Project("Second Project", "Description of this project",
                new ArrayList<String>(Arrays.asList("tut.by", "onliner.by", "tut.by")));

        logInPage = new LogInPage(driver);
        logInPage.openPage();
        IntegriProjectsPage projectsPage = logInPage.logIn(user);
        int initialProjectCount = projectsPage.getProjectCount();
        int finalProjectCount = projectsPage.getProjectCount();

        assertEquals(initialProjectCount + 1, finalProjectCount,
                "The number of projects has not increased since the creation of the new");
    }
}
