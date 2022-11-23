package tests;

import org.junit.Before;
import org.junit.Test;
import session.ExecuteAction;
import session.Login;
import session.WebclientSession;

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

        action.StartFormular();
    }

}
