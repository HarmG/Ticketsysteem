package Actions;

import DataAdmin.ApplicationAdmin;
import DataAdmin.TicketAdmin;
import DataAdmin.UserAdmin;
import User.*;
import Ticket.*;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateTicket {
    private User user;
    private User indiener;
    private TicketAdmin ticketAdmin;
    private ApplicationAdmin applicationAdmin;
    private UserAdmin userAdmin;
    private PrintUsers printUsers;
    private PrintApplicatie printApplicatie;
    private Ticket ticket;
    ArrayList<String> intakeAnsweres = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);


    public CreateTicket(User user, TicketAdmin ticketAdmin, ApplicationAdmin applicationAdmin, UserAdmin userAdmin) {
        this.ticketAdmin = ticketAdmin;
        this.applicationAdmin = applicationAdmin;
        this.userAdmin = userAdmin;
        this.user = user;
        this.printUsers = new PrintUsers(userAdmin);
        this.printApplicatie = new PrintApplicatie(applicationAdmin);
    }

    // Todo: afhankelijk van de functierol kan de gebruiker apart worden ingevoerd.
    public void create() {
        if (user.getFunctionRole().equals(FuctionRole.User) || user.getFunctionRole().equals(FuctionRole.MANAGER)) {
            indiener = user;
            System.out.println("Indiener: " + user.getFirstname() + " " + user.getSurname());
        }else if (user.getFunctionRole().equals(FuctionRole.ADMINISTRATOR)){
            System.out.println("Kies melder: ");
            printUsers.printUserOvervieuw(userAdmin.getAllActiveBasedUsers(true));
            int indienerindex = scanner.nextInt();
            scanner.nextLine();
            indiener = userAdmin.getAllActiveBasedUsers(true).get(indienerindex);
        }
        boolean typeTicket;
        System.out.println("Kies type ticket");
        System.out.println("1. Incident");
        System.out.println("2. Vraag");
        int typeindex = scanner.nextInt();
        scanner.nextLine();
        if(typeindex == 1){
            typeTicket = true;
        }else {
            typeTicket = false;
        }

            System.out.println("Om welke applicatie gaat het?");
            for (int i = 0; i < applicationAdmin.getAllApplications().size(); i++) {
                System.out.println(i + " " + applicationAdmin.getAllApplications().get(i).getName());
            }
            int applicatieindex = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Omschrijf het probleem waar je tegen aanloopt");
            String omschrijving = scanner.nextLine();
            System.out.println(omschrijving);

             System.out.println("Beantwoord de volgende vragen:");
            for (int q = 0; q < applicationAdmin.getAllApplications().get(applicatieindex).getIntakeQuestions().size(); q++){
                printApplicatie.printQuestion(applicatieindex, q);
                System.out.println("Antwoord: ");
                String antwoord = scanner.nextLine();
                intakeAnsweres.add(antwoord);

            }


            PriorityLevel impact = PriorityLevel.LOW;
            System.out.println("Wie hebben er allemaal last van dit probleem?");
            System.out.println("1. Alleen ik.");
            System.out.println("2. Ik en mijn afdeling.");
            System.out.println("3. De gehele organisatie.");
            int i = scanner.nextInt();
            switch (i) {
                case 1:
                    impact = PriorityLevel.LOW;
                    System.out.println("De impact is op laag gezet");
                    break;
                case 2:
                    impact = PriorityLevel.MEDIUM;
                    System.out.println("De impact is op gemiddeld gezet");
                    break;
                case 3:
                    impact = PriorityLevel.HIGH;
                    System.out.println("De impact is op hoog gezet");
                    break;
                default:
                    System.out.println("De impact is op laag gezet.");
            }


            PriorityLevel urgentie = PriorityLevel.LOW;
            System.out.println("In hoeverre kan je je werk uitvoeren?");
            System.out.println("1. Ik kan nog mijn werkzaamheden uitvoeren.");
            System.out.println("2. Ik kan een gedeelte van mijn werk niet uitvoeren.");
            System.out.println("3. Ik kan volledig mijn werk niet uitvoeren.");
            int x = scanner.nextInt();
            switch (x) {
                case 1:
                    urgentie = PriorityLevel.LOW;
                    System.out.println("De urgentie is op laag gezet");
                    break;
                case 2:
                    urgentie = PriorityLevel.MEDIUM;
                    System.out.println("De urgentie is op gemiddeld gezet");
                    break;
                case 3:
                    urgentie = PriorityLevel.HIGH;
                    System.out.println("De urgentie is op hoog gezet");
                    break;
                default:
                    System.out.println("De urgentie is op laag gezet.");
            }
            if(typeTicket == true){
                ticket = new Incident(indiener, omschrijving, applicationAdmin.getAllApplications().get(applicatieindex), impact, urgentie);
                System.out.println("Bedankt voor het aanmaken van je ticket. Je ticket word zo snel mogelijk opgepakt.");
            }else if (typeTicket == false){
                ticket = new Question(indiener, omschrijving, applicationAdmin.getAllApplications().get(applicatieindex), impact, urgentie);
                System.out.println("Bedankt voor het aanmaken van je ticket. Je ticket word zo snel mogelijk opgepakt.");
            }

            for (int intake = 0; intake < intakeAnsweres.size(); intake++ ){
                ticket.setIntakeAnsweres(intakeAnsweres.get(intake), user);
            }

            ticketAdmin.safeTicket(ticket);



        }

        }



