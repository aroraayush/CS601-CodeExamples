package codeCamp1;

import static org.junit.Assert.*;
import org.junit.Test;

public class RectangleTest {

    @Test
    public void testArea() {
        Rectangle r = new Rectangle(3, 4);
        assertEquals("Area is not as expected", 12, r.area(),0.0001);
    }

    @Test
    public void testPerimeter() {
        Rectangle r = new Rectangle(3, 4);
        assertEquals("Perimeter is not as expected", 14, r.perimeter(),0.0001);
    }
}
