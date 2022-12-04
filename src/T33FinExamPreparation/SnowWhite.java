package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class SnowWhite {
    private static BufferedReader reader;
    private static Map<String, Map<String, Dwarf>> dwarfs;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        dwarfs = new LinkedHashMap<>();
    }

    public static void main(String[] args) throws IOException {

        String input;
        while (!"Once upon a time".equals(input = reader.readLine())) {
            String[] tokens = input.split("[:<>\\s]+");
            String name = tokens[0];
            String hatColour = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            dwarfs.putIfAbsent(hatColour, new LinkedHashMap<>());
            dwarfs.get(hatColour).putIfAbsent(name, new Dwarf(name, hatColour, physics));
            dwarfs.get(hatColour).get(name).setPhysics(physics);
        }

        dwarfs.values().stream()
                .sorted((a, b) -> Integer.compare(b.size(), a.size()))
                .flatMap(d -> d.values().stream())
                .sorted()
                .forEach(System.out::println);

    }


    static class Dwarf implements Comparable<Dwarf> {
        private String name;
        private String hatColour;
        private int physics;

        Dwarf(String name, String hatColour, int physics) {
            this.name = name;
            this.hatColour = hatColour;
            this.physics = physics;
        }

        void setPhysics(int physics) {
            if (physics > this.physics) {
                this.physics = physics;
            }
        }

        String getName() {
            return this.name;
        }

        private String getHatColour() {
            return this.hatColour;
        }

        private int getPhysics() {
            return this.physics;
        }

        @Override
        public int compareTo(Dwarf other) {
            return Integer.compare(other.getPhysics(), this.getPhysics());
        }

        @Override
        public String toString() {
            return String.format("(%s) %s <-> %d", this.getHatColour(), this.getName(), this.getPhysics());
        }
    }
}

