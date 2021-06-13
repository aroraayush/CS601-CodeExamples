package polyExercise;

/** From the book : Java 1.4 Game programming.
 *  Represents an Alien, a subclass of Creature.
 *  Overrides speak() method to say: Alien from planet <nameOfPlanet> says <getGreeting()> ! *
 *  */
public class Alien extends Creature {

    private String planet; // the name of the planet

    /**
     * Constructor for Alien
     * @param greeting greeting
     * @param planet planet
     */
    public Alien(String greeting, String planet) {
        // FILL IN CODE:
        // call the parent's constructor to initialize the greeting
        // assign a value to planet

        // Solution:
        super(greeting);
        this.planet = planet;
    }

    /**
     * Prints planet and greeting.
     * Overrides speak() method from class Creature
     */
    @Override
    public void speak() {
        // FILL IN CODE: it should say Alien from planet <name of planet> says: <greeting>
        //super.speak();
        // Solution:
        System.out.println("Alien from planet " + this.planet + " says: " + getGreeting());
    }

    /** Exists only in class Alien. Represents "fighting". */
    public void fight() {
        System.out.println("Let's fight!");
    }
}
