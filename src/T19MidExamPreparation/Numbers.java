package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int[] array = parseArray(line);

        double sum = 0.0;

        for (int number : array) {
            sum += number;
        }
        double average = sum / array.length;

        List<Integer> aboveAverage = new ArrayList<>();
        for (int number : array) {
            if (number > average) {
                aboveAverage.add(number);
            }
        }
        if (aboveAverage.isEmpty()) {
            System.out.println("No");
        } else {
            Collections.sort(aboveAverage);
            Collections.reverse(aboveAverage);

            for (int i = 0; i < Math.min(aboveAverage.size(), 5); i++) {
                System.out.print(aboveAverage.get(i) + " ");
            }
        }
    }

    private static int[] parseArray(String numbersString) {
        String[] numbersAsStrings = numbersString.split(" ");
        int[] array = new int[numbersAsStrings.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbersAsStrings[i]);
        }
        return array;
    }
}
