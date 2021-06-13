package codeCamp1;

public class Truck extends Vehicle {
    private boolean isPickup;

    public Truck(int doors, int seats, boolean isPickup) {
        super(doors, seats);
        this.isPickup = isPickup;
    }

    public void setPickup(boolean pickup) {
        this.isPickup = pickup;
    }

    // FILL IN CODE: override the print method to print the number of doors,
    // the number of seats and whether it's a pickup truck or not.
    @Override
    public void print() {
        super.print();
        if (isPickup)
            System.out.println("; It is a truck");
        else
            System.out.println("; Not a truck");
    }
}
