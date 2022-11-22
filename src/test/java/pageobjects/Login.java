package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends Base {
    private WebDriver driver;

    private By usernameLocator = By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]");
    private By passwordLocator = By.xpath("//*[@id=\"textfield-1021-inputEl\"]");
    private By loginButtonLocator = By.xpath("//*[@id=\"button-1023-btnIconEl\"]");

    public Login(WebDriver driver) {
        super(driver);
        visit("http://ruberg-meeting.dev.elo/ix-Solutions/plugin/de.elo.ix.plugin.proxy/web/");
    }

    public void typeUsername(String username) {
        type(usernameLocator, username);
    }

    public void typePassword(String password) {
        type(passwordLocator, password);
    }

    public void clickLoginButton() {
        click(loginButtonLocator);
    }
}
