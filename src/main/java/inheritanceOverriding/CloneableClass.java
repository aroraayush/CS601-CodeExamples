package inheritanceOverriding;

public class CloneableClass implements Cloneable  {
    private int var;
    private Point point;

    public CloneableClass(int var) {
        this.var = var;
    }

    public CloneableClass(int var, int x, int y) {
        this.var = var;
        this.point = new Point(x, y);
    }

    public int getPointHashCode() {
        return point.hashCode();
    }
    @Override
    public CloneableClass clone() {
        try {
            return (CloneableClass)super.clone(); //new CloneableClass(x);
        }
        catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        return null;
    }

    public String toString() {
        String res =  String.valueOf(var);
        if (point != null) {
            res = res + " " + point.toString();
        }
        return res;
    }
}
