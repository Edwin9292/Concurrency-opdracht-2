package nl.saxion.concurrency.asign2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ClubExtreem {

    private final int maxUsers, consecutiveRepresentatives;

    private int currentUsersInClub = 0;
    private int representativeCounter = 0;

    Queue<Representative> waitingRepresentatives = new PriorityQueue<Representative>();
    Queue<Visitor> waitingVisitors = new PriorityQueue<Visitor>();


    public ClubExtreem(int maxUsers, int consecutiveRepresentatives) {
        this.maxUsers = maxUsers;
        this.consecutiveRepresentatives = consecutiveRepresentatives;
    }

    public void joinQueue(BaseVisitor visitor){
        if(visitor instanceof Visitor){
            waitingVisitors.add((Visitor) visitor);
        }
        else if(visitor instanceof Representative){
            waitingRepresentatives.add((Representative) visitor);
        }
        assert false;
    }



}
