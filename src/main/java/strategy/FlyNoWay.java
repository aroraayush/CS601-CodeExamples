package strategy;

/** From the strategy design pattern example, from Head First Design Patterns */
public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
