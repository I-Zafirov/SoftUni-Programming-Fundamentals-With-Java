package x08_DataTypesAndVariables.exercise;

import java.util.Scanner;

public class x09_SpiceMustFlow2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startYield = Integer.parseInt(scanner.nextLine());
        int countDays = 0;
        int total = 0;

        while (startYield >= 100) {
            int currentYield = startYield;
            currentYield -= 26;
            total += currentYield;
            startYield -= 10;
            countDays++;
        }

        if (startYield < 100) {
            total -= 26;
        }

        if (total < 26) {
            total -= total;
        }
        System.out.println(countDays);
        System.out.println(total);


    }
}