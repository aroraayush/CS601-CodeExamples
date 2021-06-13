package builderPattern;

import java.rmi.server.UnicastRemoteObject;

public class BankAccountBuilder {
    private final long accountNumber;
    private final String name;

    private final double balance;

    private double getBalance(float bal){
        return balance;
    }

    // Static Nested Class
    public static class Builder{
        private long accountNumber;
        private String name;

        private double balance;

        public Builder(long accountNumber,String accountHolderName){
            this.accountNumber = accountNumber;
            this.name = accountHolderName;
        }

        public Builder setBalance(double balance){
            this.balance = balance;
            return this;
        }

        public BankAccountBuilder build(){

            // Giving instance of Builder Class to Outer Class
            return new BankAccountBuilder(this);
        }
    }

    public BankAccountBuilder(Builder builder){
        this.accountNumber = builder.accountNumber;
        this.name = builder.name;
        this.balance = builder.balance;
    }
}
