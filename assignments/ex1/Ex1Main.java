package assignments.ex1;
import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a string in the format: 123b4");
        String num1 = "", num2="", quit = "quit";
        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals("quit")) {
                boolean isValid1 = Ex1.isNumber(num1); //checks if the input is valid using isNumber
                int value1 = Ex1.number2Int(num1);
                System.out.println("num1= " + num1 + "is number: " + isValid1 + " , value: " + value1);

                // add your code here

                /////////////////////
            }

        }
        System.out.println("quiting now...");
    }
}
