package T33FinExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms2 {
    private static BufferedReader reader;
    private static Map<String, Demon> demons;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
        demons = new TreeMap<>();
    }

    public static void main(String[] args) throws IOException {
        String[] input = reader.readLine().split("[\\s,]+");

        for (String demon : input) {
            demons.put(demon, new Demon(demon));
        }

        demons.values().forEach(System.out::println);
    }

    static class Demon {
        private String name;
        private int health;
        private double damage;

        Demon(String name) {
            this.name = name;
            this.setHealth();
            this.setDamage();
        }

        private void setHealth() {
            this.health = this.name
                    .replaceAll("[0-9+\\-*\\/.]", "")
                    .chars()
                    .sum();
        }

        private void setDamage() {
            final String NUMBER_REGEX = "-?[0-9]+(\\.[0-9]+)?";
            Pattern pattern = Pattern.compile(NUMBER_REGEX);
            Matcher matcher = pattern.matcher(this.name);

            double damage = 0;
            while (matcher.find()) {
                damage += Double.parseDouble(matcher.group());
            }

            char[] actions = this.name
                    .replaceAll("[^/*]", "")
                    .toCharArray();

            for (char action : actions) {
                if (action == '/') {
                    damage /= 2;
                } else {
                    damage *= 2;
                }
            }

            this.damage = damage;
        }

        @Override
        public String toString() {
            return String.format("%s - %d health, %.2f damage", this.name, this.health, this.damage);
        }
    }
}

