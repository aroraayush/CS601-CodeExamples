package junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.*;
import static org.junit.Assert.assertEquals;

/** Demonstrates how to write JUnit tests with parameters.
 * Uses instance fields and constructors, the code is verbose */
@RunWith(Parameterized.class)

public class SquareTest {

    private int side;
    private int expectedArea;

    @Parameterized.Parameters
    public static List<Object[]> data() {
        List<Object[]> allParams = new ArrayList<>();
        Object[] params1 = {1, 1}; // 1 is the side, 1 is the expected area
        allParams.add(params1);
        Object[] params2 = {2, 4}; // 2 is the side, 4 is the expected area
        allParams.add(params2);
        return allParams;
    }

    public SquareTest(int side, int area) {
        this.side = side;
        this.expectedArea = area;
    }

    @Test
    public void testArea() {
        Square sq = new Square(side);
        assertEquals("area() method is incorrect", expectedArea, sq.area());
    }

}
