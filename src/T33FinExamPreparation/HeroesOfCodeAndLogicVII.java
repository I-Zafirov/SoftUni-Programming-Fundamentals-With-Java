package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> heroesHit = new HashMap<>();
        HashMap<String, Integer> heroesMana = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String heroName = tokens[0];
            int hitPoints = Integer.parseInt(tokens[1]);
            int manaPoints = Integer.parseInt(tokens[2]);

            heroesHit.put(heroName, hitPoints);
            heroesMana.put(heroName, manaPoints);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String heroName = tokens[1];
            switch (command) {
                case "CastSpell":
                    int neededMP = Integer.parseInt(tokens[2]);
                    String spellName = tokens[3];
                    if (heroesMana.get(heroName) - neededMP >= 0) {
                        heroesMana.put(heroName, heroesMana.get(heroName) - neededMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName, heroesMana.get(heroName));
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(tokens[2]);
                    String attacker = tokens[3];
                    if (heroesHit.get(heroName) - damage > 0) {
                        heroesHit.put(heroName, heroesHit.get(heroName) - damage);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, heroesHit.get(heroName));
                    } else {
                        heroesHit.remove(heroName);
                        heroesMana.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(tokens[2]);
                    if (heroesMana.get(heroName) + amount > 200) {
                        amount = 200 - heroesMana.get(heroName);
                        heroesMana.put(heroName, 200);
                    } else {
                        heroesMana.put(heroName, heroesMana.get(heroName) + amount);
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    amount = Integer.parseInt(tokens[2]);
                    if (heroesHit.get(heroName) + amount > 100) {
                        amount = 100 - heroesHit.get(heroName);
                        heroesHit.put(heroName, 100);
                    } else {
                        heroesHit.put(heroName, heroesHit.get(heroName) + amount);

                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    break;
            }
            input = scanner.nextLine();
        }
        heroesHit.entrySet()
                .stream()
                .sorted((f, s) -> {
                    int result = s.getValue().compareTo(f.getValue());
                    if (result == 0) {
                        result = f.getKey().compareTo(s.getKey());
                    }
                    return result;
                }).forEach(hero -> {
                    System.out.println(hero.getKey());
                    System.out.printf(" HP: %d%n", hero.getValue());
                    System.out.printf(" MP: %d%n", heroesMana.get(hero.getKey()));
                });
    }
}
