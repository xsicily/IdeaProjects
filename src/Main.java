/*
Write a program to calculate mortgage.
1. Principle ($1K - $1M) --> Enter a number between 1,000 and 1,000,000.
2. Annual Interest Rate --> Enter a value greater than 0 and less than or equal to 30.
3. Period (Years) --> Enter a value between 1 and 30.
4. Mortgage --> display results.
Mortgage calculation is based on the method 2 from https://www.wikihow.com/Calculate-Mortgage-Payments.
 */

// Select the class, then ALT+Enter import the class

import java.text.NumberFormat;
import java.util.Scanner;

// A class is a container for related functions.

// A public static method is a method that can be accessed from any other class without
// creating an instance of the class.

// When we define a method as private, it means that the method is only accessible within the same class.

// a private static method is a method that can only be accessed within the same class and
// does not require an instance of the class to be created.

public class Main {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    // Need the output from other methods, e.g., getLoanAmount(), getAnnualInterestRate(), getNumberOfPayments()
    public static void main(String[] args) {
        // Create an instance of Scanner class
        Scanner scanner = new Scanner(System.in);

        float loanAmount = getLoanAmount(scanner);
        float annualInterestRate = getAnnualInterestRate(scanner);
        int numberOfPayments = getNumberOfPayments(scanner);

        double mortgage = calculateMortgage(loanAmount, annualInterestRate, numberOfPayments);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage Payment: " + mortgageFormatted);
    }

    // Get and evaluate the amount of loan
    private static float getLoanAmount(Scanner scanner) {
        while (true) {
            System.out.print("Loan amount ($1K - $1M): ");
            float loanAmount = scanner.nextFloat();
            if (loanAmount >= 1000 && loanAmount <= 1_000_000) {
                return loanAmount;
            }
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }
    }

    // Get the annual interest rate
    private static float getAnnualInterestRate(Scanner scanner) {
        while (true) {
            System.out.print("Annual Interest Rate: ");
            float annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30) {
                return annualInterest;
            }
            System.out.println("Enter a value greater than 0 and less than or equal to 30.");
        }
    }

    // Get the number of payments
    private static int getNumberOfPayments(Scanner scanner) {
        while (true){
            System.out.print("Period (Years): ");
            byte years = scanner.nextByte();
            if (years >= 1 && years <= 30){
                return years * MONTHS_IN_YEAR;
            }
            System.out.println("Enter a value between 1 and 30.");
        }
    }

    // Calculate the mortgage
    private static double calculateMortgage(float loanAmount, float annualInterestRate, int numberOfPayments) {
        float monthlyInterestRate = annualInterestRate / PERCENT / MONTHS_IN_YEAR;
        return loanAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfPayments)
                / (Math.pow(1 + monthlyInterestRate, numberOfPayments) -1);
    }
}