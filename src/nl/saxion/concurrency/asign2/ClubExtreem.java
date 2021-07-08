package nl.saxion.concurrency.asign2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ClubExtreem {

    private final int maxUsers, consecutiveRepresetatives;

    public ClubExtreem(int maxUsers, int consecutiveRepresetatives) {
        this.maxUsers = maxUsers;
        this.consecutiveRepresetatives = consecutiveRepresetatives;
    }

}
