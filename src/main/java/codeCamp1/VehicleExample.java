package codeCamp1;

public class VehicleExample {
	public static void main(String[] args) {
		Vehicle v1 = new Vehicle(4, 4);
		Vehicle v2 = new Truck(2, 2, true);
		Truck tr = new Truck(2, 2, false);
		v1.print(); System.out.println();
		v2.print();
		tr.print();
		System.out.println(v2.getClass().getSimpleName());
		System.out.println(v2 instanceof Truck);

		//How can we change v2 into a pickup truck? With downcasting:
		// tr = (Truck)v2;

	}
}

