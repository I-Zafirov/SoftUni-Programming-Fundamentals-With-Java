package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, int[]> heroes = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] hero = scanner.nextLine().split("\\s+");
            String heroName = hero[0];
            int hp = Integer.parseInt(hero[1]);
            int mp = Integer.parseInt(hero[2]);
            int[] points = new int[]{hp, mp};
            heroes.put(heroName, points);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            int amount = Integer.parseInt(tokens[2]);

            switch (command) {
                case "CastSpell":
                    String spellName = tokens[3];
                    if (heroes.get(heroName)[1] >= amount) {
                        heroes.get(heroName)[1] -= amount;
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName, heroes.get(heroName)[1]);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    String attacker = tokens[3];
                    if (heroes.get(heroName)[0] - amount > 0) {
                        heroes.get(heroName)[0] -= amount;
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, amount, attacker, heroes.get(heroName)[0]);
                    } else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    if (heroes.get(heroName)[1] + amount > 200) {
                        amount = 200 - heroes.get(heroName)[1];
                    }
                    heroes.get(heroName)[1] += amount;
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    if (heroes.get(heroName)[0] + amount > 100) {
                        amount = 100 - heroes.get(heroName)[0];
                    }
                    heroes.get(heroName)[0] += amount;
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    break;
            }
            input = scanner.nextLine();
        }
        heroes.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue()[0] - f.getValue()[0];
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(hero -> {
                    System.out.println(hero.getKey());
                    System.out.printf(" HP: %d%n", hero.getValue()[0]);
                    System.out.printf(" MP: %d%n", hero.getValue()[1]);
                });
    }
}
