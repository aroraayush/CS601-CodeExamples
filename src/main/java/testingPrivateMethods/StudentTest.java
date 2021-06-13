package testingPrivateMethods;

import basicsClassesObjects.Student;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;


/** Tests for class Student. Shows one approach to testing private methods. */
public class StudentTest {

    @Test
    public void testToString() {
        Student st = new Student("Helen Chen");
        String expected = "Student: " + System.lineSeparator() + "First name: Helen";
        assertEquals("toString() fails for input Helen Chen", expected, st.toString());
    }

    @Test
    public void testGetFirstName() {
        Student st = new Student("Helen Chen");
        String expected = "Helen";
        try {
            Class student = Student.class;
            Method method = student.getDeclaredMethod("getFirstName", null);
            ((Method) method).setAccessible(true);

            String result = (String)(method.invoke(st, null));
            System.out.println(result);
            assertEquals("getFirstName() fails for input Helen Chen", expected, result);

        }
        catch (Exception e) {
            System.out.println(e);
        }

    }



}
