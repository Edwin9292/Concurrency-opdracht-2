package nl.saxion.concurrency.asign2;

import java.util.Random;

public class Visitor extends BaseVisitor {


    public Visitor(ClubExtreem club, String name) {
        super(club, name);
    }

    @Override
    void stayInClub() {
        try {
            Thread.sleep(3000 + (new Random().nextInt((4000 - 3000) / 100) * 100) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
