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

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://ruberg-meeting.dev.elo/ix-Solutions/plugin/de.elo.ix.plugin.proxy/web/");
    }

    @Test
    public void testLogin() {
        login.typeUsername("Administrator");
        login.typePassword("elo");
        login.clickLoginButton();
    }

}
