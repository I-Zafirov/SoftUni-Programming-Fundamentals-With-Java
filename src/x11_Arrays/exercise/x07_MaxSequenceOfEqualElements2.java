package x11_Arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class x07_MaxSequenceOfEqualElements2 {
     public static void main(String[] args) {

          Scanner scan = new Scanner(System.in);
          int[] numbers = Arrays.stream(scan.nextLine()
                  .split(" ")).mapToInt(Integer::parseInt)
                  .toArray();

          int count = 0;
          int maxCount = 0;
          StringBuilder sequence = new StringBuilder();
          StringBuilder maxSequence = new StringBuilder();

          for (int i = 0; i < numbers.length - 1; i++) {
               if (numbers[i] == numbers[i + 1]) {
                    if (count == 0) {
                         count++;
                         sequence.append(numbers[i]).append(" ").append(numbers[i + 1]).append(" ");
                    } else {
                         count++;
                         sequence.append(numbers[i]).append(" ");
                    }
               } else {
                    count = 0;
                    sequence = new StringBuilder();
               }
               if (count > maxCount) {
                    maxSequence = sequence;
                    maxCount = count;
               }
          }
          if (maxCount == 0) {
               maxSequence.append("1");
          }
          System.out.println(String.join(" ", maxSequence));
     }
}
