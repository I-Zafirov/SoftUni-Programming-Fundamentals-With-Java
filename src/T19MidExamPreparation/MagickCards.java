package T19MidExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class MagickCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> list = Arrays.stream(scan.nextLine().split(":"))
                .collect(Collectors.toList());

        String[] command = scan.nextLine().split(" ");

        List<String> deck = new ArrayList<>();

        while (!command[0].equals("Ready")) {
            switch (command[0]) {
                case "Add":
                    if (list.contains(command[1])) {
                        deck.add(command[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if (index >= 0 && index < list.size() && list.contains(command[1])) {
                        deck.add(index, command[1]);
                    } else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    if (deck.contains(command[1])) {
                        deck.remove(command[1]);
                    } else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Swap":
                    Collections.swap(deck, deck.indexOf(command[1]), deck.indexOf(command[2]));
                    break;
                case "Shuffle":
                    Collections.reverse(deck);
                    break;
            }

            command = scan.nextLine().split(" ");
        }

        for (int i = 0; i < deck.size(); i++) {
            System.out.print(deck.get(i) + " ");
        }
    }
}
