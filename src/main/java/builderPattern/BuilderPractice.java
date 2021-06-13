package builderPattern;

public class BuilderPractice {
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required

    private final int calories;     //                 optional
    private final int fat;          // (g)             optional
    private final int sodium;       // (mg)            optional
    private final int carbohydrate; // (g)             optional


    /** Basic implementation of Builder class that contains builds
     * about a food item. */
    public static class Builder {
        private int servingSize;
        private int servings;


        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        /**
         * Constructor for class Builder
         *
         * @param servingSize  serving size (in spoons)
         * @param servings     number of servings
         */
        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder setCarbohydrate(int carbs){
            this.carbohydrate = carbs;
            return this;
        }

        public Builder setSodoum(int sodium){
            this.sodium = sodium;
            return this;
        }

        public Builder setFat(int fat){
            this.fat = fat;
            return this;
        }

        public Builder setCalories(int cal){
            this.calories = cal;
            return this;
        }

        public BuilderPractice build(){
            return new BuilderPractice(this);
        }
    }

    public BuilderPractice (Builder builder){
        this.calories = builder.calories;
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    public int getServingSize() {
        return servingSize;
    }

    public int getServings() {
        return servings;
    }

    public int getCalories() {
        return calories;
    }

    public int getFat() {
        return fat;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCarbohydrate() {
        return carbohydrate;
    }
}
