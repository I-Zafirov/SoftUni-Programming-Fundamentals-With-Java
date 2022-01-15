package x05_BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class x12_EvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        while (number % 2 != 0) {
            System.out.println("Please write an even number.");
            number = scanner.nextInt();
        }
        System.out.printf("The number is: %d", Math.abs(number));
    }
}
