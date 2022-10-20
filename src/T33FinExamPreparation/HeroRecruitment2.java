package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroRecruitment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, ArrayList<String>> heroes = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];
            switch (command) {
                case "Enroll":
                    if (heroes.containsKey(heroName)) {
                        System.out.printf("%s is already enrolled%n", heroName);
                    } else {
                        heroes.put(heroName, new ArrayList<>());
                    }
                    break;
                case "Learn": {
                    String spellName = tokens[2];
                    if (heroes.containsKey(heroName)) {
                        ArrayList<String> magic = heroes.get(heroName);
                        if (magic.contains(spellName)) {
                            System.out.printf("%s has already learnt %s%n", heroName, spellName);
                        } else {
                            magic.add(spellName);
                        }
                    } else {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }
                }
                break;
                case "Unlearn":
                    if (heroes.containsKey(heroName)) {
                        String spellName = tokens[2];
                        ArrayList<String> spells = heroes.get(heroName);
                        if (spells.contains(spellName)) {
                            spells.remove(spellName);
                        } else {
                            System.out.printf("%s doesn't know %s%n", heroName, spellName);
                        }
                    } else {
                        System.out.println(String.format("%s doesn't exist.", heroName));
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroes.entrySet().stream().sorted((h1, h2) -> {
                    int result = Integer.compare(h2.getValue().size(), h1.getValue().size());
                    if (result == 0) {
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                })
                .forEach((entry) -> {
                    System.out.printf("== %s: ", entry.getKey());
                    System.out.println(String.join(", ", entry.getValue()));
                });
    }
}
