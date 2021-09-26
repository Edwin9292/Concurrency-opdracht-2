package nl.saxion.concurrency.asign2;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ClubExtreem {

    private final int maxUsers, consecutiveRepresentatives;

    private ReentrantLock lock = new ReentrantLock();

    Condition emptyQueues = lock.newCondition();
    Condition clubIsFull = lock.newCondition();

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
            emptyQueues.signal();
        }
        else if(visitor instanceof Representative){
            waitingRepresentatives.add((Representative) visitor);
            emptyQueues.signal();
        }
        assert false;
    };

    public void joinClub(Queue<Representative> waitingRepresentatives, Queue<Visitor> waitingVisitors){
        lock.lock();
        try {
            //if there are no waiting visitors wait
            while (waitingRepresentatives.size() == 0 && waitingVisitors.size() == 0) {
                emptyQueues.await();
            }
            //if there are representatives join the club
            if (waitingRepresentatives.size() != 0 && representativeCounter != 3) {
                while (currentUsersInClub == 10) {
                    clubIsFull.await();
                }
                representativeCounter++;
                waitingRepresentatives.remove();
            //if there are regular visitors join the club
            } else {
                while (currentUsersInClub == 20) {
                    clubIsFull.await();
                }
                currentUsersInClub++;
                representativeCounter =0;
                waitingVisitors.remove();
            }
        }catch(Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }
    public void leaveClub(BaseVisitor visitor){
        lock.lock();

        try{
            while (visitor.timeInClub){
                //wait
            }
            if(visitor.timeInClub == 0){
                currentUsersInClub--;
                clubIsFull.signal();
            }
        }catch(Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    };


}
