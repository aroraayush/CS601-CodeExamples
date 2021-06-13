package strategy;

/** From the strategy design pattern example, from Head First Design Patterns */
public class MallardDuck extends Duck {
 
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();

	}
 
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
