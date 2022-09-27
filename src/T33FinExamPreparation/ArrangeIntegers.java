package T33FinExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ArrangeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputLine = scanner.nextLine()
                .replace("1", "one")
                .replace("2", "two")
                .replace("3", "three")
                .replace("4", "four")
                .replace("5", "five")
                .replace("6", "six")
                .replace("7", "seven")
                .replace("8", "eight")
                .replace("9", "nine")
                .replace("0", "zero")
                .split(", ");
        Arrays.sort(inputLine);

        for (int i = 0; i < inputLine.length; i++) {
            inputLine[i] = inputLine[i]
                    .replaceAll("one", "1")
                    .replaceAll("two", "2")
                    .replaceAll("three", "3")
                    .replaceAll("four", "4")
                    .replaceAll("five", "5")
                    .replaceAll("six", "6")
                    .replaceAll("seven", "7")
                    .replaceAll("eight", "8")
                    .replaceAll("nine", "9")
                    .replaceAll("zero", "0");
        }

        for (int i = 0; i < inputLine.length - 1; i++) {
            System.out.print(inputLine[i] + ", ");
        }

        System.out.print(inputLine[inputLine.length - 1]);
    }
}
