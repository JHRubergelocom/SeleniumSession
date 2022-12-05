package tests;

import org.junit.Before;
import org.junit.Test;
import session.*;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class WebclientSessionTest {

    private Map<String, TabPage> createMB1() {

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

        TabPage tabPage = new TabPage(fields, table, "//*[@id='part_220_meeting_roles']/tr[11]/td[3]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Allgemein", tabPage);

        // Mitglieder
        /*
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Baum");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Gerd");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "g.baum@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Renz");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Sandra");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "s.renz@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_320_members']/tr[8]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Mitglieder", tabPage);
        */
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

        tabPage = new TabPage(fields, table, "//*[@id='part_230_meetingitem_templ']/tr[10]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
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

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Benachrichtigungen", tabPage);

        // Einstellungen
        fields = new TreeMap<>();
        fields.put("IX_MAP_MEETING_BOARD_MEETING_DEFAULT_NAME", "Meeting1");

        table = new ArrayList<>();

        checkboxes = new TreeMap<>();
        checkboxes.put("IX_MAP_MEETING_BOARD_SETTING_ITEMTOAGENDA", true);

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Einstellungen", tabPage);

        return tabPages;

    }

    private Map<String, TabPage> createME1() {

        Map<String, TabPage> tabPages = new TreeMap<>();

        // Allgemein
        Map<String,String> fields = new TreeMap<>();

        fields.put("IX_GRP_MEETING_NAME", "Meeting1");
        fields.put("IX_GRP_MEETING_LOCATION", "Musterstadt");
        fields.put("IX_GRP_MEETING_MINUTE_TAKER", "Charlotte Bennett");
        // fields.put("IX_DESC", "Beschreibung Meeting1");

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_TIMESLOT_START", "09:00");
        tableLine.put("IX_MAP_MEETING_TIMESLOT_END", "17:00");
        table.add(tableLine);

/*
        tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_TIMESLOT_START", "09:00");
        tableLine.put("IX_MAP_MEETING_TIMESLOT_END", "17:00");
        table.add(tableLine);
*/
        Map<String,Boolean> checkboxes = new TreeMap<>();

        TabPage tabPage = new TabPage(fields, table, "//*[@id='part_310_schedule']/tr[5]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Allgemein", tabPage);

        // Teilnehmende
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Baum");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Gerd");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "g.baum@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Renz");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Sandra");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "s.renz@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_410_participants']/tr[5]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Teilnehmende", tabPage);

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

        tabPage = new TabPage(fields, table, "//*[@id='part_610_notifications']/tr[8]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Benachrichtigungen", tabPage);

        // Wiederholung
        /*
        fields = new TreeMap<>();

        table = new ArrayList<>();

        checkboxes = new TreeMap<>();
        checkboxes.put("WF_MAP_MEETING_REPETITION_CREATE", true);

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Wiederholung", tabPage);
        */
        return tabPages;


    }

    private Map<String, TabPage> createMI1() {

        Map<String, TabPage> tabPages = new TreeMap<>();

        // "" (Nur eine tabPage)

        Map<String,String> fields = new TreeMap<>();

        fields.put("IX_GRP_MEETING_BOARD_NAME", "Meetingboard1");
        fields.put("IX_GRP_MEETING_BOARD_CODE", "MB1");
        fields.put("IX_GRP_MEETING_NAME", "Meeting1");
        fields.put("IX_GRP_MEETING_ITEM_TITLE", "Thema1");
        fields.put("IX_GRP_MEETING_ITEM_DURATION", "40");
        fields.put("IX_GRP_MEETING_ITEM_RESPONSIBLE_PERSON", "Adrian Smith");

        // fields.put("IX_DESC", "Beschreibung Thema1");

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_ITEM_SPEAKER_LASTNAME", "Kraft");
        tableLine.put("IX_MAP_MEETING_ITEM_SPEAKER_FIRSTNAME", "Bodo");
        table.add(tableLine);

/*
        tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_ITEM_SPEAKER_LASTNAME", "Davis");
        tableLine.put("IX_MAP_MEETING_ITEM_SPEAKER_FIRSTNAME", "Jessica");
        table.add(tableLine);
*/

        Map<String,Boolean> checkboxes = new TreeMap<>();

        TabPage tabPage = new TabPage(fields, table, "//*[@id=\"part_300_meeting_item_speaker\"]/tr[5]/td[2]/div/input", checkboxes, AssignmentStatus.MEETING);
        tabPages.put("", tabPage);

        return tabPages;

    }


    private Map<String, TabPage> createMB2Premium() {

        Map<String, TabPage> tabPages = new TreeMap<>();

        // Allgemein
        Map<String,String> fields = new TreeMap<>();

        fields.put("IX_GRP_MEETING_BOARD_NAME", "Meetingboard2");
        fields.put("IX_GRP_MEETING_BOARD_CODE", "MB2");
        fields.put("IX_GRP_MEETING_BOARD_MINUTE_TAKER", "David Lee");
        fields.put("IX_DESC", "Beschreibung Meetingboard2");

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Jan Eichner");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_BOARD_ORGANIZER", "Sandra Renz");
        table.add(tableLine);

        Map<String,Boolean> checkboxes = new TreeMap<>();

        TabPage tabPage = new TabPage(fields, table, "//*[@id='part_220_meeting_roles']/tr[11]/td[3]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Allgemein", tabPage);

        // Mitglieder
        /*
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
        */
        // Tagesordnungspunkte
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

        tabPage = new TabPage(fields, table, "//*[@id='part_230_meetingitem_templ']/tr[10]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Tagesordnungspunkte", tabPage);

        // Benachrichtigungen
        /*
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        // tableLine.put("IX_MAP_MEETING_NOTIFICATION_TEMPLATE_", "default");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_RECIPIENTS_", "O");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_VALUE_", "1");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_UNIT_", "y");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SIGN_", "-");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_REFERENCE_DATE_", "MEETING_STARTDATE");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        // tableLine.put("IX_MAP_MEETING_NOTIFICATION_TEMPLATE_", "default");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_RECIPIENTS_", "A");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_VALUE_", "1");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_UNIT_", "Q");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SIGN_", "+");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_REFERENCE_DATE_", "MEETING_ENDDATE");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes);
        tabPages.put("Benachrichtigungen", tabPage);
        */
        // Einstellungen
        fields = new TreeMap<>();
        fields.put("IX_MAP_MEETING_BOARD_MEETING_DEFAULT_NAME", "Meeting2");

        table = new ArrayList<>();

        checkboxes = new TreeMap<>();
        checkboxes.put("IX_MAP_MEETING_BOARD_SETTING_APPROVAL_REQUIRED", false);

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Einstellungen", tabPage);

        return tabPages;

    }

    private Map<String, TabPage> createME1Premium() {
        Map<String, TabPage> tabPages = new TreeMap<>();

        // Allgemein
        Map<String,String> fields = new TreeMap<>();

        fields.put("IX_GRP_MEETING_NAME", "Sitzung1");
        fields.put("IX_GRP_MEETING_LOCATION", "Musterdorf");
        fields.put("IX_GRP_MEETING_MINUTE_TAKER", "Bodo Kraft");
        // fields.put("IX_DESC", "Beschreibung Sitzung1");

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_TIMESLOT_START", "11:00");
        tableLine.put("IX_MAP_MEETING_TIMESLOT_END", "16:00");
        table.add(tableLine);

/*
        tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_TIMESLOT_START", "09:00");
        tableLine.put("IX_MAP_MEETING_TIMESLOT_END", "17:00");
        table.add(tableLine);
*/
        Map<String,Boolean> checkboxes = new TreeMap<>();

        TabPage tabPage = new TabPage(fields, table, "//*[@id='part_310_schedule']/tr[5]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Allgemein", tabPage);

        // Teilnehmende
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Baum");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Gerd");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "g.baum@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        tableLine.put("WF_MAP_MEETING_PERSON_LASTNAME", "Renz");
        tableLine.put("WF_MAP_MEETING_PERSON_FIRSTNAME", "Sandra");
        tableLine.put("WF_MAP_MEETING_PERSON_EMAIL", "s.renz@contelo.de");
        tableLine.put("WF_MAP_MEETING_PERSON_COMPANYNAME", "Contelo AG");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_410_participants']/tr[5]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Teilnehmende", tabPage);

        // Benachrichtigungen
        fields = new TreeMap<>();

        table = new ArrayList<>();
        tableLine = new TreeMap<>();
        // tableLine.put("IX_MAP_MEETING_NOTIFICATION_TEMPLATE_", "default");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_RECIPIENTS_", "O");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_VALUE_", "1");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_UNIT_", "y");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SIGN_", "-");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_REFERENCE_DATE_", "MEETING_STARTDATE");
        table.add(tableLine);

        tableLine = new TreeMap<>();
        // tableLine.put("IX_MAP_MEETING_NOTIFICATION_TEMPLATE_", "default");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_RECIPIENTS_", "A");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_VALUE_", "1");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SHIFT_UNIT_", "Q");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_SIGN_", "+");
        tableLine.put("IX_MAP_MEETING_NOTIFICATION_REFERENCE_DATE_", "MEETING_ENDDATE");
        table.add(tableLine);

        checkboxes = new TreeMap<>();

        tabPage = new TabPage(fields, table, "//*[@id='part_610_notifications']/tr[8]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Benachrichtigungen", tabPage);

        // Wiederholung


        fields = new TreeMap<>();

        table = new ArrayList<>();

        checkboxes = new TreeMap<>();
        checkboxes.put("WF_MAP_MEETING_REPETITION_CREATE", true);

        tabPage = new TabPage(fields, table, "//*[@id='part_410_notifications']/tr[7]/td[2]/div/input", checkboxes, AssignmentStatus.NOTHING);
        tabPages.put("Wiederholung", tabPage);

        return tabPages;

    }

    private Map<String, TabPage> createMI1Premium() {

        Map<String, TabPage> tabPages = new TreeMap<>();

        // "" (Nur eine tabPage)

        Map<String,String> fields = new TreeMap<>();

        fields.put("IX_GRP_MEETING_BOARD_NAME", "Meetingboard2");
        fields.put("IX_GRP_MEETING_BOARD_CODE", "MB2");
        fields.put("IX_GRP_MEETING_NAME", "Sitzung1");
        fields.put("IX_GRP_MEETING_ITEM_TITLE", "Thema1");
        fields.put("IX_GRP_MEETING_ITEM_DURATION", "30");
        fields.put("IX_GRP_MEETING_ITEM_RESPONSIBLE_PERSON", "David Lee");

        // fields.put("IX_DESC", "Beschreibung Thema1");

        List<Map<String, String>> table = new ArrayList<>();
        Map<String, String> tableLine = new TreeMap<>();
        tableLine.put("IX_MAP_MEETING_ITEM_SPEAKER_LASTNAME", "Bennett");
        tableLine.put("IX_MAP_MEETING_ITEM_SPEAKER_FIRSTNAME", "Charlotte");
        table.add(tableLine);

        Map<String,Boolean> checkboxes = new TreeMap<>();

        TabPage tabPage = new TabPage(fields, table, "//*[@id=\"part_300_meeting_item_speaker\"]/tr[5]/td[2]/div/input", checkboxes, AssignmentStatus.MEETING);
        tabPages.put("", tabPage);

        return tabPages;

    }

    @Before
    public void setUp() {
    }

    @Test
    public void testSession() {
        Map<String, TabPage> tabPages;

        WebclientSession ws = new WebclientSession();
        ws.login("ruberg-meeting.dev.elo", "Administrator", "elo");


        ws.selectSolutionsFolder();
        tabPages = createMB1();
        ws.executeAction("CreateMeetingBoard", tabPages);


        ws.selectSolutionsFolder();
        tabPages = createME1();
        ws.executeAction("CreateMeeting", tabPages);


        ws.selectSolutionsFolder();
        tabPages = createMI1();
        ws.executeAction("CreateMeetingItem", tabPages);



        ws.selectSolutionsFolder();
        tabPages = createMB2Premium();
        ws.executeAction("CreateMeetingBoardPremium", tabPages);


        ws.selectSolutionsFolder();
        tabPages = createME1Premium();
        ws.executeAction("CreateMeetingPremium", tabPages);


        ws.selectSolutionsFolder();
        tabPages = createMI1Premium();
        ws.executeAction("CreateMeetingItemPremium", tabPages);

    }


}
