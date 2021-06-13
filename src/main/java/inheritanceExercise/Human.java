package inheritanceExercise;

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
        super(greeting);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /**
     * Overrides speak method of Creature. Prints:
     * Human say: <greeting> //get greeting from Getter methods
     * getGreeting() will be inherited
     */
    @Override
    public void speak(){
        System.out.println("Human says:" + getGreeting());
    }
}

