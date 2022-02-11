package x11_Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class x07_CondenseArrayToNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        while (numbers.length > 1) {
            int[] second = new int[numbers.length - 1];

            for (int i = 0; i < numbers.length - 1; i++) {
                second[i] = numbers[i] + numbers[i + 1];
                numbers[i] = second[i];
            }
            numbers = second;
        }
        System.out.println(numbers[0]);
    }
}
