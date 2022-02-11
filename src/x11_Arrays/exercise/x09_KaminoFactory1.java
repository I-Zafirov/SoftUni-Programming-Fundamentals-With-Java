package x11_Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class x09_KaminoFactory1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int bestSequenceSum = 0;
        int bestSequenceIndex = 0;
        int count = 0;
        int sequenceIndex = length;
        int[] bestDnaSequence = new int[length];

        while (!input.equals("Clone them!")) {
            int[] numbers = Arrays.stream(input.split("!+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int sum = 0;
            int index = length;
            count++;

            for (int i = 0; i < numbers.length; i++) {
                if ((i != numbers.length - 1) && numbers[i] == 1
                        && numbers[i + 1] == 1 && index == length) {
                    index = i;
                }
                sum += numbers[i];
            }
            if (index == sequenceIndex && sum > bestSequenceSum) {
                bestDnaSequence = numbers;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;
            } else if (index < sequenceIndex) {
                bestDnaSequence = numbers;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;
            }
            input = scanner.nextLine();
        }
        if (bestSequenceSum == 0) {
            bestSequenceIndex = 1;
        }
        System.out.printf("Best DNA sample %d with sum: %d.%n",
                bestSequenceIndex, bestSequenceSum);
        Arrays.stream(bestDnaSequence)
                .mapToObj(value -> value + " ")
                .forEach(System.out::print);
    }
}
