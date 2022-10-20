package T33FinExamPreparation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVIIObject {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Hero> heroes = new HashMap<>();
        int partyAnimals = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < partyAnimals; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int hp = Integer.parseInt(tokens[1]);
            int mp = Integer.parseInt(tokens[2]);
            Hero hero = new Hero(name, hp, mp);
            heroes.put(hero.getName(), hero);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] commands = input.split("\\s+-\\s+");
            switch (commands[0]) {
                case "CastSpell": {
                    String heroName = commands[1];
                    int neededMp = Integer.parseInt(commands[2]);
                    String spellName = commands[3];
                    int heroMp = heroes.get(heroName).getMp();
                    if (neededMp <= heroMp) {
                        heroMp -= neededMp;
                        heroes.get(heroName).setMp(heroMp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n",
                                heroName, spellName, heroMp);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n",
                                heroName, spellName);
                    }
                    break;
                }
                case "TakeDamage": {
                    String heroName = commands[1];
                    int damage = Integer.parseInt(commands[2]);
                    String attacker = commands[3];
                    int heroHp = heroes.get(heroName).getHp();
                    heroHp -= damage;
                    heroes.get(heroName).setHp(heroHp);
                    if (heroHp > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",
                                heroName, damage, attacker, heroHp);
                    } else {
                        heroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                }
                break;
                case "Recharge": {
                    String heroName = commands[1];
                    int amount = Integer.parseInt(commands[2]);
                    int heroMp = heroes.get(heroName).getMp();
                    if (heroMp + amount > 200) {
                        amount = 200 - heroMp;
                    }
                    heroMp += amount;
                    heroes.get(heroName).setMp(heroMp);
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                }
                break;
                case "Heal": {
                    String heroName = commands[1];
                    int amount = Integer.parseInt(commands[2]);
                    int heroHp = heroes.get(heroName).getHp();

                    if (heroHp + amount > 100) {
                        amount = 100 - heroHp;
                    }
                    heroHp += amount;
                    heroes.get(heroName).setHp(heroHp);
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                }
                break;
                default:
                    System.out.println("Invalid command" + commands[0]);
                    break;
            }

            input = scanner.nextLine();
        }
        heroes.values().stream()
                .sorted((f, s) -> {
                    int result = Integer.compare(s.getHp(), f.getHp());
                    if (result == 0) {
                        result = f.getName().compareTo(s.getName());
                    }
                    return result;
                })
                .map(Hero::toString)
                .forEach(System.out::println);
    }

    private static class Hero {
        private final String name;
        private int hp;
        private int mp;

        public Hero(String name, int hp, int mp) {
            this.name = name;
            this.hp = hp;
            this.mp = mp;
        }

        @Override
        public String toString() {
            return String.format("%s%n HP: %d%n MP: %d",
                    name, hp, mp);

        }

        public String getName() {
            return name;
        }

        public int getHp() {
            return hp;
        }

        public int getMp() {
            return mp;
        }

        public void setHp(int hp) {
            this.hp = hp;
        }

        public void setMp(int mp) {
            this.mp = mp;
        }
    }
}
