package nl.saxion.concurrency.asign2;

import java.util.Random;

public abstract class BaseVisitor implements Runnable {

    final protected ClubExtreem clubExtreem;
    final private Random random = new Random();



    public BaseVisitor(ClubExtreem clubExtreem, String name) {
        this.clubExtreem = clubExtreem;
    }

    @Override
    public void run() {
        while(true) {
            live();
            clubExtreem.joinClub(this);
            stayInClub();
            clubExtreem.leaveClub(this);
        }
    }


    //so we do not get too many in the waiting queue
    protected void live() {
        randomTime(30000,random.nextInt(30) * 100);
    }

    protected void randomTime(int max, int min) {
        try {
            Thread.sleep(min + (random.nextInt((max - min) / 100) * 100) );
        } catch ( InterruptedException e) {

        }
    }

    abstract void stayInClub();
}
