package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList();
        Student st1 = new Student("Z", 1);
        Student st2 = new Student("A", 2);
        Student st3 = new Student("B", 3);
        students.add(st1);
        students.add(st2);
        students.add(st3);

        // With Comparable
        Collections.sort(students);
        System.out.println(students);

        // With Comparator - verbose code
        StudentIDComparator comp1 = new StudentIDComparator();
        TreeSet<Student> set1 = new TreeSet(comp1);
        set1.add(st1);
        set1.add(st2);
        System.out.println(set1);

        // With Comparator<T> - Lambda Notation
        TreeSet<Student> studentSet;
        studentSet = new TreeSet<>((c1,c2) ->{
            // compareTo has to be overrided
            if (st1.getId() < st2.getId())
                return -1;
            else if (st1.getId() > st2.getId())
                return 1;
            else
                return 0;
        });
        studentSet.add(st1);
        studentSet.add(st3);
        studentSet.add(st2);

        System.out.println(studentSet);

        for (Student car: studentSet) {
            System.out.println(car);
            // breal allowed, return not allowed
        }
    }
}
