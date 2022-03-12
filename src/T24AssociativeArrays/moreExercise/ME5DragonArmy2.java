package T24AssociativeArrays.moreExercise;

import java.util.*;
import java.util.stream.DoubleStream;

public class ME5DragonArmy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Dragons>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            int damage, health, armor;
            if (input[2].equals("null")) {
                damage = 45;
            } else {
                damage = Integer.parseInt(input[2]);
            }
            if (input[3].equals("null")) {
                health = 250;
            } else {
                health = Integer.parseInt(input[3]);
            }
            if (input[4].equals("null")) {
                armor = 10;
            } else {
                armor = Integer.parseInt(input[4]);
            }
            Dragons current = new Dragons(name, damage, health, armor);

            if (dragons.containsKey(type)
                    && dragons.get(type).stream().filter(a -> a.name.equals(name)).count() > 0) {
                dragons.get(type).stream().filter(a -> a.name.equals(name)).forEach(a -> {
                    a.damage = damage;
                    a.health = health;
                    a.armor = armor;
                });
            } else if (dragons.containsKey(type)) {
                dragons.get(type).add(current);
            } else if (!dragons.containsKey(type)) {
                List<Dragons> currentList = new ArrayList<>();
                currentList.add(current);
                dragons.put(type, currentList);
            }
        }
        dragons.entrySet().stream().forEach(a -> {
            double averageDamage = a.getValue().stream()
                    .flatMapToDouble(b -> DoubleStream.of(b.damage)).average().getAsDouble();
            double averageHealth = a.getValue().stream()
                    .flatMapToDouble(b -> DoubleStream.of(b.health)).average().getAsDouble();
            double averageArmor = a.getValue().stream()
                    .flatMapToDouble(b -> DoubleStream.of(b.armor)).average().getAsDouble();
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)"
                    , a.getKey(), averageDamage, averageHealth, averageArmor));
            a.getValue().stream().sorted((f, s) -> f.name.compareTo(s.name)).forEach(b -> {
                System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d"
                        , b.name, b.damage, b.health, b.armor));
            });
        });
    }

    private static class Dragons {
        String name;
        int damage;
        int health;
        int armor;

        public Dragons(String name, int damage, int health, int armor) {
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getDamage() {
            return damage;
        }

        public void setDamage(int damage) {
            this.damage = damage;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getArmor() {
            return armor;
        }

        public void setArmor(int armor) {
            this.armor = armor;
        }
    }
}
