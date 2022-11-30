package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ranking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> contests = new LinkedHashMap<>();
        Map<String, Map<String, Integer>> result = new LinkedHashMap<>();
        while (true) {
            String[] input = reader.readLine().split(":");
            if ("end of contests".equals(input[0])) {
                break;
            }
            contests.putIfAbsent(input[0], input[1]);
        }
        while (true) {

            String[] input = reader.readLine().split("=>");
            if ("end of submissions".equals(input[0])) {
                break;
            }
            String username = input[2];
            String contest = input[0];
            String pass = input[1];
            int point = Integer.parseInt(input[3]);

            if (contests.containsKey(contest) && contests.get(contest).equals(pass)) {
                result.putIfAbsent(username, new LinkedHashMap<>());
                result.get(username).putIfAbsent(contest, 0);
                if (result.get(username).get(contest) < point) {
                    result.get(username).put(contest, point);
                }
            }
        }


        result.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue().values().stream().mapToInt(x -> Integer.valueOf(x)).sum(),
                a.getValue().values().stream().mapToInt(x -> Integer.valueOf(x)).sum())).limit(1).forEach(x -> {

            System.out.printf("Best candidate is %s with total %d points.\n", x.getKey(),
                    x.getValue().values().stream().mapToInt(a -> Integer.valueOf(a)).sum());

        });
        System.out.println("Ranking:");
        result.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey())).forEach(x -> {
            System.out.printf("%s\n", x.getKey());
            x.getValue().entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).
                    forEach(y -> {
                        System.out.printf("#  %s -> %d\n", y.getKey(), y.getValue());
                    });

        });
    }
}
