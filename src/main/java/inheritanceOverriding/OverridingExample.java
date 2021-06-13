package inheritanceOverriding;

/** The example demonstrates that static methods do hot behave polymorphically. */
public class OverridingExample {
    public static void main(String[] args) {
        Superclass super1 = new Superclass();

        // This will invoke Subclass's methods but Superclass's static methods
        Superclass sub1 = new Subclass();
        // Parent              Child

        Subclass sub2 = new Subclass();

//        super1.func1(); // parent's version
//        sub2.func1(); // child's version

//        sub1.func1(); // child's version

//        System.out.println();

        Superclass.staticFunc1(); // parent's version

        // Here we are using an Object and not directly invoking Class.staticFunction()
        sub1.staticFunc1(); // parent's version - for static methods, binding happens at compile
                            // time, based on the type of reference; In this case, reference is
                            // of type Superclass

        sub2.staticFunc1(); // child's version, since the type of sub2 is a Subclass

    }
}
