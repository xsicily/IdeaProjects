/*
Exercise: write a program which can fit the following requirements:
if the number is divisible by 5, then output "Fizz";
if the number is divisible by 3, then output "Buzz";
if the number is divisible by 3 and 5, then output "FizzBuzz";
if the number is not divisible by 3 or 5, then output the same number.
*/

// The Scanner class is used to get user input, and it is found in the java.util package.

import java.util.Scanner;

// The class name is Uppercase
public class Main {
    public static void main(String[] args) {
        //  create an object of the Scanner class
        // The System.in field permits you to read input from the keyboard.
        Scanner scanner= new Scanner(System.in);
        // print() method in Java is used to display a text on the console.
        // It does not add any new line.
        System.out.print("Number: ");
        // method nextInt()--> read a int value from the user
        int number = scanner.nextInt();
        if (number % 5 == 0 && number % 3 == 0)
            // System.out.println() is used to print an argument that is passed to it.
            // It adds new line after the message gets displayed.
            System.out.println("FizzBuzz");
        else if (number % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);
    }
}

/*
Refactor the code by using nested if

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //  create an object of the Scanner class
        // The System.in field permits you to read input from the keyboard.
        Scanner scanner= new Scanner(System.in);
        // print() method in Java is used to display a text on the console.
        // It does not add any new line.
        System.out.print("Number: ");
        // method nextInt()--> read a int value from the user
        int number = scanner.nextInt();
        if (number % 5 == 0) {
            if (number % 3 == 0)
                System.out.println("FizzBuzz");
            else
                System.out.println("Fizz");
        }
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println(number);
    }
}
*/
