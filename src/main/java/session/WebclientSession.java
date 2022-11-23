package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebclientSession {
    private final WebDriver driver;

    public WebclientSession() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
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
}
