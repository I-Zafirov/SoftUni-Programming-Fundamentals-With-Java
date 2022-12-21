package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Weightlifting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, Long>> lifters = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String name = line.split(" ")[0];
            String exercise = line.split(" ")[1];
            Integer weight = Integer.parseInt(line.split(" ")[2]);

            if (!lifters.containsKey(name)) {
                lifters.put(name, new TreeMap<>());
            }

            if (!lifters.get(name).containsKey(exercise)) {
                lifters.get(name).put(exercise, 0L);
            }

            Long totalWeight = lifters.get(name).get(exercise) + (long) weight;
            lifters.get(name).replace(exercise, totalWeight);
        }

        for (String lifter : lifters.keySet()) {
            String exercises = "";

            for (Map.Entry<String, Long> exercise : lifters.get(lifter).entrySet()) {
                exercises += String.format(" %s - %s kg,", exercise.getKey(), exercise.getValue());
            }
            System.out.printf("%s :%s%n", lifter, exercises.substring(0, exercises.length() - 1));
        }
    }
}
