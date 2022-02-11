package x11_Arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class x07_CondenseArrayToNumber3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int count = numbers.length - 1;

        while (count > 0) {

            for (int i = 0; i < numbers.length - 1; i++) {
                int sum = numbers[i] + numbers[i + 1];
                numbers[i] = sum;
            }
            count--;
        }
        System.out.println(numbers[0]);
    }
}
