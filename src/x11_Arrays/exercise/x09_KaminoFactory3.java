package x11_Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class x09_KaminoFactory3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        int masterCounter = 0;
        int bestCounter = 0;
        int bestSequence = 0;
        int bestSequenceIndex = 0;
        int bestSequenceSum = 0;
        int[] bestDnaSequence = new int[n];

        while (!"Clone them!".equals(input)) {
            int currentSum = 0, currentIndex = Integer.MAX_VALUE, currentSequence = 1;
            int[] currentDNA = Arrays
                    .stream(input.split("!+"))
                    .limit(n)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            masterCounter++;

            for (int j : currentDNA) {
                if (j == 1) {
                    currentSum++;
                }
            }
            for (int i = 0; i < currentDNA.length - 1; i++) {
                if (currentDNA[i] == currentDNA[i + 1] && currentDNA[i] == 1) {
                    currentSequence++;
                    if (i < currentIndex) {
                        currentIndex = i;
                    }
                }
            }

            if ((currentSequence > bestSequence)
                    || ((currentSequence == bestSequence) && (currentIndex < bestSequenceIndex))
                    || ((currentSequence == bestSequence) && (currentIndex == bestSequenceIndex)
                    && (currentSum > bestSequenceSum))) {
                bestCounter = masterCounter;
                bestSequence = currentSequence;
                bestSequenceIndex = currentIndex;
                bestSequenceSum = currentSum;
                bestDnaSequence = currentDNA;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestCounter, bestSequenceSum);
        for (int i : bestDnaSequence) {
            System.out.print(i + " ");
        }
    }
}
