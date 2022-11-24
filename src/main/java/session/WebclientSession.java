package session;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    }

    public void executeAction() {
        Action action = new Action(this, "CreateMeetingBoard");
        WebDriver frame = action.startFormula();

        Formula formula = new Formula(frame);

        Map<String, TabPage> tabpages = new HashMap<>();

        // Allgemein
        Map<String,String> fields = new HashMap<>();

        fields.put("IX_GRP_MEETING_BOARD_NAME", "Meetingboard1");
        fields.put("IX_GRP_MEETING_BOARD_CODE", "MB1");
        fields.put("IX_GRP_MEETING_BOARD_MINUTE_TAKER", "Bodo Kraft");
        fields.put("IX_DESC", "Beschreibung Meetingboard1");

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new HashMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Jan Eichner");
        table.add(tableLine);

        tableLine = new HashMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Sandra Renz");
        table.add(tableLine);

        TabPage tabPage = new TabPage(fields, table, "//*[@id='part_220_meeting_roles']/tr[11]/td[3]/div/input");
        tabpages.put("Allgemein", tabPage);

        // Mitglieder
        fields = new HashMap<>();

        table = new ArrayList<>();
        tableLine = new HashMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Baum");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Gerd");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "g.baum@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_USERNAME", "Gerd Baum");
        table.add(tableLine);

        tableLine = new HashMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Renz");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Sandra");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "s.renz@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_USERNAME", "Sandra Renz");
        table.add(tableLine);

        tabPage = new TabPage(fields, table, "//*[@id='part_320_members']/tr[8]/td[2]/div/input");
        tabpages.put("Mitglieder", tabPage);

        // Themen
        fields = new HashMap<>();

        table = new ArrayList<>();
        tableLine = new HashMap<>();
        tableLine.put("WF_MAP_MEETING_ITEM_TITLE", "Rückblende");
        tableLine.put("WF_MAP_MEETING_ITEM_DURATION", "30");
        tableLine.put("WF_MAP_MEETING_ITEM_DESC", "Rückblick vergangene Projekte");
        table.add(tableLine);

        tableLine = new HashMap<>();
        tableLine.put("WF_MAP_MEETING_ITEM_TITLE", "Planung");
        tableLine.put("WF_MAP_MEETING_ITEM_DURATION", "40");
        tableLine.put("WF_MAP_MEETING_ITEM_DESC", "Zukünftige Projekte");
        table.add(tableLine);

        tabPage = new TabPage(fields, table, "//*[@id='part_230_meetingitem_templ']/tr[10]/td[2]/div/input");
        tabpages.put("Themen", tabPage);


        // Benachrichtigungen

        // Einstellungwn



        formula.inputData(tabpages);


        formula.save();

    }

}
