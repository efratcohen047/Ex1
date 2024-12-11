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
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals("quit")) {
                boolean isValid1 = Ex1.isNumber(num1); //checks if the input is valid using isNumber
                int value1 = Ex1.number2Int(num1);
                System.out.println("num1= " + num1 + "is number: " + isValid1 + " , value: " + value1);

                // add your code here
                if (!isValid1) {
                    System.out.println("Error: num1 is in the wrong format (" + num1 + ")");
                    continue;
                }
                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals("quit")) {
                    boolean isValid2 = Ex1.inNumber(num2);
                    int value2 = Ex1.number2int(num2);
                }

                /////////////////////
            }

        }
        System.out.println("quiting now...");
    }
}
