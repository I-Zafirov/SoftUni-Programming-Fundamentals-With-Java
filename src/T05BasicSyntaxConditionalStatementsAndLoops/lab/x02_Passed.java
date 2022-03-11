package T05BasicSyntaxConditionalStatementsAndLoops.lab;

import java.util.Scanner;

public class x02_Passed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double n = Double.parseDouble(scanner.nextLine());
        if (n >= 3) {
            System.out.println("Passed!");
        }
    }
}
