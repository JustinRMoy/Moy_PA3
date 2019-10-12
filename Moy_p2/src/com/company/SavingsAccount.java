package com.company;

public class SavingsAccount {
    private double savingsBalance;
    private static double annualInterestRate;

    public SavingsAccount(){
        savingsBalance = 0;
    }

    public  SavingsAccount(double balance){
        savingsBalance = balance;
    }

    public void  calculateMonthlyInterest(){
        savingsBalance += ((savingsBalance * annualInterestRate) / 12);
    }

    public static void modifyInterestRate(double newInterest){
        annualInterestRate = newInterest;
    }

    public double getSavingsBalance() {
        return savingsBalance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
}
