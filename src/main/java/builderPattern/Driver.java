package builderPattern;
/** Driver class for the Builder Pattern */
public class Driver {
    public static void main(String[] args) {
        NutritionFactsWithBuilder.Builder builder = new NutritionFactsWithBuilder.Builder(20, 8);
        NutritionFactsWithBuilder nf = builder.calories(300).fat(10).build();
        System.out.println(nf);
    }

//    public static void main(String[] args) {
//        BankAccountBuilder.Builder builder = new BankAccountBuilder.Builder(123456789L,"Shazam");
//        builder.setBalance(12.34);
//        BankAccountBuilder bankAccount = builder.build();
//        System.out.println(bankAccount);
//    }

}
