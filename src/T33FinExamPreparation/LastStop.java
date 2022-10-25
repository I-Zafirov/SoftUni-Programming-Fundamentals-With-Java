package T33FinExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LastStop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> paintings = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();
        while (!"END".equals(command)) {
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "Change":
                    change(paintings, tokens);
                    break;
                case "Hide":
                    hide(paintings, tokens);
                    break;
                case "Switch":
                    switchNumbers(paintings, tokens);
                    break;
                case "Insert":
                    insert(paintings, tokens);
                    break;
                case "Reverse":
                    revers(paintings);
                    break;

            }

            command = scanner.nextLine();
        }
        System.out.println(paintings.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void revers(List<Integer> paintings) {
        for (int i = 0; i < paintings.size() / 2; i++) {
            int temp = paintings.get(i);
            paintings.set(i, paintings.get(paintings.size() - 1 - i));
            paintings.set(paintings.size() - 1 - i, temp);
        }
    }

    private static void insert(List<Integer> paintings, String[] tokens) {
        int index = Integer.parseInt(tokens[1]);
        int number = Integer.parseInt(tokens[2]);

        if (index >= 0 && index < paintings.size() - 1) {
            paintings.add(index + 1, number);
        }
    }

    private static void switchNumbers(List<Integer> paintings, String[] tokens) {
        int number1 = Integer.parseInt(tokens[1]);
        int number2 = Integer.parseInt(tokens[2]);
        if (paintings.contains(number1) && paintings.contains(number2)) {
            int temp = paintings.indexOf(number2);
            paintings.set(paintings.indexOf(number1), number2);
            paintings.set(temp, number1);
        }
    }

    private static void hide(List<Integer> paintings, String[] tokens) {
        int number = Integer.parseInt(tokens[1]);

        paintings.remove(Integer.valueOf(number));
    }

    private static void change(List<Integer> paintings, String[] tokens) {
        int number = Integer.parseInt(tokens[1]);
        int newNumber = Integer.parseInt(tokens[2]);
        if (paintings.contains(number)) {
            paintings.set(paintings.indexOf(number), newNumber);
        }
    }
}
