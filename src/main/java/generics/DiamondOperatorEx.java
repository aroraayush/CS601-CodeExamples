package generics;

import java.util.HashSet;
import java.util.Set;

/** Demonstrates the difference between using the diamond operator on the right
 * hand side, versus using a raw type.
 */
public class DiamondOperatorEx {

    public static void demo() {
        Set<Circle> circles = new HashSet<>();
        circles.add(new Circle(3.5));
        circles.add(new Circle(1.2));

        Set<String>  strings = new HashSet<>();
        strings.add("hello");
        strings.add("bye");

        Set<Circle>  set1 = new HashSet(strings); // uses raw type on the right hand side
        // Error will not be discovered at compile time. Bad idea ...

        // The following will not compile: we are trying to add strings to a set of Circles
        //Set<Circle>  set2 = new HashSet<>(strings); // uses the diamond operator on the right hand side


    }
    public static void main(String[] args) {
        demo();
    }


}
