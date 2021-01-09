package Menu;

import java.util.Scanner;

public class ManagerMenu {
    Scanner scanner = new Scanner(System.in);
    public ManagerMenu() {
    }
    public void managerMenu(){
    for (int i = 1; i > 0; ) {
        System.out.println("Maak een keuze.");
        System.out.println("1. Maak een ticket aan.");
        System.out.println("2. Bekijk tickets.");
        System.out.println("3. Rapportages inzien ");
        System.out.println("0. Afsluiten");
        i = scanner.nextInt();
        switch (i) {
            case 0:
                System.out.println("Afsluiten...");
                break;
            case 1:
                System.out.println("Ticket aanmaken");
                break;
            //Todo: Ticket aan maken
            case 2:
                System.out.println("Tickets inzien");
                break;
            //Todo: tickets inzien
            case 3:
                System.out.println("Rapportage inzien");
                break;
            //Todo: Rapportages inzien.
            default:
                System.out.println("Deze optie is niet beschikbaar");
                break;
        }
    }
}
}