package concurrency;

public class Starvation extends Thread {
    public void run(){
        System.out.println(Thread.currentThread().getName() + " thread running");

    }
    public static void main(String[] args) throws InterruptedException {
        Starvation thread1 = new Starvation();
        Starvation thread2 = new Starvation();
        Starvation thread3 = new Starvation();
        Starvation thread4 = new Starvation();
        Starvation thread5 = new Starvation();
        thread1.setName("1");
        thread2.setName("2");
        thread3.setName("3");
        thread4.setName("4");
        thread5.setName("5");
        thread1.setPriority(1);
        thread2.setPriority(3);
        thread3.setPriority(5);
        thread4.setPriority(7);
        thread5.setPriority(10);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }    
}
