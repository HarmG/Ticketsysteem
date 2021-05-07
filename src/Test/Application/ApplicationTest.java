package Application;

import User.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationTest {

    private Application testApplicationFalse;
    private Application testApplicationTrue;
    private User testUserITmedewerker;
    private User testGebruikerUser;

    @BeforeEach
    public void setUp() {
        LocalDate date = LocalDate.of(2000, 01, 01);
        testUserITmedewerker = new User(FuctionRole.ADMINISTRATOR, "user2 voornaam", "user2 achternaam", date, "0622222222", "user2@email.com", "ENTER");
        testGebruikerUser = new User(FuctionRole.User, "user2 voornaam", "user2 achternaam", date, "0622222222", "user2@email.com", "ENTER");
        testApplicationFalse = new Application("testApplicatieFalse", testUserITmedewerker, false, testUserITmedewerker);
        testApplicationTrue = new Application("testApplicatieTrue", testUserITmedewerker, true, testUserITmedewerker);
    }

    @Test
    void setBeheerderDoorITMedewerkerAssertTrue() {
        assertTrue(testApplicationFalse.setBeheerder(testUserITmedewerker, testUserITmedewerker));
    }

    @Test
    void setBeheerderDoorGebruikerAssertFalse() {
        assertFalse(testApplicationFalse.setBeheerder(testUserITmedewerker, testGebruikerUser));
    }

    @Test
    void setNaamDoorITMedewerkerAssertTrue() {
        assertTrue(testApplicationTrue.setNaam("TestApp", testUserITmedewerker));
    }

    @Test
    void setNaamDoorGebruikerAssertFalse() {
        assertFalse(testApplicationTrue.setNaam("TestApp", testGebruikerUser));
    }

    @Test
    void setKritischeAppDoorITMedewerkerAssertTrue() {
        assertTrue(testApplicationTrue.setKritischeApp(false, testUserITmedewerker));
    }

    @Test
    void setKritischeAppDoorGebruikerAssertFalse() {
        assertFalse(testApplicationTrue.setKritischeApp(false, testGebruikerUser));
    }

    @Test
    void setIntakeVragenDoorITMedewerkerAssertTrue() {
        String testvraag = "Wat is je vraag?";
        assertTrue(testApplicationTrue.setIntakeVragen(testvraag, testUserITmedewerker));
    }


    @Test
    void setIntakeVragenDoorGebruikerAssertFalse() {
        String testvraag = "Wat is je vraag?";
        assertFalse(testApplicationTrue.setIntakeVragen(testvraag, testGebruikerUser));
    }
}