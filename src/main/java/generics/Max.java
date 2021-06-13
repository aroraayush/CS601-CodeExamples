package generics;

/** Demonstrates the use of raw types.
 * However, using raw types is actually NOT a good idea.
 * Avoid it whenever possible */
public class Max {
	
	/** This method is NOT PARAMETERIZED.
	 * Return type is of type Comparable
	 * It's a regular method that takes references of Comparable type 
	 * as a parameter  - it is NOT actually a good idea to use raw types
	 * @param e1 Comparable The first element to compare
	 * @param e2 Comparable The second element to compare
	 * @returns Comparable The largest of the two elements (according to how compareTo is implemented)
	 */
	public static Comparable findMax(Comparable e1, Comparable e2) {
		// compareTo() defined in Circle Class
		// Comparing e1 to e2, so e1's type will be compared to e2's type
		if (e1.compareTo(e2) < 0)
			return e2;
		else
			return e1;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Max.findMax(new Circle (4.5), new Circle (8)));
		
		// The code below compiles. Crashes at runtime since it can't compare  a string with an integer. 
		// We would like to catch these types of errors at compile time.
		//System.out.println(Max.findMax("Star Wars", 3));
				
	}
	
}
