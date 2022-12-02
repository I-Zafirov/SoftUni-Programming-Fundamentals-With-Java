package T33FinExamPreparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SantaNewList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> children = new LinkedHashMap<>();
        Map<String, Integer> presents = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("->");
            String typeOfCommand = tokens[0];
            if (typeOfCommand.equals("Remove")) {
                String name = tokens[1];
                children.remove(name);
            } else {
                String childName = tokens[0];
                String typeOfPresent = tokens[1];
                int amount = Integer.parseInt(tokens[2]);
                if (!children.containsKey(childName)) {
                    children.put(childName, 0);
                }
                children.put(childName, children.get(childName) + amount);
                if (!presents.containsKey(typeOfPresent)) {
                    presents.put(typeOfPresent, 0);
                }
                presents.put(typeOfPresent, presents.get(typeOfPresent) + amount);
            }
            input = scanner.nextLine();
        }
        System.out.println("Children:");
        children.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
        System.out.println("Presents:");
        presents.entrySet().forEach(entry -> System.out.println(entry.getKey() + " -> " + entry.getValue()));
    }
}
