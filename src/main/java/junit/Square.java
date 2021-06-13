package junit;
/** Class Square. USed in SquareTest example that demonstrates how to deal with parameters in JUnit). */
public class Square {
    private int side;
    public Square(int side) {
        this.side = side;
    }

    public int area() {
        return side * side;
    }
}
