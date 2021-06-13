package inheritance;

/** Demonstrates how inheritance works in Java.
 *  When we create an object of a child class, only one object gets created, it
 *  has both parent's and child's data. But if it's parent's private data, it cannot be
 *  accessed directly. See classes ChildClass and ParentClass.
  */
public class InheritanceDemo {
    public static void main(String[] args) {
        ChildClass child = new ChildClass(5, 10);
        System.out.println(child);
        child.func1();
    }
}
