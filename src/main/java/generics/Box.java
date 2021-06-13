package generics;

/**
 * General class
 */
class IntBox {

    private int data;

    public IntBox(int data2) {
        this.data = data2;
    }
    public int getData() {
        return data;
    }

}

/**
 * With Generics
 * @param <T> - Type
 */
public class Box<T> {

	private T data;
	public Box(T data) {
		this.data = data;
	}
	public T getData() {
		return data;
	}

}
