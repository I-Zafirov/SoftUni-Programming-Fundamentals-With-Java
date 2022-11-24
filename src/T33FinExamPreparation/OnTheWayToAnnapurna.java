package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class OnTheWayToAnnapurna {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, ArrayList<String>> diary = new TreeMap<>();
        String expression, command, shop, current;
        List<String> items = new ArrayList<>();
        String[] commands;

        while (!(expression = scanner.nextLine()).equals("END")) {
            commands = expression.split("\\-\\>");
            command = commands[0];
            shop = commands[1];
            if (command.equals("Add")) {
                current = commands[2];
                items = Arrays.stream(current.split(",")).collect(Collectors.toList());
            }
            switch (command) {
                case "Add": {
                    if (!diary.containsKey(shop)) {
                        diary.put(shop, new ArrayList<>());
                    }
                    for (int a = 0; a < items.size(); a++) {
                        diary.get(shop).add(items.get(a));
                    }
                    break;
                }
                case "Remove": {
                    if (diary.containsKey(shop)) {
                        diary.remove(shop);
                    }
                    break;
                }
                default:
                    break;
            }
        }
        System.out.println("Stores list:");
        diary.entrySet().stream()
                .sorted(Map.Entry.<String, ArrayList<String>>comparingByValue(Comparator.comparing(ArrayList::size))
                        .thenComparing(Map.Entry.comparingByKey()).reversed())
                .forEach(element -> {
                    System.out.println(element.getKey());
                    element.getValue().stream().forEach(store -> System.out.printf("<<%s>>%n", store));
                });
    }
}
