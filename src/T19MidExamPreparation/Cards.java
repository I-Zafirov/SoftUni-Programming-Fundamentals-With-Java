package T19MidExamPreparation;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Cards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> cards = Arrays.stream(scan.nextLine().split(":"))
                .collect(Collectors.toList());

        String input = scan.nextLine();

        while (!input.equals("Ready")){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command){
                case "Add":
                    String cardToBeAdded = tokens[1];
                    if(!cards.contains(cardToBeAdded)){
                        System.out.println("Card not found.");
                    }else{
                        cards.add(cardToBeAdded);
                    }
                    break;
                case "Insert":
                    String cardNameToBeInserted = tokens[1];
                    int indexToBeInserted = Integer.parseInt(tokens[2]);
                    if(isValid(indexToBeInserted, cards.size()) && cards.contains(cardNameToBeInserted)){
                        cards.add(indexToBeInserted, cardNameToBeInserted);
                    }else {
                        System.out.println("Error!");
                    }
                    break;
                case "Remove":
                    String cardToBeRemoved = tokens[1];
                    if(cards.contains(cardToBeRemoved)){
                        cards.remove(cardToBeRemoved);
                    }
                    break;
                case "Swap":
                    String firstCard = tokens[1];
                    String secondCard = tokens[2];

                    int firstIndex = cards.indexOf(firstCard);
                    int secondIndex = cards.indexOf(secondCard);

                    cards.set(firstIndex, secondCard);
                    cards.set(secondIndex, firstCard);
                    break;
                case "Shuffle":
                    Collections.reverse(cards);
                    break;

            }


            input = scan.nextLine();
        }
        for (String card : cards) {
            System.out.print(card + " ");
        }
    }

    private static boolean isValid(int indexToBeInserted, int size) {
        return indexToBeInserted >= 0 && indexToBeInserted <= size - 1;
    }
}
