package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    private WebDriver driver;

    private By usernameLocator = By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]");
    private By passwordLocator = By.xpath("//*[@id=\"textfield-1021-inputEl\"]");
    private By loginButtonLocator = By.xpath("//*[@id=\"button-1023-btnIconEl\"]");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
    }

    public void typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonLocator).click();
    }

}
