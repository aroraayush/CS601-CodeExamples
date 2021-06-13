package codeCamp1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDealerNestedMap {
    private Map<String, Map<String, List<Car>>> cars;

    public CarDealerNestedMap() {
        this.cars = new HashMap<>();
    }

    public void add(String make, String model, double price) {
        Car car = new Car(make, model, price);
        Map<String, List<Car>> innerMap = cars.get(make);
        List<Car> list = null;
        if (innerMap == null) { // no innerMap
            innerMap = new HashMap<>();
            cars.put(make, innerMap);
            list = new ArrayList<>();
        }
        else {
            list = innerMap.get(model);
            if (list == null)
                list = new ArrayList<>();
        }
        list.add(car);
        innerMap.put(model, list);
    }


    public double getAveragePrice(String make) {
        double av = 0;
        Map<String, List<Car>> innerMap= cars.get(make);
        for (String model: innerMap.keySet()) {
            List<Car> listForMake = innerMap.get(model);
            if (listForMake != null) {
                for (Car c: listForMake) {
                    av += c.getPrice();
                }
                av = av / listForMake.size();
            }
        }

        return av;
    }

    public static void main(String[] args) {
        CarDealerNestedMap dealership = new CarDealerNestedMap();
        dealership.add("Toyota",  "Prius", 18000);
        dealership.add("Toyota",  "Corolla", 19000);
        dealership.add("Mazda",  "6", 14000);
        dealership.add("Toyota",  "Camri", 23000);
        dealership.add("Mazda",  "5", 20000);
        System.out.println(dealership.getAveragePrice("Mazda"));

    }

}
