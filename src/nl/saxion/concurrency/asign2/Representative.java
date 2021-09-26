package nl.saxion.concurrency.asign2;

import java.util.Random;

public class Representative extends BaseVisitor {

    public Representative(ClubExtreem club, String name) {
        super(club, name);
    }

    @Override
    void stayInClub() {
        try {
            Thread.sleep(1000 + (new Random().nextInt((2000 - 1000) / 100) * 100) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
