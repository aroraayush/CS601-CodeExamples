package generics;

public class MathBoxExample {
	public static void main(String[] args) {
		MathBox<Integer> iBox = new MathBox<Integer>(5);
		Integer v = iBox.getData();
		System.out.println(v);
		System.out.println(iBox.sqrt());

		MathBox<Number> m = new MathBoxSubclass<Number>(5, 6);
		System.out.println(((MathBoxSubclass)m).add());

		//MathBox<Number> nBox = new MathBox<Integer>(4); // won't compile - no upcasting!

	}
}
