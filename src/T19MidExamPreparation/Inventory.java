package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> items = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        while (true){
            String input = scanner.nextLine();
            if (input.equals("Craft!")){
                break;
            }
            String[] tokens = input.split(" - ");
            String command = tokens[0];
            String item = tokens[1];

            switch (command){
                case "Collect":
                    if (!items.contains(item)){
                        items.add(item);
                    }
                    break;
                case "Drop":
                    items.remove(item);
                    break;
                case "Combine Items":
                    String[] combinedItems = item.split(":");
                    String oldItem = combinedItems[0];
                    String newItem = combinedItems[1];
                    if (items.contains(oldItem)){
                        int index = items.indexOf(oldItem);
                        items.add(index + 1 , newItem);
                    }
                    break;
                case "Renew":
                    if (items.contains(item)){
                        items.remove(item);
                        items.add(item);
                    }
                    break;
            }
        }

        System.out.println(String.join(", ", items));
    }
}
