package User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User testGebruikerUser;
    private User testUserITMedewerker;
    private User testUserDirectielid;

    @BeforeEach
    public void setUp() {
        LocalDate date = LocalDate.of(2000, 01, 01);
        testGebruikerUser = new User(FuctionRole.User, "user1 voornaam", "user1 achternaam", date, "0611111111", "user1@email.com", "ENTER");
        testUserITMedewerker = new User(FuctionRole.ADMINISTRATOR, "user2 voornaam", "user2 achternaam", date, "0622222222", "user2@email.com", "ENTER");
        testUserDirectielid = new User(FuctionRole.MANAGER, "user3 voornaam", "user3 achternaam", date, "0633333333", "user3@email.com", "ENTER");
    }

    @Test
    void wijzigwachtwoordTrue() {
        assertTrue(testGebruikerUser.setPassword("ENTER", "NieuwWachtwoord", "NieuwWachtwoord"));
    }

    @Test
    void wijzigwachtwoordVerkeerdOudeWachtwoord() {
        assertFalse(testGebruikerUser.setPassword("enter", "NieuwWachtwoord", "NieuwWachtwoord"));
    }

    @Test
    void wijzigwachtwoordNieuweWachtwoordenKomenNietOvereen() {
        assertFalse(testGebruikerUser.setPassword("ENTER", "NieuwWachtwoord1", "NieuwWachtwoord2"));
    }

    @Test
    void setActiefDoorITMedewerkerTrue() {
        assertTrue(testGebruikerUser.setActive(false, testUserITMedewerker));
    }

    @Test
    void setActiefDoorGebruikerFalse() {
        assertFalse(testGebruikerUser.setActive(false, testUserDirectielid));
    }

    @Test
    void setFunctierolDoorITMedewerkerTrue() {
        assertTrue(testGebruikerUser.setFunctionRole(FuctionRole.ADMINISTRATOR, testUserITMedewerker));
    }

    @Test
    void setFunctierolDoorGebruikerFalse() {
        assertFalse(testGebruikerUser.setFunctionRole(FuctionRole.ADMINISTRATOR, testUserDirectielid));
    }

    @Test
    void wachtwoordTestenTrue() {
        assertTrue(testGebruikerUser.verifyPassword("ENTER"));
    }

    @Test
    void wachtwoordTestenFalse() {
        assertFalse(testGebruikerUser.verifyPassword("BACKSPACE"));
    }
}