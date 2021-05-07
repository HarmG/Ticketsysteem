package Actions;

import Application.*;
import DataAdmin.ApplicationAdmin;
import Ticket.Ticket;

import java.util.List;

public class PrintApplicatie {
    private ApplicationAdmin applicationAdmin;

    public PrintApplicatie(ApplicationAdmin applicationAdmin) {
        this.applicationAdmin = applicationAdmin;
    }

    public void printApplicationFull(Application application){
        System.out.println("Naam: "+application.getName());
        System.out.println("Beheerder: "+application.getAdmin());
        System.out.println("Kritich: "+application.getCriticalApp());
        System.out.println("_____________________________________________________________________________________");
    }

    public void printApplicationShort(Application application){
        System.out.println(applicationAdmin.getAllApplications().indexOf(application)+" "+application.getName());
        System.out.println("_____________________________________________________________________________________");
    }

    public void printOvervieuw(List<Application> applications){
        for (int i = 0; i<applications.size(); i++){
            printApplicationShort(applications.get(i));
        }
    }

    public void printQandA(Ticket ticket){
        for (int i = 0; i < ticket.getApplication().getIntakeQuestions().size(); i++){
            System.out.println("Vraag: "+ticket.getApplication().getIntakeQuestions().get(i).getNote());
            System.out.println("Antwoord: "+ticket.getIntakeAnsweres().get(i).getNote());
        }
    }
    public void printQuestion(int applicationIndex, int questionIndex){
        System.out.println(applicationAdmin.getAllApplications().get(applicationIndex).getIntakeQuestions().get(questionIndex).getNote());
    }
}
