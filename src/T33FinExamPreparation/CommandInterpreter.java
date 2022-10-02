package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Arrays;

public class CommandInterpreter {
    private static BufferedReader reader;
    private static String[] array;
    private static String[] tokens;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        array = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(e -> !e.equals(""))
                .toArray(String[]::new);

        String input;
        while (!"end".equals(input = reader.readLine())) {
            tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "reverse":
                    reverseArray();
                    break;
                case "sort":
                    sortRange();
                    break;
                case "rollLeft":
                    rollLeft();
                    break;
                case "rollRight":
                    rollRight();
                    break;
            }
        }

        System.out.println(Arrays.toString(array));
    }

    private static void rollRight() {
        int times = Integer.parseInt(tokens[1]);
        if (!isValidCount(times)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        times %= array.length;
        for (int i = 0; i < times; i++) {
            String lastElement = array[array.length - 1];
            for (int j = array.length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = lastElement;
        }
    }

    private static void rollLeft() {
        int times = Integer.parseInt(tokens[1]);
        if (!isValidCount(times)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        times %= array.length;
        for (int i = 0; i < times; i++) {
            String firstElement = array[0];
            for (int j = 0; j < array.length - 1; j++) {
                array[j] = array[j + 1];
            }
            array[array.length - 1] = firstElement;
        }
    }

    private static void sortRange() {
        Collator collator = Collator.getInstance();
        int startIndex = Integer.parseInt(tokens[2]);
        int count = Integer.parseInt(tokens[4]);
        if (!inRange(startIndex, count)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        int endIndex = Math.min(array.length - 1, startIndex + count - 1);
        for (int i = startIndex; i < endIndex; i++) {
            for (int j = i + 1; j <= endIndex; j++) {
                if (collator.compare(array[i], array[j]) > 0) {
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    private static void reverseArray() {
        int startIndex = Integer.parseInt(tokens[2]);
        int count = Integer.parseInt(tokens[4]);
        if (!inRange(startIndex, count)) {
            System.out.println("Invalid input parameters.");
            return;
        }
        int endIndex = Math.min(array.length - 1, startIndex + count - 1);
        for (int i = 0; i < count / 2; i++) {
            String temp = array[startIndex];
            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    private static boolean inRange(int start, int count) {
        boolean isInRange = start >= 0 && start < array.length;
        boolean isInside = count >= 0 && start + count <= array.length;
        return isInRange && isInside;
    }

    private static boolean isValidCount(int count) {
        return count >= 0;
    }
}
