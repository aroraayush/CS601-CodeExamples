package inheritanceOverriding;

public class CloneableExample {
    public static void main(String[] args) {
        //CloneableClass clonable = new CloneableClass(5);
        CloneableClass clonable = new CloneableClass(5, 10, 20);
        CloneableClass copy = clonable.clone();
        System.out.println(copy);
        System.out.println(clonable.getPointHashCode());
        System.out.println(copy.getPointHashCode());
    }
}
