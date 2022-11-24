package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Action {
    private final WebclientSession ws;
    private final By solutionLocator;
    private final By ribbonLocator;
    private final By menuLocator;
    private final By buttonLocator;

    public Action(WebclientSession ws, String action) {
        this.ws = ws;
        switch (action) {
            case "CreateMeetingBoard" -> {
                solutionLocator = By.xpath("//*[@id=\"tile-1013\"]"); // Solutions
                ribbonLocator = By.xpath("//*[@id=\"button-1218-btnIconEl\"]"); // Neu
                menuLocator = By.xpath("//*[@id=\"button-1280-btnIconEl\"]"); // Meeting
                buttonLocator = By.xpath("//*[@id=\"ext-comp-1274-textEl\"]"); // Neues Meetingboard
            }
            case "CreateMeeting" -> {
                solutionLocator = By.xpath("ToDo");
                ribbonLocator = By.xpath("ToDo");
                menuLocator = By.xpath("ToDo");
                buttonLocator = By.xpath("ToDo");
            }
            default -> {
                solutionLocator = By.xpath("");
                ribbonLocator = By.xpath("");
                menuLocator = By.xpath("");
                buttonLocator = By.xpath("");
            }
        }
    }
    public WebDriver startFormula() {
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
