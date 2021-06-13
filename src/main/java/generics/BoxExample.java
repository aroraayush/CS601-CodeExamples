package generics;

public class BoxExample {
    public static void main(String[] args) {

        Box<Integer> intBox = new Box<>(10);
        int intBoxVal = intBox.getData();
        System.out.println(intBox.getData());

        Box<String> boxString = new Box("hello");
        String s = boxString.getData();
        System.out.println(s);

        // Compile Time Error
//        String s2 = (String) intBox.getData();

        Box<Integer> boxInteger = new Box(15);
        int i = boxInteger.getData();

        System.out.println(s + System.lineSeparator() + i);

        // Type inference
        Box<Object> objBox = new Box<>("Alkantara");
        System.out.println(objBox.getData());

        // Will throw Error
//        Box<Object> box2 = new Box<String>("hello");
//        System.out.println(box2.getData());

        // Demonstrates wildcards
		/*Box<?> b1 = new Box<Integer>(31); // valid
          Box<?> b2 = new Box<String>("Hi"); // valid
		  b1 = b2; // valid
		*/

    }
}
