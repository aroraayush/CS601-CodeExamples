package builderPattern;

public class USFStudent {
    private final int id;
    private final String name;
    private final int numCourses;
    private final String address;

    private USFStudent(int id, String name, int numCourses, String address) {
        this.id = id;
        this.name = name;
        this.numCourses = numCourses;
        this.address = address;
    }

    public static class Builder {
        private int id; // required
        private String name; // required
        private int numCourses;
        private String address;

        public Builder(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public Builder setCourses(int numCourses) {
            this.numCourses = numCourses;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public USFStudent build() {
            return new USFStudent(id, name, numCourses, address);
        }

    }

    public static void main(String[] args) {
        USFStudent.Builder builder = new USFStudent.Builder(1,"ayush");
//        USFStudent student = builder.setAddress("150 Font").setCourses(1).build();
        builder.setAddress("150 Font");
//        USFStudent student = builder.setCourses(1).build();
        USFStudent student = builder.build();
        System.out.println(student);
    }

//    public static void main(String[] args) {
//        USFStudent.Builder builder = new USFStudent.Builder(1, "Alice");
//        builder.setAddress("45 Geary, San Francisco, CA").setCourses(5);
//        USFStudent st = builder.build();
//    }
}
