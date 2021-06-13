package command;

/** The same command pattern can be easily implemented using lambda functions and the code is shorter.
 * In this case, we do not need to create concrete command classes. */
public class RemoteLoaderWithLambda {
 
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
 
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan= new CeilingFan("Living Room");
		GarageDoor garageDoor = new GarageDoor();
		Stereo stereo = new Stereo("Living Room");
 
		remoteControl.setCommand(0, ()->livingRoomLight.on(), ()->livingRoomLight.off());
		remoteControl.setCommand(1, ()->kitchenLight.on(), ()->kitchenLight.off());
		remoteControl.setCommand(2, ()->ceilingFan.high(), ()->ceilingFan.off());
		remoteControl.setCommand(3, ()->stereo.on(), ()->stereo.off());
		remoteControl.setCommand(4, ()->garageDoor.up(), ()->garageDoor.down());

		for (int slot = 0; slot <= 4; slot++) {
			remoteControl.onButtonWasPushed(slot);
			remoteControl.offButtonWasPushed(slot);
		}
	}
}
