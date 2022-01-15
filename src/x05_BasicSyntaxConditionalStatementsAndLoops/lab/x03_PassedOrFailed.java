package x05_BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class x03_PassedOrFailed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());
        if (n < 3) {
            System.out.println("Failed!");
        } else {
            System.out.println("Passed!");
        }
    }
}
