package T33FinExamPreparation;

import java.util.*;
import java.util.stream.Collectors;

public class MagicCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> deck = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        List<String> newDeck = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("Ready")) {
            String[] data = input.split(" ");
            switch (data[0]) {
                case "Add":
                    addCard(data, deck, newDeck);
                    break;
                case "Insert":
                    insertCard(data, deck, newDeck);
                    break;
                case "Remove":
                    removeCard(data, deck, newDeck);
                    break;
                case "Swap":
                    swapCards(data, newDeck);
                    break;
                case "Shuffle":
                    Collections.reverse(newDeck);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(newDeck.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void addCard(String[] data, List<String> deck, List<String> newDeck) {
        String card = data[1];
        if (deck.contains(card)) {
            newDeck.add(card);
        } else {
            System.out.println("Card not found.");
        }
    }

    private static void insertCard(String[] data, List<String> deck, List<String> newDeck) {
        String card = data[1];
        int index = Integer.parseInt(data[2]);
        if (deck.contains(card) && index >= 0 && index <= newDeck.size() - 1) {
            newDeck.add(index, card);
        } else {
            System.out.println("Error!");
        }
    }

    private static void removeCard(String[] data, List<String> deck, List<String> newDeck) {
        String card = data[1];
        if (newDeck.contains(card)) {
            newDeck.remove(card);
        } else {
            System.out.println("Card not found.");
        }
    }

    private static void swapCards(String[] data, List<String> newDeck) {
        String card1 = data[1];
        String card2 = data[2];
        int indexCard1 = newDeck.indexOf(card1);
        int indexCard2 = newDeck.indexOf(card2);
        newDeck.set(indexCard1, card2);
        newDeck.set(indexCard2, card1);
    }
}
