package x14_Methods.exercise;

import java.util.Scanner;

public class x10_TopNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= input; i++) {
            int currentNum = i;

            if (isSumDivisibleOf8(currentNum)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isSumDivisibleOf8(int currentNum) {
        int sumOfDigits = 0;
        int currentDigit = 0;
        boolean isValid = false;
        boolean isOdd = false;

        while (currentNum > 0) {
            currentDigit = currentNum % 10;
            sumOfDigits += currentDigit;
            currentNum /= 10;
            if (currentDigit % 2 != 0) {
                isOdd = true;
            }
        }
        if (sumOfDigits % 8 == 0) {
            isValid = true;
        }
        return isValid && isOdd;
    }
}
