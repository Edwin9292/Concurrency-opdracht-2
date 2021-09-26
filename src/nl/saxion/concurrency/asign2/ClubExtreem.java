package nl.saxion.concurrency.asign2;

import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ClubExtreem {

    private final int maxUsers, consecutiveRepresentatives;

    ReentrantLock lock = new ReentrantLock();

    Condition emptyQueues = lock.newCondition();
    Condition clubIsFull = lock.newCondition();
    Condition customerWaiting = lock.newCondition();
    Condition representativeWaiting = lock.newCondition();
    Condition customerEnteringClub = lock.newCondition();
    Condition representativeEnteringClub = lock.newCondition();


    private int currentVisitorsInClub = 0;

    private boolean isRepresentativeWaiting = false;
    private boolean isRepresentativeInClub = false;
    private int representativeCounter = 0;

    public ClubExtreem(int maxUsers, int consecutiveRepresentatives) {
        this.maxUsers = maxUsers;
        this.consecutiveRepresentatives = consecutiveRepresentatives;
    }

    private boolean isOverHalfCapacity(){
        return currentVisitorsInClub > (maxUsers/2);
    }


    public void joinClub(BaseVisitor visitor){
        //check if visitor is visitor or representative

        //call private joinClub with corresponding visitor type.
    }

    private void joinClub(Representative representative){
        //take lock

        //check if representativeCounter isn't == to consecutiveRepresentatives

        //tell program that a representative is waiting

        //check if club isn't over half capacity  (method isOverHalfCapacity())

        //enter club

        //release lock
    }

    private void joinClub(Visitor visitor){
        //take lock

        //Check if a visitor can enter the club
        //check if club isn't full

        //check if no representative is waiting
        //reset representative counter

        //enter club

        //release lock
    }

    public void leaveClub(BaseVisitor visitor){
        //take lock

        //check if basevisitor is representative or normal visitor
        //if representative, put isRepresentativeInside on false and lower visitor counter by 1
        //signal isRepresentativeInside

        //if visitor, lower visitor counter by 1
        //signal clubIsFull

        //release lock
    }



//    public void joinClub(Queue<Representative> waitingRepresentatives, Queue<Visitor> waitingVisitors){
//        lock.lock();
//        try {
//            //if there are no waiting visitors wait
//            while (waitingRepresentatives.size() == 0 && waitingVisitors.size() == 0) {
//                emptyQueues.await();
//            }
//            //if there are representatives join the club
//            if (waitingRepresentatives.size() != 0 && representativeCounter != 3) {
//                while (currentVisitorsInClub == 10) {
//                    clubIsFull.await();
//                }
//                representativeCounter++;
//                waitingRepresentatives.remove();
//            //if there are regular visitors join the club
//            } else {
//                while (currentVisitorsInClub == 20) {
//                    clubIsFull.await();
//                }
//                currentVisitorsInClub++;
//                representativeCounter =0;
//                waitingVisitors.remove();
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }finally {
//            lock.unlock();
//        }
//    }
//
//    public void leaveClub(BaseVisitor visitor){
//        lock.lock();
//
//        try{
//            while (visitor.timeInClub){
//                //wait
//            }
//            if(visitor.timeInClub == 0){
//                currentUsersInClub--;
//                clubIsFull.signal();
//            }
//        }catch(Exception e){
//            System.out.println(e);
//        }finally {
//            lock.unlock();
//        }
//    };
//

}
