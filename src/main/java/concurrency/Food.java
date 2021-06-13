package concurrency;

public class Food {
    private String name;
    private boolean isFoodDelivered = false;

    public Food(String name) {
        this.name = name;
    }

    public void eat() throws InterruptedException {
        synchronized(this){
            while(!isFoodDelivered){
                this.wait();
            }
        }
        System.out.println("Eating now...");
    }

    public void throwTrash() throws InterruptedException {
        synchronized(this){
            while(!isFoodDelivered){
                this.wait();
            }
        }
        System.out.println("Eaten. Throwing in the bin now...");
    }

    public void deliver(){
        synchronized(this){
            this.isFoodDelivered = true;
            System.out.println("Food delivered");
            notify(); // Only one will run
//            notifyAll();
        }
    }
}

