package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicCards2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> deck = new ArrayList<String>();
        List<String> cards = new ArrayList<String>();
        cards = getCards(scan);
        String manipulation = scan.nextLine();
        while ((manipulation.equals("Ready")) != true) {
            deck = manipulations(deck, cards, manipulation);
            manipulation = scan.nextLine();
        }
        printDeck(deck, " ");

    }

    private static void printDeck(List<String> deck, String delimiter) {
        String output = "";
        for (String index : deck) {
            output += (index + delimiter);
        }
        System.out.println(output);

    }

    private static List<String> manipulations(List<String> deck, List<String> cards, String manipulation) {
        String[] command = manipulation.split(" ");
        switch (command[0]) {
            case "Add":
                deck = addToList(deck, cards, command[1]);
                break;
            case "Insert":
                deck = insetToList(deck, cards, command[1], Integer.parseInt(command[2]));
                break;
            case "Remove":
                deck = removeFromList(deck, command[1]);
                break;
            case "Swap":
                deck = swapCards(deck, command[1], command[2]);
                break;
            case "Shuffle":
                deck = reverseDeck(deck);
                break;
        }
        return deck;

    }


    private static List<String> reverseDeck(List<String> deck) {
        List<String> reverse = new ArrayList<String>();
        for (int i = (deck.size() - 1); i >= 0 ; i--) {
            reverse.add(deck.get(i));
        }
        return reverse;
    }

    private static List<String> swapCards(List<String> deck, String cardName1, String cardName2) {
        int indexCard1 = deck.indexOf(cardName1);
        int indexCard2 = deck.indexOf(cardName2);
        deck.set(indexCard1, cardName2);
        deck.set(indexCard2, cardName1);
        return deck;
    }

    private static List<String> removeFromList(List<String> deck, String cardName) {
        if (deck.contains(cardName)) {
            deck.remove(cardName);
        }else {
            System.out.println("Card not found.");
        }
        return deck;
    }

    private static List<String> insetToList(List<String> deck, List<String> cards, String cardName, int index) {
        if (cards.contains(cardName) && (index >= 0) && (index < deck.size())) {
            deck.add(index, cardName);
        }else {
            System.out.println("Error!");
        }
        return deck;
    }

    private static List<String> addToList(List<String> deck, List<String> cards, String cardName) {
        if (cards.contains(cardName)) {
            deck.add(cardName);
        }else {
            System.out.println("Card not found.");
        }
        return deck;
    }

    private static List<String> getCards(Scanner scan) {
        List<String> output = new ArrayList<String>();
        String[] input = scan.nextLine().split(":");
        for (int i = 0; i < input.length; i++) {
            output.add(input[i]);
        }
        return output;
    }
}
