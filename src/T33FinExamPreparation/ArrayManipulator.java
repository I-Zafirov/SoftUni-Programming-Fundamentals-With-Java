package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayManipulator {
    private static int[] numbers;
    private static BufferedReader reader;
    private static String[] tokens;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        numbers = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input;
        while (!"end".endsWith(input = reader.readLine())) {
            tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "exchange":
                    exchange();
                    break;
                case "max":
                    int maxIndex = getIndexOfMaxNumber();
                    System.out.println(maxIndex == -1 ? "No matches" : maxIndex);
                    break;
                case "min":
                    int minIndex = getIndexOfMinNumber();
                    System.out.println(minIndex == -1 ? "No matches" : minIndex);
                    break;
                case "first":
                    getFirstNumbers();
                    break;
                case "last":
                    getLastNumbers();
                    break;
            }
        }

        System.out.println(Arrays.toString(numbers));
    }

    private static void getLastNumbers() {
        int count = Integer.parseInt(tokens[1]);
        if (!isValidCount(count)) {
            System.out.println("Invalid count");
            return;
        }
        int searched = getSearched(tokens[2]);
        List<Integer> nums = new ArrayList<>();
        int i = numbers.length - 1;
        while (count > 0 && i >= 0) {
            int number = numbers[i--];
            if (number % 2 == searched) {
                nums.add(number);
                count--;
            }
        }

        for (int j = 0; j < nums.size() / 2; j++) {
            int temp = nums.get(j);
            nums.set(j, nums.get(nums.size() - 1 - j));
            nums.set(nums.size() - 1 - j, temp);
        }

        System.out.println(nums.toString());

    }

    private static void getFirstNumbers() {
        int count = Integer.parseInt(tokens[1]);
        if (!isValidCount(count)) {
            System.out.println("Invalid count");
            return;
        }
        int searched = getSearched(tokens[2]);
        List<Integer> nums = new ArrayList<>();
        int i = 0;
        while (count > 0 && i < numbers.length) {
            int number = numbers[i++];
            if (number % 2 == searched) {
                nums.add(number);
                count--;
            }
        }

        System.out.println(nums.toString());

    }

    private static int getIndexOfMinNumber() {
        int minIndex = -1;
        int minNumber = 1001;
        int searched = getSearched(tokens[1]);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == searched && numbers[i] <= minNumber) {
                minIndex = i;
                minNumber = numbers[i];
            }
        }
        return minIndex;
    }

    private static int getIndexOfMaxNumber() {
        int maxIndex = -1;
        int maxNumber = -1;
        int searched = getSearched(tokens[1]);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == searched && numbers[i] >= maxNumber) {
                maxIndex = i;
                maxNumber = numbers[i];
            }
        }
        return maxIndex;
    }

    private static void exchange() {
        int count = Integer.parseInt(tokens[1]);
        if (!isValidIndex(count)) {
            System.out.println("Invalid index");
            return;
        }

        for (int i = 0; i <= count; i++) {
            int firstElement = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = firstElement;
        }
    }

    private static boolean isValidIndex(int index) {
        return index >= 0 && index < numbers.length;
    }

    private static int getSearched(String type) {
        return type.equals("even") ? 0 : 1;
    }

    private static boolean isValidCount(int count) {
        return count <= numbers.length;
    }
}
