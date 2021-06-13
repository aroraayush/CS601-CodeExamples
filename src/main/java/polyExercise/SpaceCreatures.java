package polyExercise;

import java.util.ArrayList;
import java.util.List;

/** The Driver class for Creature, Alien and Human */
public class SpaceCreatures {
    public static void main(String[] args) {
        // Part 1: Create different creatures and call speak() method
        Creature c = new Creature("Good day");
        Alien a = new Alien("Vjapjvp", "Mars");
        Human h = new Human("Jim", "Head","Hello");
        c.speak();
        a.speak();
        h.speak();

        //a = (Alien)c; // Try running it - Will cause an error: ClassCastException

        // Part 2: Create an ArrayList of different creatures, and call speak method
        // to see how polymorphism works
        System.out.println();
        List<Creature> list = new ArrayList();
        list.add(new Creature("Good day"));
        list.add(new Alien("ho-ha-ho-hi", "Venice"));
        list.add(new Human("Jim", "Head", "Hello"));

        for (Creature elem: list) {
            elem.speak(); // polymorphism: different versions of speak will be called

            if (elem instanceof Alien) {
               ((Alien) elem).fight();  // downcasting
             }

             // An alternative way of doing this:
            //if (elem.getClass().getSimpleName().equals("Alien"))
              //  ((Alien) elem).fight();
        }

    }
}
