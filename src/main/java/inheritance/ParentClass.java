package inheritance;

/** Demonstrates how inheritance works in Java.
 *  When we create an object of a child class, although the parent's constructor gets
 *  invoked, Java does not create an object of a parent class, but parent's fields are present
 *  in the child's object. (if private, they cannot be accessed directly).
 *  hashCode() prints the integer representation of the memory address of the object.
 */
public class ParentClass {
    private int x;
    public ParentClass(int x) {
        this.x = x;
        System.out.println("In parent's constructor: " + this.hashCode());
    }

    public int getX() {
        return x;
    }

    public String toString() {
        return String.valueOf(x);
    }

    protected void func1() {
        System.out.println("func1, parent");
    }

}
