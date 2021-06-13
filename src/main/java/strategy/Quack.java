package strategy;

/** From the strategy design pattern example, from Head First Design Patterns */
public class Quack implements QuackBehavior {
	public void quack() {
		System.out.println("Quack");
	}
}
