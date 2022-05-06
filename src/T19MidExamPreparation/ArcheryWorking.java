package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Scanner;

public class ArcheryWorking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] targetNumbers = Arrays.stream(scanner.nextLine().split("\\|+")).mapToInt(e -> Integer.parseInt(e)).toArray();

        String[] command = scanner.nextLine().split("@+");
        int sumPoints = 0;

        while (!command[0].equals("Game over")) {
            switch (command[0]) {
                case "Shoot Left":
                    int startIndexLeft = Integer.parseInt(command[1]);
                    int lengthLeft = Integer.parseInt(command[2]);
                    if (startIndexLeft >= 0 && startIndexLeft < targetNumbers.length) {
                        int targetIndex = startIndexLeft - lengthLeft;
                        while (targetIndex < 0) {
                            targetIndex = targetNumbers.length + targetIndex;
                        }
                        if (targetNumbers[targetIndex] >= 5) {
                            targetNumbers[targetIndex] -= 5;
                            sumPoints += 5;
                        } else {
                            sumPoints += targetNumbers[targetIndex];
                            targetNumbers[targetIndex] = 0;
                        }
                    }
                    break;
                case "Shoot Right":
                    int startIndexRight = Integer.parseInt(command[1]);
                    int lengthRight = Integer.parseInt(command[2]);
                    if (startIndexRight >= 0 && startIndexRight < targetNumbers.length) {
                        int targetIndex = startIndexRight + lengthRight;
                        while (targetIndex >= targetNumbers.length) {
                            targetIndex = targetIndex - targetNumbers.length;
                        }
                        if (targetNumbers[targetIndex] >= 5) {
                            targetNumbers[targetIndex] -= 5;
                            sumPoints += 5;
                        } else {
                            sumPoints += targetNumbers[targetIndex];
                            targetNumbers[targetIndex] = 0;
                        }
                    }
                    break;
                case "Reverse":
                    reverseNumbers(targetNumbers);
                    break;
            }
            command = scanner.nextLine().split("@+");
        }
        for (int i = 0; i < targetNumbers.length - 1; i++) {
            System.out.print(targetNumbers[i] + " - ");
        }
        System.out.println(targetNumbers[targetNumbers.length - 1]);
        System.out.printf("Iskren finished the archery tournament with %d points!", sumPoints);
    }

    private static int[] reverseNumbers(int[] targetNumbers) {
        for (int i = 0; i < targetNumbers.length / 2; i++) {
            int tempNumber = targetNumbers[i];
            targetNumbers[i] = targetNumbers[targetNumbers.length - 1 - i];
            targetNumbers[targetNumbers.length - 1 - i] = tempNumber;
        }
        return targetNumbers;
    }
}
