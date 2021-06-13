package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class RectangleTest {
    private int w;
    private int h;
    private int expectedArea;

    @Parameterized.Parameters(name= "Rectangle {0},{1} = Area {2}")
    public static List<Object[]> data() {
        List<Object[]> allParams = new ArrayList<>();
        Object[] params1 = {1, 1, 1}; // 1 is w, 1 is h, 1 is the expected area
        allParams.add(params1);
        Object[] params2 = {2, 3, 6}; // 2 is w, 3 is h, 6 is the expected area
        allParams.add(params2);
        return allParams;
    }

    public RectangleTest(int w, int h, int area) {
        this.w = w;
        this.h = h;
        this.expectedArea = area;
    }

    @Test
    public void testArea() {
        Rectangle r = new Rectangle(w, h);
        assertEquals("area() method is incorrect", expectedArea, r.area());
    }

}
