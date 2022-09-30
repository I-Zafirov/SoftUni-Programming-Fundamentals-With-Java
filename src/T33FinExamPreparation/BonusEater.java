package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class BonusEater {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] listOfNames = sc.nextLine().split("\\s+\\$\\$\\s+");

        Map<String, Map<Double, Double>> mapWithBonusesAndSalary = new HashMap<>();

        for (String name : listOfNames) {
            Map<Double, Double> helpMap = new HashMap<>();
            helpMap.put((name.length() / 2.0) * 1000.0, 0.0);
            mapWithBonusesAndSalary.put(name, helpMap);
        }

        String commands = sc.nextLine();

        while (!commands.equals("Easter")) {
            String[] commandsProps = commands.split("\\s+");
            String actualCommand = commandsProps[0];

            if (actualCommand.equals("Add")) {
                for (int i = 1; i < commandsProps.length; i++) {
                    Map<Double, Double> helpMap = new HashMap<>();
                    String replaced = commandsProps[i].replaceAll(",", "");

                    if (!mapWithBonusesAndSalary.containsKey(replaced)) {
                        Double salary = (replaced.length() / 2.0) * 1000.0;
                        helpMap.put(salary, 0.0);
                        mapWithBonusesAndSalary.put(commandsProps[i], helpMap);
                        System.out.printf("%s is newly added to the system with a salary of %.2f!%n", replaced, salary);
                    } else {
                        Double salary = mapWithBonusesAndSalary.get(replaced).keySet().stream().findFirst().get();
                        Double bonus = mapWithBonusesAndSalary.get(replaced).get(salary).doubleValue();
                        helpMap.put(salary + 100, bonus + 10);
                        mapWithBonusesAndSalary.put(replaced, helpMap);
                    }
                }

            } else if (actualCommand.equals("Bonus")) {
                String name = commandsProps[1];
                Double bonusPlus = Double.parseDouble(commandsProps[2]);
                Map<Double, Double> helpMap = new HashMap<>();

                if (!mapWithBonusesAndSalary.containsKey(name)) {
                    System.out.println("No such employee was found!");
                } else {
                    Double salary = mapWithBonusesAndSalary.get(name).keySet().stream().findFirst().get();
                    Double bonus = mapWithBonusesAndSalary.get(name).get(salary).doubleValue();
                    helpMap.put(salary, bonus + bonusPlus);
                    mapWithBonusesAndSalary.put(name, helpMap);
                }

            } else if (actualCommand.equals("Charge")) {
                String name = commandsProps[2];

                if (mapWithBonusesAndSalary.containsKey(name)) {
                    Double salary = mapWithBonusesAndSalary.get(name).keySet().stream().findFirst().get();
                    Double bonus = mapWithBonusesAndSalary.get(name).get(salary).doubleValue();
                    Map<Double, Double> helpMap = new HashMap<>();

                    if (bonus - 101 <= 0) {
                        helpMap.put(salary, 0.0);
                    } else {
                        helpMap.put(salary, bonus - 101);
                    }
                    mapWithBonusesAndSalary.put(name, helpMap);
                }

            } else if (actualCommand.equals("Show")) {
                Double bonusToCompare = Double.parseDouble(commandsProps[1]);
                List<String> names = new ArrayList<>();

                for (String key : mapWithBonusesAndSalary.keySet()) {
                    Double salary = mapWithBonusesAndSalary.get(key).keySet().stream().findFirst().get();
                    Double bonus = mapWithBonusesAndSalary.get(key).get(salary).doubleValue();
                    if (bonus > bonusToCompare) {
                        names.add(key);
                    }
                }

                if (names.isEmpty()) {
                    System.out.printf("No employees with a bonus higher than %.2f!%n", bonusToCompare);
                } else {
                    System.out.println(String.join(", ", names));
                }
            }

            commands = sc.nextLine();
        }

        List<String> sortedList = mapWithBonusesAndSalary.keySet().stream().sorted().collect(Collectors.toList());

        System.out.println("Best employees this Easter:");
        for (String s : sortedList) {
            Double salary = mapWithBonusesAndSalary.get(s).keySet().stream().findFirst().get();
            Double bonus = mapWithBonusesAndSalary.get(s).get(salary).doubleValue();

            if (bonus > 0) {
                System.out.printf("     -> %s with salary %.2f and additional Easter bonus %.2f%n", s, salary, bonus);
            }
        }

    }
}
