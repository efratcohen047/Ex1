package assignments.ex1;

import java.util.Scanner;

public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\\n");
        String num1 = "", num2="", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");

            // Get first number from user
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals("quit")) {
                // Validate first number and convert to integer
                boolean isValid1 = Ex1.isNumber(num1);
                int value1 = Ex1.number2Int(num1);
                System.out.println("num1= " + num1 + "is number: " + isValid1 + " , value: " + value1);

                // Check if first number is valid, continue if not
                if (!isValid1) {
                    System.out.println("Error: num1 is in the wrong format (" + num1 + ")");
                    continue;
                }
                // Get second number from user
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals("quit")) {
                    // Validate second number and convert to integer
                    boolean isValid2 = Ex1.isNumber(num2);
                    int value2 = Ex1.number2Int(num2);
                    System.out.println("num2= " + num2 + " is number: " + isValid2 + " , value: " + value2);
                    // Check if second number is valid, continue if not
                    if (!isValid2){
                        System.out.println("Error: num2 is in the wrong format (" + num2 + ")");
                        continue;
                    }

                    System.out.println("Enter a base for output: (a number [2,16] ");
                    int outputBase = sc.nextInt();

                    int sum = value1 + value2;
                    int product = value1 * value2;
                    String sumInBase = Ex1.int2Number(sum, outputBase);
                    String productInBase = Ex1.int2Number(product, outputBase);

                    System.out.println(num1 + " + " +num2 + " = " + sumInBase);
                    System.out.println(num1 + " * " + num2 + " = " + productInBase);

                    String[]  numbers = {num1, num2, sumInBase, productInBase};
                    int maxIndex = Ex1.maxIndex(numbers);
                    System.out.println("Max number over [" + num1 + "," + num2 + "," + sumInBase + "," + productInBase + "] is: " + numbers[maxIndex]);
                }
            }
        }
        System.out.println("quiting now...");
    }
}
