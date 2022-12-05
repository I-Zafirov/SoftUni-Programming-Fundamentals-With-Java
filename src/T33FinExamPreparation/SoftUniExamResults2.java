package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> contestants = new HashMap<>();
        Map<String, Integer> languageSubmits = new HashMap<>();
        String input = scanner.nextLine();

        while (!"exam finished".equals(input)) {

            String[] data = input.split("-");
            String name = data[0];

            if ("banned".equals(data[1])) {
                contestants.remove(name);
                input = scanner.nextLine();
                continue;
            }
            String language = data[1];
            int points = Integer.parseInt(data[2]);

            contestants.putIfAbsent(name, points);

            if (contestants.get(name) < points) {
                contestants.put(name, points);
            }
            languageSubmits.putIfAbsent(language, 0);
            languageSubmits.put(language, languageSubmits.get(language) + 1);

            input = scanner.nextLine();
        }
        System.out.println("Results:");

        contestants.entrySet().stream().sorted((pair1, pair2) ->
                        Integer.compare(pair2.getValue(), pair1.getValue()))
                .forEach(pair ->
                        System.out.println(String.format("%s | %d"
                                , pair.getKey(), pair.getValue())));

        System.out.println("Submissions:");

        languageSubmits.entrySet().stream().sorted((pair1, pair2) ->
                        Integer.compare(pair2.getValue(), pair1.getValue()))
                .forEach(pair ->
                        System.out.println(String.format("%s - %d"
                                , pair.getKey(), pair.getValue())));

    }
}
