package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import session.ExecuteAction;
import session.Formula;
import session.Login;
import session.WebclientSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebclientSessionTest {
    private Login login;
    private ExecuteAction action;

    @Before
    public void setUp() {
        WebclientSession ws = new WebclientSession();
        login = new Login(ws,"ruberg-meeting.dev.elo");
        action = new ExecuteAction(ws, "CreateMeetingBoard");
    }

    @Test
    public void testSession() {
        login.typeUsername("Administrator");
        login.typePassword("elo");
        login.clickLoginButton();

        WebDriver frame = action.StartFormular();
        Formula formula = new Formula(frame);

        formula.SelectTab("Allgemein", "IX_GRP_MEETING_BOARD_NAME");

        Map<String,String> fields = new HashMap<>();
        fields.put("IX_GRP_MEETING_BOARD_NAME", "Meetingboard1");
        fields.put("IX_GRP_MEETING_BOARD_CODE", "MB1");
        fields.put("IX_GRP_MEETING_BOARD_MINUTE_TAKER", "Bodo Kraft");
        fields.put("IX_DESC", "Beschreibung Meetingboard1");
        formula.inputTextFields(fields);

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new HashMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Jan Eichner");
        table.add(tableLine);

        tableLine = new HashMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Sandra Renz");
        table.add(tableLine);
        formula.inputTextFieldTable(table, "organizer");

        formula.Save();

    }

}
