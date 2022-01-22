package x08_DataTypesAndVariables.lab;

import java.util.Scanner;

public class x10_SpecialNumbers2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String digit = "" + i;
            int sumOfDigits = 0;

            for (int j = 0; j < digit.length(); j++) {
                sumOfDigits += Integer.parseInt(String.valueOf((digit).charAt(j)));
            }

            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }
}
