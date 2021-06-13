package inheritanceExercise;

import java.util.ArrayList;
import java.util.List;

/** The Driver class for Creature, Alien and Human */
public class SpaceCreatures {

    private ArrayList<Creature> list;

    public static void main(String[] args) {

        SpaceCreatures obj = new SpaceCreatures();

        obj.list = new ArrayList<>();

        obj.list.add(new Human("ayush","arora","hola !!!"));
        obj.list.add(new Creature("creatureTestGreeting !!!"));
        obj.list.add(new Alien("alienTestGreeting","testPlanetName"));

        //TODO:  Create an ArrayList of different creatures (type of elements should be Creature).
        // Iterate over the list and call the speak method on each element
        // to see how polymorphism works.
        // If a creature is in the list is an alien, call the fight method.
        System.out.println();
        List<Creature> list = new ArrayList();
        // FILL IN CODE



    }
}
