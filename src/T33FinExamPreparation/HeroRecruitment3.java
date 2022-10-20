package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class HeroRecruitment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroesMap = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] arr = input.split(" ");

            String command = arr[0];
            String heroName = arr[1];
            switch (command) {
                case "Enroll":
                    if (!heroesMap.containsKey(heroName)) {
                        heroesMap.put(heroName, new ArrayList<>());

                    } else {
                        System.out.printf("%s is already enrolled.%n", heroName);
                        break;
                    }
                    break;
                case "Learn":
                    String spellName = arr[2];
                    if (heroesMap.containsKey(heroName)) {

                        if (!heroesMap.get(heroName).contains(spellName)) {
                            heroesMap.get(heroName).add(spellName);
                        } else {
                            System.out.printf("%s has already learnt %s.%n", heroName, spellName);
                        }
                    } else {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }
                    break;
                case "Unlearn":
                    String unlearnSpell = arr[2];
                    if (heroesMap.containsKey(heroName)) {
                        if (heroesMap.get(heroName).contains(unlearnSpell)) {
                            heroesMap.get(heroName).remove(unlearnSpell);

                        } else {
                            System.out.printf("%s doesn't know %s.%n", heroName, unlearnSpell);
                        }
                    } else {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    }
            }
            input = scanner.nextLine();
        }
        System.out.println("Heroes:");
        heroesMap.entrySet().stream()
                .sorted((h1, h2) -> Integer.compare(h2.getValue().size(), h1.getValue().size()))
                .forEach(e -> {
                    System.out.printf("== %s: %s\n", e.getKey(), e.getValue().stream().collect(Collectors.joining(", ")));
                });
    }
}
