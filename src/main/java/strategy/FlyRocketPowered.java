package strategy;

/** From the strategy design pattern example, from Head First Design Patterns */
public class FlyRocketPowered implements FlyBehavior {
	public void fly() {
		System.out.println("I'm flying with a rocket");
	}
}
