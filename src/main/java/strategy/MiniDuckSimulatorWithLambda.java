package strategy;

/* Shows how to implement strategy pattern with lambda. */
public class MiniDuckSimulatorWithLambda {
 
	public static void main(String[] args) {
 
		MallardDuck	mallard = new MallardDuck();
		RubberDuck	rubberDuckie = new RubberDuck();
		DecoyDuck	decoy = new DecoyDuck();
		ModelDuck	model = new ModelDuck();

		// Note: we no longer need classes Quack, Squeak, FakeQuack etc.
		mallard.setQuackBehavior(() -> System.out.println("quack"));
		rubberDuckie.setQuackBehavior(() -> System.out.println("squeak"));
		decoy.setQuackBehavior(() -> System.out.println("Silence"));
		mallard.performQuack();
		rubberDuckie.performQuack();
		decoy.performQuack();

		// Note: we no longer need classes FlyNoWay, FlyWithWings, FlyRocketPowered

		model.setFlyBehavior(()-> System.out.println("I cannot fly."));
		model.performFly();	
		model.setFlyBehavior(()-> System.out.println("I'm flying with a rocket"));
		model.performFly(); // we changed the behavior at runtime!
	}
}
