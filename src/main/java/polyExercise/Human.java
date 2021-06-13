package polyExercise;

/** From the book : Java 1.4 Game programming.
 *  Represents a Human, a subclass of Creature.
 *  Overrides speak() method to say: Human says <getGreeting()> ! *
 *  */
public class Human extends Creature {
    private String firstName, lastName;

    /**
     * Constructor
     * @param firstName first name
     * @param lastName last name
     * @param greeting greeting
     */
    public Human(String firstName, String lastName, String greeting) {
        // FILL IN CODE
        // call parent's constructor
        // assign values to firstName and lastName

        // Solution
        super(greeting);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Overrides speak method of Creature. Prints:
     * Human say: <greeting>
     */
    @Override
    public void speak() {
        // FILL IN CODE: Should print:  Human says: <greeting>

        // Solution:
        System.out.println("Human " + firstName + " says: " + getGreeting());
    }
}

