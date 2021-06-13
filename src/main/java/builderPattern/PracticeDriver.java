package builderPattern;

public class PracticeDriver {
    public static void main(String[] args) {
        BuilderPractice.Builder builderObj = new BuilderPractice.Builder(1,2);
        BuilderPractice bp = builderObj.setCalories(1).setCarbohydrate(2).setFat(3).setFat(4).build();
        System.out.println(bp);
    }
}
