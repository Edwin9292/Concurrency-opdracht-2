package nl.saxion.concurrency.asign2;

import java.util.Random;

public class Representative extends BaseVisitor {

    public Representative(ClubExtreem club, String name) {
        super(club, name);
    }

    @Override
    void stayInClub() {
        try {
            Thread.sleep(500 + (new Random().nextInt((1000 - 500) / 100) * 100) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
