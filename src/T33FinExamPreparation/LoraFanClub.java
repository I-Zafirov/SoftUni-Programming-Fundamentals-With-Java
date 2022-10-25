package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class LoraFanClub {
    private static BufferedReader reader;
    private static Map<String, Person> persons;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        persons = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {
        String input;
        while (!"Make a decision already!".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if (tokens[tokens.length - 1].equals("Gyubek!")) {
                String name = tokens[0];

                if (persons.containsKey(name)) {
                    persons.get(name).removePositiveTraits();
                }

            } else {
                String name = tokens[0];
                String trait = tokens[1];
                int value = Integer.parseInt(tokens[2]);

                persons.putIfAbsent(name, new Person(name));
                persons.get(name).add(trait, value);
            }

        }

        persons.values()
                .stream()
                .sorted()
                .forEach(System.out::print);

    }

    static class Person implements Comparable<Person> {
        private static final Map<String, Integer> positiveTraits;
        private static final List<String> negativeTraits;

        private String name;
        private Map<String, Integer> traits;

        static {
            positiveTraits = new HashMap<String, Integer>() {{
                put("Kind", 2);
                put("Handsome", 3);
                put("Smart", 5);
            }};
            negativeTraits = Arrays.asList("Greedy", "Rude", "Dumb");
        }

        Person(String name) {
            this.name = name;
            this.traits = new LinkedHashMap<>();
        }

        String getName() {
            return this.name;
        }

        void add(String trait, int value) {
            if (negativeTraits.contains(trait)) {
                value *= -1;
            } else if (positiveTraits.containsKey(trait)) {
                value *= positiveTraits.get(trait);
            }

            this.traits.putIfAbsent(trait, value);
            int oldValue = traits.get(trait);
            if (value > oldValue) {
                this.traits.put(trait, value);
            }
        }

        void removePositiveTraits() {
            this.traits = this.traits.entrySet()
                    .stream()
                    .filter(e -> e.getValue() < 0)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (oldValue, newValue) -> oldValue,
                            LinkedHashMap::new));
        }

        private int getTraitsSum() {
            return traits.values()
                    .stream()
                    .mapToInt(i -> i)
                    .sum();
        }

        @Override
        public int compareTo(Person other) {
            int index = Integer.compare(other.getTraitsSum(), this.getTraitsSum());
            return index != 0 ? index : this.getName().compareTo(other.getName());
        }

        @Override
        public String toString() {
            StringBuilder output = new StringBuilder();
            output.append(String.format("# %s: %d%n", this.getName(), this.getTraitsSum()));
            this.traits.entrySet()
                    .stream()
                    .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                    .forEach(t -> output.append(String.format("!!! %s -> %d%n", t.getKey(), t.getValue())));
            return output.toString();
        }
    }
}

