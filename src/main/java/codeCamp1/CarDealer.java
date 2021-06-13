package codeCamp1;

import java.util.*;

public class CarDealer {
    private Map<String, List<Car>> cars;

    public CarDealer() {
        this.cars = new HashMap<>();
    }

    public void add(String make, String model, double price) {
        Car car = new Car(make, model, price);
        List<Car> list = cars.get(make);
        if (list == null) {
            list = new ArrayList<>();
            cars.put(make, list);
        }
        list.add(car);
    }


    public double getAveragePrice(String make) {
        double av = 0;
        List<Car> listForMake = cars.get(make);
        if (listForMake != null) {
               for (Car c: listForMake) {
                   av += c.getPrice();
               }
               av = av / listForMake.size();
        }

        return av;
    }

    public static void main(String[] args) {
        CarDealer dealership = new CarDealer();
        dealership.add("Toyota",  "Prius", 18000);
        dealership.add("Toyota",  "Corolla", 19000);
        dealership.add("Mazda",  "6", 14000);
        dealership.add("Toyota",  "Camri", 23000);
        dealership.add("Mazda",  "5", 20000);
        System.out.println(dealership.getAveragePrice("Mazda"));


    }

}
