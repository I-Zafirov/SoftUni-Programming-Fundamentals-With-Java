package T33FinExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<String, List<String>> heroes = new TreeMap<>();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String heroName = tokens[1];
            switch (command) {
                case "Enroll": {
                    if (!heroes.containsKey(heroName)) {
                        heroes.put(heroName, new ArrayList<>());
                    } else {
                        System.out.printf("%s is already enrolled.%n", heroName);
                    }
                }
                break;
                case "Learn": {
                    String spellName = tokens[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                        break;
                    } else {
                        if (!heroes.get(heroName).contains(spellName)) {
                            heroes.get(heroName).add(spellName);
                        } else {
                            System.out.printf("%s has already learnt %s.%n", heroName, spellName);
                            break;
                        }
                    }
                }
                break;
                case "Unlearn": {
                    String spellName = tokens[2];
                    if (!heroes.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                        break;
                    } else {
                        if (heroes.get(heroName).contains(spellName)) {
                            heroes.get(heroName).remove(spellName);
                        } else {
                            System.out.printf("%s doesn't know %s.%n", heroName, spellName);
                            break;
                        }
                    }
                }
                break;
            }
            input = scanner.nextLine();
        }
        //  !!!!!      Принтиране по този начин и сортиране по Value   !!!!!!
        //        "Heroes:
        //== {name1}: {spell1}, {spell2}, {spelln}
        //== {name2}: {spell1}, {spell2}, {spelln}

        //        Heroes:
        //        == Stefan: ItShouldWork, Ivailo
        //        == Pesho: Ivo


        System.out.println("Heroes:");
        heroes.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().size() - a.getValue().size())
                .forEach(entry -> {
                    System.out.printf("== %s: ", entry.getKey());
                    System.out.printf(String.join(", ", entry.getValue()));
                    System.out.println();
                });
    }
}
