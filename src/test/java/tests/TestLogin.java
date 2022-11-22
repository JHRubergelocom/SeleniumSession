package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Login;

import java.time.Duration;

public class TestLogin {
    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/driver/chromedriver.exe");
        driver = new ChromeDriver();
        login = new Login(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void testLogin() {
        login.typeUsername("Administrator");
        login.typePassword("elo");
        login.clickLoginButton();
    }
}
