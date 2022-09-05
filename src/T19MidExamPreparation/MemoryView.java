package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MemoryView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String result = "";
        List<String> numbers = new ArrayList<>();

        while (!line.equals("Visual Studio crash")) {

            result += line + " ";
            line = scanner.nextLine();
        }

        List<String> words = new ArrayList<>();
        numbers = Arrays.stream(result.split("\\s+"))
                .map(String::trim).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 5; i++) {
            String word = "";

            if (numbers.get(i).equals("32656") && numbers.get(i + 1).equals("19759")
                    && numbers.get(i + 2).equals("32763") && numbers.get(i + 3).equals("0") && numbers.get(i + 5).equals("0")) {

                int length = Integer.parseInt(numbers.get(i + 4));

                for (int j = i + 6; j < i + 6 + length; j++) {
                    word += (char) Integer.parseInt(numbers.get(j));
                }

            }

            if (!word.equals("")) {
                words.add(word);
            }
        }

        for (String word : words) {
            System.out.print(word.trim() + "\n");
        }

    }
}
