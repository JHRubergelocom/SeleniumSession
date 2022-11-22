package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private By usernameLocator = By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]");


    public void typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

}
