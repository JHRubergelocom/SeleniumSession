package tests;

import org.junit.Before;
import org.junit.Test;
import session.*;

public class WebclientSessionTest {

    @Before
    public void setUp() {
    }

    @Test
    public void testSession() {
        WebclientSession ws = new WebclientSession();
        ws.login("ruberg-meeting.dev.elo", "Administrator", "elo");
        ws.executeAction();
    }

}
