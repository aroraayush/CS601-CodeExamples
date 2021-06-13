package strategy;

/** From the strategy design pattern example, from Head First Design Patterns */
public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
