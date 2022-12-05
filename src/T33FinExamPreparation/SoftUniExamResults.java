package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoftUniExamResults {
    private static BufferedReader reader;
    private static Map<String, Integer> languages;
    private static Map<String, User> users;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        languages = new LinkedHashMap<>();
        users = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!"exam finished".equals(input = reader.readLine())) {
            String[] tokens = input.split("-");
            String username = tokens[0];

            if ("banned".equals(tokens[1])) {
                if (users.containsKey(username)) {
                    users.remove(username);
                }

            } else {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);

                languages.putIfAbsent(language, 0);
                languages.put(language, languages.get(language) + 1);

                users.putIfAbsent(username, new User(username));
                users.get(username).setPoints(points);

            }
        }

        System.out.println("Results:");
        users.values()
                .stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("Submissions:");
        languages.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int index = Integer.compare(b.getValue(), a.getValue());
                    return index != 0 ? index : a.getKey().compareTo(b.getKey());
                })
                .forEach(language -> {
                    System.out.println(String.format("%s - %d", language.getKey(), language.getValue()));
                });

    }

    static class User implements Comparable<User> {
        private String name;
        private int points;

        User(String name) {
            this.name = name;
            this.points = 0;
        }

        public String getName() {
            return this.name;
        }

        private int getPoints() {
            return this.points;
        }

        void setPoints(int points) {
            if (points > this.points) {
                this.points = points;
            }
        }

        @Override
        public int compareTo(User other) {
            int index = Integer.compare(other.getPoints(), this.getPoints());
            return index != 0 ? index : this.getName().compareTo(other.getName());
        }

        @Override
        public String toString() {
            return String.format("%s | %d", this.getName(), this.getPoints());
        }
    }
}


