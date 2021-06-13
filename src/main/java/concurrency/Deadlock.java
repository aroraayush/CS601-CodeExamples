package concurrency;

/**
 * Adapted from The Java Tutorial
 * Second Edition by Campione, M. and
 * Walrath, K.Addison-Wesley 1998
 */

/**
 * This is a demonstration of how NOT to write multi-threaded programs.
 * It is a program that PURPOSELY CAUSES DEADLOCK between two threads that
 * are both trying to ACQUIRE LOCKS FOR THE SAME TWO RESOURCES.
 * To avoid this sort of deadlock when locking multiple resources, all threads
 * SHOULD ALWAYS ACQUIRE THEIR LOCKS IN THE SAME ORDER.
 **/
public class Deadlock {
    public static void main(String[] args){

        //These are the two resource objects we'll try to get locks for
        final Object resource1 = "resource1";
        final Object resource2 = "resource2";

        //Here's the first thread.
        //It tries to lock resource1 then resource2
        Thread t1 = new Thread(() -> {

            //Lock resource 1
            synchronized(resource1){
                System.out.println("Thread 1: locked resource 1");

                try{

                    //Pause for a bit
                    //Simulating some file I/O to give the
                    //other thread a chance to run. We're trying to force
                    //deadlock to happen here...
                    Thread.sleep(50); // the lock is NOT released while the thread is sleeping

                } catch (InterruptedException e) {}

                //Now wait 'till we can get a lock on resource 2
                synchronized(resource2){
                    System.out.println("Thread 1: locked resource 2");
                }
            }
        });

        // Here's the second thread.
        // It tries to lock resource2 then resource1
        Thread t2 = new Thread(()->{

            //This thread locks resource 2 right away
            synchronized(resource2){
                System.out.println("Thread 2: locked resource 2");
                try{

                    //Then it pauses, for the same reason as the first
                    //thread does
                    Thread.sleep(50);

                } catch (InterruptedException e){}

                //Then it tries to lock resource1.
                //But wait!  Thread 1 already locked resource1, and
                //won't release it till it gets a lock on resource2,
                // which is now held by resource 2.
                //This thread holds the lock on resource2, and won't
                //release it till it gets resource1.
                //We're at an impasse. Neither thread can run,
                //and the program freezes up. Deadlock!
                synchronized(resource1){
                    System.out.println("Thread 2: locked resource 1");
                }
            }
        });

        //Start the two threads.
        //If all goes as planned, deadlock will occur,
        //and the program will never exit.
        t1.start();
        t2.start();
    }
}