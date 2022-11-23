package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExecuteAction {
    private final WebclientSession ws;
    private final By solutionLocator;
    private final By ribbonLocator;
    private final By menuLocator;
    private final By buttonLocator;

    public ExecuteAction(WebclientSession ws, String action) {
        this.ws = ws;
        switch (action) {
            case "CreateMeetingBoard":
                solutionLocator = By.xpath("//*[@id=\"tile-1013\"]"); // Solutions
                ribbonLocator = By.xpath("//*[@id=\"button-1218-btnIconEl\"]"); // Neu
                menuLocator = By.xpath("//*[@id=\"button-1280-btnIconEl\"]"); // Meeting
                buttonLocator = By.xpath("//*[@id=\"ext-comp-1274-textEl\"]"); // Neues Meetingboard
                break;
            default:
                solutionLocator = By.xpath("");
                ribbonLocator = By.xpath("");
                menuLocator = By.xpath("");
                buttonLocator = By.xpath("");
                break;
        }
    }
    public WebDriver StartFormular() {
        ws.click(solutionLocator);
        ws.click(ribbonLocator);
        ws.click(menuLocator);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ws.click(buttonLocator);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ws.getFrame();
    }
}
