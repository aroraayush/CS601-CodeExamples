package inheritance;

/** Demonstrates how inheritance works in Java.
 *  When we create an object of a child class, although the parent's constructor gets
 *  invoked, Java does not create an object of a parent class, there is only one child's object.
 *  But parent's fields are present
 *  in the child's object. (if private, they cannot be accessed directly).
 *  hashCode() prints the integer representation of the memory address of the object.
 */
public class ChildClass extends ParentClass {
    private int y = 10;
    public ChildClass(int x, int y) {
        super(x);
        this.y = y;
        System.out.println("In child's constructor. HashCode: " + this.hashCode());
    }

    public String toString() {
        return getX() + " " + this.y;
    }

    @Override
    public void func1() {
        super.func1();
        System.out.println("func1, child");
    }
}
