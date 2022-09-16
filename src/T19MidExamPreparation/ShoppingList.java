package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays
                .stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        while (true) {
            String input = scanner.nextLine();
            if ("Go Shopping!".equals(input)) {
                break;
            }
            String[] tokens = input.split(" ");
            String command = tokens[0];
            String item = tokens[1];

            switch (command) {
                case "Urgent":
                    if (!shoppingList.contains(item)){
                        shoppingList.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    shoppingList.remove(item);
                    break;
                case "Correct":
                    String newItem = tokens[2];
                    if (shoppingList.contains(item)){
                        shoppingList.set(shoppingList.indexOf(item), newItem);
                    }
                    break;
                case "Rearrange":
                    if (shoppingList.contains(item)){
                        shoppingList.remove(item);
                        shoppingList.add(item);
                    }
                    break;
            }

        }
        for (int i = 0; i < shoppingList.size(); i++) {
            System.out.print(shoppingList.get(i));
            if (i < shoppingList.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
