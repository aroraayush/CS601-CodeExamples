package junit;
/** Class Square. Used in SquareTest example that demonstrates how to deal with parameters in JUnit). */
public class Rectangle {
    private int w;
    private int h;
    public Rectangle(int w, int h) {
        this.w = w;
        this.h = h;

    }

    public int area() {
        return w * h;
    }
}
