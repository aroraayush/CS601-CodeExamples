package generics;

public class MathBox<T extends Number> {
	private T data;

	public MathBox(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public double sqrt() {
		return Math.sqrt(getData().doubleValue());
	}
}
