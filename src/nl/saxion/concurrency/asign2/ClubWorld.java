package nl.saxion.concurrency.asign2;

import java.util.Scanner;

public class ClubWorld {


    private final int sizeOfTheClub  = 5, nrOfRepresentatives = 10, nrOfVisistors = 1000,
                      consecutiveRepresentatives = 3  ;



    public static void main(String[] args) {
        new ClubWorld().startWorld();
    }



    public void startWorld() {
        ClubExtreem printingShop = new ClubExtreem(sizeOfTheClub, consecutiveRepresentatives);
        for (int i = 0; i < nrOfVisistors; i++) {
            new Thread(new Visitor(printingShop,"Visitor " + i),"Visitor" + i ).start();
        }
        for (int i = 0; i < nrOfRepresentatives; i++) {
            new Thread(new Representative(printingShop,"Representative " + i),"Representative" + i ).start();
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Press Enter to quit...");
        scan.nextLine();
        System.exit(0);

    }

}
