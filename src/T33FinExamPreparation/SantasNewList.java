package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class SantasNewList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> mapChild = new TreeMap<>();
        Map<String, Integer> mapPresents = new LinkedHashMap<>();
        while (!input.equals("END")) {
//            {childName}->{typeOfToy}->{amount}
//            Remove->{childName}
            String[] inputCommands = input.split("->");
            if (!inputCommands[0].equals("Remove")) {
                String childName = inputCommands[0];
                String typeOfToy = inputCommands[1];
                int amount = Integer.parseInt(inputCommands[2]);
                if (!mapChild.containsKey(childName)) {
                    mapChild.put(childName, amount);
                } else {
                    int currentAmountToys = mapChild.get(childName);
                    mapChild.put(childName, currentAmountToys + amount);
                }
                if (!mapPresents.containsKey(typeOfToy)) {
                    mapPresents.put(typeOfToy, amount);
                } else {
                    int currentAmountForTypeOfToy = mapPresents.get(typeOfToy);
                    mapPresents.put(typeOfToy, currentAmountForTypeOfToy + amount);
                }
            } else {
                String childNameToRemove = inputCommands[1];
                mapChild.remove(childNameToRemove);
            }
            input = scanner.nextLine();
        }
        System.out.println("Children:");
        mapChild.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .forEach(e -> System.out.printf("%s -> %d\n", e.getKey(), e.getValue()));
        System.out.println("Presents:");
        for (var e : mapPresents.entrySet()) {
            System.out.printf("%s -> %d\n", e.getKey(), e.getValue());
        }
    }
}
