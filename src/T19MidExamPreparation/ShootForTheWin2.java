package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int shots = 0;
        while (true) {
            String input = scanner.nextLine();
            if ("End".equals(input)) {
                break;
            }
            int index = Integer.parseInt(input);
            int currentTarget = 0;
            if (index >= 0 && index < numbers.length) {
                currentTarget = numbers[index];
                numbers[index] = -1;
                shots++;
            }
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] > currentTarget && numbers[i] != -1) {
                    numbers[i] -= currentTarget;
                } else if (numbers[i] <= currentTarget && numbers[i] != -1) {
                    numbers[i] += currentTarget;
                }
            }
        }
        System.out.printf("Shot targets: %d -> ", shots);
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length - 1) {
                System.out.print(" ");
            }
        }
    }
}
