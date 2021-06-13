package inheritanceExercise;

/** From the book : Java 1.4 Game programming
 * A super class. Represents some intelligent life form that can talk.
 */
public class Creature {
    private String greeting;

    /**
     * Constructor for class Creature
     * @param greeting greeting
     */
    public Creature(String greeting){ this.greeting = greeting;}
    /**
     * Getter for greeting
     * @return greeting
     */
    protected String getGreeting() {
        return greeting;
    }

    /**
     * Prints the greeting
     */
    public void speak() {
        System.out.println("Creature says: " + greeting);
    }


}
