package T33FinExamPreparation;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroesOfCodeAndLogicVII3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, HeroesClass> mapHeroes = new TreeMap<>();
        for (int i = 0; i < numberHeroes; i++) {
            String[] heroesData = scanner.nextLine().split("\\s+");
            String nameHero = heroesData[0];
            int hp = Integer.parseInt(heroesData[1]);
            int mp = Integer.parseInt(heroesData[2]);
            boolean validHp = false;
            boolean validMp = false;
            if (hp <= 100) {
                validHp = true;
            }
            if (mp <= 200) {
                validMp = true;
            }
            if (validHp && validMp) {
                HeroesClass heroesInformation = new HeroesClass(hp, mp);
                mapHeroes.put(nameHero, heroesInformation);
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String[] commandData = command.split(" - ");
            String currentCommand = commandData[0];
            String heroName = commandData[1];
            switch (currentCommand) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(commandData[2]);
                    String spellName = commandData[3];
                    int currentMp = mapHeroes.get(heroName).getMp();
                    if (currentMp >= mpNeeded) {
                        int mpLeft = currentMp - mpNeeded;
                        mapHeroes.get(heroName).setMp(mpLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!\n"
                                , heroName, spellName, mpLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!\n"
                                , heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(commandData[2]);
                    String attacker = commandData[3];
                    int currentHp = mapHeroes.get(heroName).getHp();
                    int hpLeft = currentHp - damage;
                    if (hpLeft > 0) {
                        mapHeroes.get(heroName).setHp(hpLeft);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!\n"
                                , heroName, damage, attacker, hpLeft);
                    } else {
                        mapHeroes.remove(heroName);
                        System.out.printf("%s has been killed by %s!\n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(commandData[2]);
                    int currentMpRecharge = mapHeroes.get(heroName).getMp();
                    int mpRecharge = currentMpRecharge + amount;
                    if (mpRecharge > 200) {
                        mpRecharge = 200;
                    }
                    mapHeroes.get(heroName).setMp(mpRecharge);
                    System.out.printf("%s recharged for %d MP!\n", heroName
                            , mpRecharge - currentMpRecharge);
                    break;
                case "Heal":
                    amount = Integer.parseInt(commandData[2]);
                    int currentHpRecharge = mapHeroes.get(heroName).getHp();
                    int hpRecharge = currentHpRecharge + amount;
                    if (hpRecharge > 100) {
                        hpRecharge = 100;
                    }
                    mapHeroes.get(heroName).setHp(hpRecharge);
                    System.out.printf("%s healed for %d HP!\n", heroName
                            , hpRecharge - currentHpRecharge);
                    break;
            }
            command = scanner.nextLine();
        }
        mapHeroes.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().getHp()
                        , e1.getValue().getHp()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                    System.out.printf("  HP: %d\n", e.getValue().getHp());
                    System.out.printf("  MP: %d\n", e.getValue().getMp());
                });
    }

    static class HeroesClass {
        private int hp;
        private int mp;

        public HeroesClass(int hp, int mp) {
            this.hp = hp;
            this.mp = mp;
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

