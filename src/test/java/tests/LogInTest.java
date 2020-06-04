package tests;

import models.User;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTest extends BaseTest {

    @Test
    public void logInTest() {
        User user = new User("lenag@mailinator.com", "qwerty12345");
        new LogInPage(driver)
                .openPage();
        new LogInPage(driver)
                .login(user);


    }
}
