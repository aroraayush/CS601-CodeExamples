package decoratorExample;

/** The decorator: adds Milk to the Beverage
 *  The code is modified from Head First Design Pattern book.
 *
 */
public class BeverageWithMilk extends CondimentDecorator {
	private Beverage beverage;
	// Example : OutputStream passed to PrintWriter

	// Decorator: When we have inheritance and composition of same object;
	// CondimentDecorator cannot exist without class Beverage
	public BeverageWithMilk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
