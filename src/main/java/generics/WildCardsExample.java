package generics;

import java.util.*;

/** A class that shows how to use wild cards
 * when we use parameterized classes from the Collections framework */
public class WildCardsExample {

    // The following will not compile. List<Object> is not a parent of List<Circle>
    public static void iterateOverList1(List<Object> list) {
        for (Object elem : list) {
            System.out.println(elem);
        }
    }

    // Unbounded Wildcard used
    public static void iterateOverList2(List<?> list) {
        // Following will not compile,
        // cannot add anything to the List whose type is ? (unknown) except null
        //  list.add(5) ;
        list.add(null) ;

        for (Object elem : list) {
            System.out.println(elem);
        }

        // list.add(5) ; // will not compile, cannot add anything to the List whose type is ? (unknown)
    }

    public static void iterateOverList3(List list, Object o) {
        for (Object elem : list) {
            System.out.println(elem);
        }
        // can add anything
        list.add(o); // compiles and runs
        // But no compile type safety
    }

    public static void iterateOverCircles(List<? extends Circle> list) {
        for (Circle elem : list) { // upcasting each element from list to Circle - can only do it
            // if we use ? extends Circle in the type
            System.out.println(elem);
        }
    }

    /*
    // This method will not compile! We are trying to put a Circle into an arbitrary list.
    // What if the list that is passed to the method is a list of Students? or a list of Apples?
    public static void insertCircle1(List<?> list, float rad) {
        list.add(new Circle(rad));
    }
    */

    // This method compiles fine - we can always put a Circle into a list, if the list
    // that is passed as a parameter is List<Circle>, or List of some superclass of Circle like Shape
    public static void insertCircle2(List<? super Circle> list, float rad) {
        list.add(new Circle(rad));
    }

    public static void main(String[] args) {
        // Create a list of Circles

        List<Circle> list1 = new ArrayList<Circle>();
        list1.add(new Circle(4.0f));
        list1.add(new Circle(0.6f));

        //iterateOverList1(list1); // This will not compile. List<Object> is not a parent of List<Circle>
        iterateOverList2(list1);  // Compiles and runs. List<?> is a parent of List<Circle>

        List<Circle> list2 = new ArrayList<Circle>();
        iterateOverList3(list2, 5); // compiles and runs, but lost compiler checks

        iterateOverCircles(list1); // Compiles and runs

        insertCircle2(list1, 0.9f);


    }
}

