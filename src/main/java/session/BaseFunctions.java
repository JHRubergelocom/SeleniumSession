package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseFunctions {

    public static void type(WebDriver driver, By by, String inputText) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
        WebElement element = driver.findElement(by);
        element.clear();
        element.sendKeys(inputText);
    }

    public static void click(WebDriver driver, By by) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public static void clickable(WebDriver driver, String name) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.name(name)));
    }

}
