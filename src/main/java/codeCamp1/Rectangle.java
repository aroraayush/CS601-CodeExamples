package codeCamp1;

/** An class that represents a rectangle. Stores its width and height.
 *  A subclass of class Shape2D. */
public class Rectangle  {
    private double x;
    private double y;

    public Rectangle(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double perimeter() {
        return 2*(x + y);
    }

    public double area() {
        return x*y;
    }
}
