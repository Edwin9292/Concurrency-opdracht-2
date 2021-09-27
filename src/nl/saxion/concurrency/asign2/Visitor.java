package nl.saxion.concurrency.asign2;

import java.util.Random;

public class Visitor extends BaseVisitor {


    public Visitor(ClubExtreem club, String name) {
        super(club, name);
    }

    @Override
    void stayInClub() {
        try {
            Thread.sleep(800 + (new Random().nextInt((1000 - 800) / 100) * 100) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
