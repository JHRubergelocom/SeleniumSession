package session;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class WebclientSession {
    private final WebDriver driver;

    public WebclientSession() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1200,1200));
    }

    public void visit(String url) {
        driver.get(url);
    }

    public WebDriver getFrame() {
        WebElement actElement = driver.switchTo().activeElement();
        return driver.switchTo().frame(actElement);
    }

    public void click(By by) {
        BaseFunctions.click(driver, by);
    }

    public void type(By by, String text) {
        BaseFunctions.type(driver, by, text);
    }

    public void login(String stack, String userName, String password) {
        Login login = new Login(this, stack);
        login.typeUsername(userName);
        login.typePassword(password);
        login.clickLoginButton();
        selectSolutionTile();
    }

    public void executeAction(String actionName, Map<String, TabPage> tabPages) {
        Action action = new Action(this, actionName);
        WebDriver frame = action.startFormula();
        Formula formula = new Formula(frame);
        formula.inputData(tabPages);
        formula.save();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void selectSolutionTile() {
        BaseFunctions.click(driver, By.xpath("//*[@id=\"tile-1013\"]"));
    }

    public void  selectSolutionsFolder() {
        BaseFunctions.click(driver, By.xpath("//*[@id=\"treeview-1061-record-1\"]"));
    }

}
