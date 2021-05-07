package Ticket;

import User.*;
import Application.*;
import Prioritize.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {
    private Application testApplicationFalse;
    private Application testApplicationTrue;
    private Incident testTicketIncidentFalse;
    private Incident testTicketIncidentTrue;
    private Question testTicketVraagFalse;
    private Question testTicketVraagTrue;
    private Request testRequest;
    private User testUserITmedewerker;
    private User testGebruikerUser;
    private String testTekst;

    TicketTest() {
    }

    @BeforeEach
    public void setUp() {
        this.testTekst = "test tekst!";
        LocalDate date = LocalDate.of(2000, 1, 1);
        this.testUserITmedewerker = new User(FuctionRole.ADMINISTRATOR, "user2 voornaam", "user2 achternaam", date, "0622222222", "user2@email.com", "ENTER");
        this.testGebruikerUser = new User(FuctionRole.User, "user2 voornaam", "user2 achternaam", date, "0622222222", "user2@email.com", "ENTER");
        this.testApplicationFalse = new Application("testApplicatieFalse", testUserITmedewerker, false, testUserITmedewerker);
        this.testApplicationTrue = new Application("testApplicatieTrue", testUserITmedewerker, true, testUserITmedewerker);
        this.testTicketIncidentFalse = new Incident(testUserITmedewerker, "test", testApplicationFalse, PriorityLevel.LOW, PriorityLevel.LOW);
        this.testTicketIncidentTrue = new Incident(testUserITmedewerker, "test", testApplicationTrue, PriorityLevel.LOW, PriorityLevel.LOW);
        this.testTicketVraagFalse = new Question(testUserITmedewerker, "test", testApplicationFalse, PriorityLevel.LOW, PriorityLevel.LOW);
        this.testTicketVraagTrue = new Question(testUserITmedewerker, "test", testApplicationTrue, PriorityLevel.LOW, PriorityLevel.LOW);
        this.testRequest = new Request(testGebruikerUser, "Graag toegang tot applicatie IntelliJ", testApplicationTrue, PriorityLevel.MEDIUM, PriorityLevel.LOW);
    }

    @Test
    void testPrio() {
        //testTicketIncidentTrue.getPrioritization().reCalc(testTicketIncidentTrue);
        assertEquals(Priority.CRITICAL, testTicketIncidentTrue.getPrioritization().getPriority());
    }

    @Test
    void setOpmeringen(){
        testTicketIncidentFalse.addUserVisibleNote(testTekst, testGebruikerUser);
        assertEquals(testTekst, testTicketIncidentFalse.getUserVisibleNote().get(0).getNote());
    }

    @Test
    void setWerknotitieDoorITMedewerkerTrue(){
        testTicketIncidentFalse.addWorkNote(testTekst, testUserITmedewerker);
        assertEquals(testTekst,testTicketIncidentFalse.getWorkNotes(testUserITmedewerker).get(0).getNote());
    }

    @Test
    void setWerknotitieDoorGebruikerFalse(){
        assertFalse(testTicketIncidentFalse.addWorkNote(testTekst, testGebruikerUser));
    }

    @Test
    void getEindNaSetStaatNaarOpgelost() {
        testTicketIncidentFalse.setStateToAssign(State.RESOLVED, testUserITmedewerker);
        assertEquals(LocalDateTime.now(), testTicketIncidentFalse.getEndTime());
    }

    //eind word pas ingevuld na Staat.OPGELOST vandaar dat er null komt te staan
    @Test
    void getEindMetStaatNieuw() {
        assertNull(testTicketIncidentFalse.getEndTime());
    }

    //eind word pas ingevuld na Staat.OPGELOST vandaar dat er null komt te staan
    @Test
    void getEindMetStaatToegewezen() {
        testTicketIncidentFalse.setStateToAssign(State.ASSIGNED, testUserITmedewerker);
        assertNull(testTicketIncidentFalse.getEndTime());
    }

    @Test
    void VeranderStaatAlsGebruiker(){
        assertFalse(testTicketIncidentFalse.setStateToAssign(State.RESOLVED, testGebruikerUser));
    }

    @Test
    void veranderApplicatieAlsITMedewerker() {
        assertTrue(testTicketIncidentFalse.setApplication(testApplicationTrue, testUserITmedewerker));
    }

    @Test
    void veranderApplicatieAlsITMedewerkertwee() {
        assertTrue(testTicketIncidentTrue.setApplication(testApplicationFalse, testUserITmedewerker));
    }

    @Test
    void veranderApplicatieAlsGebruikerFalse() {
        assertFalse(testTicketIncidentFalse.setApplication(testApplicationTrue, testGebruikerUser));
    }

    @Test
    void getWerknotities(){
        testTicketIncidentFalse.addWorkNote(testTekst, testUserITmedewerker);
        assertEquals(null, testTicketIncidentFalse.getWorkNotes(testGebruikerUser));
    }

}