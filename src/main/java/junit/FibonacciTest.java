package junit;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/** Parameterized JUnit class,
 *  example from https://junit.org/junit4/javadoc/4.12/org/junit/runners/Parameterized.html */
@RunWith(Parameterized.class)
public class FibonacciTest {
    @Parameters(name= "{index}: fib[{0}]={1}")
    public static Iterable<Object[]> data() {
        List<Object[]> allParams = new ArrayList<>();
        allParams.add(new Object[]{0, 0});
        allParams.add(new Object[]{1, 1});
        allParams.add(new Object[]{2, 1});
        allParams.add(new Object[]{3, 2});
        allParams.add(new Object[]{4, 3});
        allParams.add(new Object[]{5, 5});

        return allParams;

    }

    private int fInput;
    private int fExpected;

    public FibonacciTest(int input, int expected) {
        fInput= input;
        fExpected= expected;
    }

    @Test
    public void test() {
        assertEquals(fExpected, Fibonacci.compute(fInput));
    }
}