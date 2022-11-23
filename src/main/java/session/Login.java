package session;

import org.openqa.selenium.By;

public class Login {
    private final WebclientSession ws;
    private final By usernameLocator = By.xpath("//*[@id=\"field-focustext-1020-inputEl\"]");
    private final By passwordLocator = By.xpath("//*[@id=\"textfield-1021-inputEl\"]");
    private final By loginButtonLocator = By.xpath("//*[@id=\"button-1023-btnIconEl\"]");

    public Login(WebclientSession ws, String stack) {
        this.ws = ws;
        this.ws.visit("http://" + stack + "/ix-Solutions/plugin/de.elo.ix.plugin.proxy/web/");
    }

    public void typeUsername(String username) {
        ws.type(usernameLocator, username);
    }

    public void typePassword(String password) {
        ws.type(passwordLocator, password);
    }

    public void clickLoginButton() {
        ws.click(loginButtonLocator);
    }
}
