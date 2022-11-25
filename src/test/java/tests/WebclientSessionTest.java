package tests;

import org.junit.Before;
import org.junit.Test;
import session.*;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class WebclientSessionTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testSession() {
        WebclientSession ws = new WebclientSession();
        ws.login("ruberg-meeting.dev.elo", "Administrator", "elo");

        Map<String, TabPage> tabPages = new TreeMap<>();

        // Allgemein
        Map<String,String> fields = new TreeMap<>();

        fields.put("IX_GRP_MEETING_BOARD_NAME", "Meetingboard1");
        fields.put("IX_GRP_MEETING_BOARD_CODE", "MB1");
        fields.put("IX_GRP_MEETING_BOARD_MINUTE_TAKER", "Bodo Kraft");
        fields.put("IX_DESC", "Beschreibung Meetingboard1");

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Jan Eichner");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Sandra Renz");
        table.add(tableLine);

        Map<String,Boolean> checkboxes = new TreeMap<>();

        TabPage tabPage = new TabPage(fields, table, "//*[@id='part_220_meeting_roles']/tr[11]/td[3]/div/input", checkboxes);
        tabPages.put("Allgemein", tabPage);

        // Mitglieder
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Baum");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Gerd");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "g.baum@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        tableLine.put("WF_MAP_MEETING_PERSON_USERNAME", "Gerd Baum");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Renz");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Sandra");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "s.renz@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        tableLine.put("WF_MAP_MEETING_PERSON_USERNAME", "Sandra Renz");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_320_members']/tr[8]/td[2]/div/input", checkboxes);
        tabPages.put("Mitglieder", tabPage);

        // Themen
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_ITEM_TITLE", "Rückblende");
        tableLine.put("WF_MAP_MEETING_ITEM_DURATION", "30");
        tableLine.put("WF_MAP_MEETING_ITEM_DESC", "Rückblick vergangene Projekte");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_ITEM_TITLE", "Planung");
        tableLine.put("WF_MAP_MEETING_ITEM_DURATION", "40");
        tableLine.put("WF_MAP_MEETING_ITEM_DESC", "Zukünftige Projekte");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_230_meetingitem_templ']/tr[10]/td[2]/div/input", checkboxes);
        tabPages.put("Themen", tabPage);

        // Benachrichtigungen
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_TEMPLATE_", "default");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_RECIPIENTS_", "O");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_VALUE_", "1");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_UNIT_", "y");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SIGN_", "-");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_REFERENCE_DATE_", "MEETING_STARTDATE");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_TEMPLATE_", "default");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_RECIPIENTS_", "A");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_VALUE_", "1");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_UNIT_", "Q");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SIGN_", "+");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_REFERENCE_DATE_", "MEETING_ENDDATE");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes);
        tabPages.put("Benachrichtigungen", tabPage);

        // Einstellungwn
        fields = new TreeMap<>();
        fields.put("IX_MAP_MEETING_BOARD_MEETING_DEFAULT_NAME", "Meeting1");

        table = new ArrayList<>();

        checkboxes = new TreeMap<>();
        checkboxes.put("IX_MAP_MEETING_BOARD_SETTING_ITEMTOAGENDA", true);

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes);
        tabPages.put("Einstellungen", tabPage);

        ws.executeAction("CreateMeetingBoard", tabPages);
    }

}
