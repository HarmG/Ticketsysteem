package MockTest;

import Application.*;
import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import DataAdmin.UserAdmin;
import MockData.MockDB;
import Ticket.*;
import User.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MockTest {
    private Application testApplicationFalse;
    private Application testApplicationTrue;
    private Incident testTicketIncidentFalse;
    private Incident testTicketIncidentTrue;
    private Question testTicketVraagFalse;
    private Question testTicketVraagTrue;
    private User testUserITmedewerker;
    private User testGebruikerUser;
    private String testTekst;
    private MockDB mockDB = new MockDB();
    private TicketAdmin ticketAdmin = new TicketAdmin(mockDB);
    private UserAdmin userAdmin = new UserAdmin(mockDB);
    private ApplicationAdmin applicationAdmin = new ApplicationAdmin(mockDB);

    @BeforeEach
    public void setUp() {
        mockDB.clearAll();
        this.testTekst = "test tekst!";
        LocalDate date = LocalDate.of(2000, 01, 01);
        testUserITmedewerker = new User(FuctionRole.ADMINISTRATOR, "user2 voornaam", "user2 achternaam", date, "0622222222", "user2@email.com", "ENTER");
        testGebruikerUser = new User(FuctionRole.User, "user2 voornaam", "user2 achternaam", date, "0622222222", "user2@email.com", "ENTER");
        testApplicationFalse = new Application("testApplicatieFalse", testUserITmedewerker, false, testUserITmedewerker);
        testApplicationTrue = new Application("testApplicatieTrue", testUserITmedewerker, true, testUserITmedewerker);
        testTicketIncidentFalse = new Incident(testUserITmedewerker, "test", testApplicationFalse, PriorityLevel.LOW, PriorityLevel.LOW);
        testTicketIncidentTrue = new Incident(testUserITmedewerker, "test", testApplicationTrue, PriorityLevel.LOW, PriorityLevel.LOW);
        testTicketVraagFalse = new Question(testUserITmedewerker, "test", testApplicationFalse, PriorityLevel.LOW, PriorityLevel.LOW);
        testTicketVraagTrue = new Question(testUserITmedewerker, "test", testApplicationTrue, PriorityLevel.LOW, PriorityLevel.LOW);

    }

    @Test
    void checkMockDB(){
        //Voeg 5 tickets toe aan MockData
        for (int i = 0; i < 5; i++){
            ticketAdmin.safeTicket(new Incident(testUserITmedewerker, "Test", testApplicationTrue, PriorityLevel.LOW, PriorityLevel.LOW));
        }
        int TotalTicketsInMockData = ticketAdmin.getAllTickets().size();

        assertEquals(TotalTicketsInMockData, 5);
    }

}