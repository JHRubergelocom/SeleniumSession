package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Action {
    private final WebclientSession ws;
    private final By ribbonLocator;
    private final By menuLocator;
    private final By buttonLocator;

    public Action(WebclientSession ws, String action) {
        this.ws = ws;
        switch (action) {
            case "CreateMeetingBoard" -> {
                ribbonLocator = By.xpath("//*[@id=\"button-1218-btnIconEl\"]"); // Neu
                menuLocator = By.xpath("//*[@id=\"button-1280-btnIconEl\"]"); // Meeting
                buttonLocator = By.xpath("//*[@id=\"ext-comp-1274-textEl\"]"); // Neues Meetingboard
            }
            case "CreateMeetingBoardPremium" -> {
                ribbonLocator = By.xpath("//*[@id=\"button-1218-btnIconEl\"]"); // Neu
                menuLocator = By.xpath("//*[@id=\"button-1288-btnIconEl\"]"); // Sitzung
                buttonLocator = By.xpath("//*[@id=\"ext-comp-1281-textEl\"]"); // Neues Meetingboard
            }
            case "CreateMeeting" -> {
                ribbonLocator = By.xpath("//*[@id=\"button-1218-btnIconEl\"]"); // Neu
                menuLocator = By.xpath("//*[@id=\"button-1280-btnIconEl\"]");   // Meeting
                buttonLocator = By.xpath("//*[@id=\"ext-comp-1275-textEl\"]");  // Neues Meeting
            }
            case "CreateMeetingPremium" -> {
                ribbonLocator = By.xpath("//*[@id=\"button-1218-btnIconEl\"]"); // Neu
                menuLocator = By.xpath("//*[@id=\"button-1288-btnIconEl\"]"); // Sitzung
                buttonLocator = By.xpath("//*[@id=\"ext-comp-1282-textEl\"]"); // Neue Sitzung
            }
            default -> {
                ribbonLocator = By.xpath("");
                menuLocator = By.xpath("");
                buttonLocator = By.xpath("");
            }
        }
    }

    public WebDriver startFormula() {
        ws.click(ribbonLocator);
        ws.click(menuLocator);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ws.click(buttonLocator);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return ws.getFrame();
    }
}
