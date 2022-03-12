package T24AssociativeArrays.moreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ME2Judge2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> contests = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!"no more time".equals(input)) {
            String[] tokens = input.split("\\s*->\\s*");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            contests.putIfAbsent(contest, new LinkedHashMap<>());
            contests.get(contest).putIfAbsent(username, -1);
            if (contests.get(contest).get(username) < points) {
                contests.get(contest).put(username, points);
            }
            input = scanner.nextLine();
        }

        AtomicInteger num = new AtomicInteger(1);

        contests.entrySet().stream().forEach(e -> {
            num.set(1);
            System.out.println(e.getKey() + ": " + e.getValue().size() + " participants");
            e.getValue().entrySet().stream().sorted((k2, k1) -> {
                int sort = Integer.compare(k1.getValue(), k2.getValue());
                if (sort == 0) {
                    sort = k2.getKey().compareTo(k1.getKey());
                }
                return sort;
            }).forEach(element -> {
                System.out.printf("%d. %s <::> %d\n",
                        num.getAndIncrement(), element.getKey(), element.getValue());
            });
        });

        Map<String, Integer> standings = new LinkedHashMap<>();

        for (Map.Entry<String, LinkedHashMap<String, Integer>> wtf : contests.entrySet()) {
            for (Map.Entry<String, Integer> lol : wtf.getValue().entrySet()) {
                standings.putIfAbsent(lol.getKey(), 0);
                standings.put(lol.getKey(), standings.get(lol.getKey()) + lol.getValue());
            }
        }
        System.out.println("Individual standings:");
        num.set(1);

        standings.entrySet().stream().sorted((e2, e1) -> {
            int sort = Integer.compare(e1.getValue(), e2.getValue());
            if (sort == 0) {
                sort = e2.getKey().compareTo(e1.getKey());
            }
            return sort;

        }).forEach(element -> {
            System.out.printf("%d. %s -> %d%n",
                    num.getAndIncrement(), element.getKey(), element.getValue());
        });
    }
}
