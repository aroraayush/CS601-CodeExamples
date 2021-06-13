package generics;

public class MathBoxSubclass<T extends Number>  extends MathBox {
	private T otherData;
	public MathBoxSubclass(T data, T otherData) {
		super(data);
		this.otherData = otherData;
	}

	public String toString() {
		return "In MathBoxSubclass: " + getData() + " " + otherData;
	}

	public double add() {
		return getData().doubleValue() + otherData.doubleValue();
	}
}
