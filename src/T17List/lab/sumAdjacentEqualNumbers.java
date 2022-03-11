package T17List.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class sumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 //List<Integer> numbers = nextLineOfInts(scanner);
        List<Integer> numbers = new ArrayList<>(Arrays.asList(8, 2, 2, 4, 8, 16));

        List<Integer> nextNumbers = sumAdjacentEqualNumbers(numbers);
        while (nextNumbers.size() != numbers.size()) {
            numbers = nextNumbers;
            nextNumbers = sumAdjacentEqualNumbers(numbers);
        }
        for (int number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static List<Integer> sumAdjacentEqualNumbers(List<Integer> numbers) {
        List<Integer> nextNumbers = new ArrayList<>();
        int i = 0;
        while (i < numbers.size()) {
            if (i < numbers.size() - 1 && numbers.get(i) == numbers.get(i + 1)) {
                nextNumbers.add(numbers.get(i) + numbers.get(i + 1));
                i += 2;
            } else {
                nextNumbers.add(numbers.get(i));
                i++;
            }
        }
        return nextNumbers;
    }
}
