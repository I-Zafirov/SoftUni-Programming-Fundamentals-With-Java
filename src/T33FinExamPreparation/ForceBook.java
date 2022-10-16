package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ForceBook {
    private static BufferedReader reader;
    private static Map<String, ForceUser> forceUsers;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        forceUsers = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!"Lumpawaroo".equals(input = reader.readLine())) {
            String[] tokens;
            String forceSide;
            String forceUser;

            if (input.matches(".+?( \\| ).+")) {
                tokens = input.split(" \\| ");
                forceSide = tokens[0];
                forceUser = tokens[1];
                forceUsers.putIfAbsent(forceUser, new ForceUser(forceUser, forceSide));

            } else if (input.matches(".+?( -> ).+")) {
                tokens = input.split(" -> ");
                forceUser = tokens[0];
                forceSide = tokens[1];

                if (forceUsers.containsKey(forceUser)) {
                    forceUsers.get(forceUser).setSide(forceSide);
                } else {
                    forceUsers.put(forceUser, new ForceUser(forceUser, forceSide));
                }

                System.out.println(String.format("%s joins the %s side!", forceUser, forceSide));
            }
        }

        forceUsers.values().stream()
                .collect(Collectors.groupingBy(ForceUser::getSide))
                .entrySet()
                .stream()
                .filter(s -> s.getValue().size() > 0)
                .sorted(sortSides())
                .forEach(printSide());

    }

    private static Comparator<Map.Entry<String, List<ForceUser>>> sortSides() {
        return (a, b) -> {
            int index = Integer.compare(b.getValue().size(), a.getValue().size());
            return index != 0 ? index : a.getKey().compareTo(b.getKey());
        };
    }

    private static Consumer<Map.Entry<String, List<ForceUser>>> printSide() {
        return side -> {
            System.out.println(String.format("Side: %s, Members: %d", side.getKey(), side.getValue().size()));
            side.getValue()
                    .stream()
                    .sorted()
                    .forEach(System.out::println);
        };
    }

    static class ForceUser implements Comparable<ForceUser> {
        private String name;
        private String side;

        ForceUser(String name, String side) {
            this.name = name;
            this.side = side;
        }

        void setSide(String side) {
            this.side = side;
        }

        String getName() {
            return this.name;
        }

        String getSide() {
            return this.side;
        }

        @Override
        public int compareTo(ForceUser other) {
            return this.getName().compareTo(other.getName());
        }

        @Override
        public String toString() {
            return String.format("! %s", this.getName());
        }
    }
}

