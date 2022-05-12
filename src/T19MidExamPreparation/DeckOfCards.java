package T19MidExamPreparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DeckOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> ownedCards = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            String command = tokens[0];

            switch (command){
                case "Add":
                    String cardName = tokens[1];
                    if (ownedCards.contains(cardName)){
                        System.out.println("Card is already bought");
                    }else{
                        ownedCards.add(cardName);
                        System.out.println("Card successfully bought");
                    }
                    break;
                case "Remove":
                    cardName = tokens[1];
                    if (ownedCards.contains(cardName)){
                        ownedCards.remove(cardName);
                        System.out.println("Card successfully sold");
                    }else{
                        System.out.println("Card not found");
                    }
                    break;
                case "Remove At":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < ownedCards.size()){
                        ownedCards.remove(index);
                        System.out.println("Card successfully sold");
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;
                case "Insert":
                    index = Integer.parseInt(tokens[1]);
                    cardName = tokens[2];
                    if (index >= 0 && index < ownedCards.size()){
                        if (ownedCards.contains(cardName)){
                            System.out.println("Card is already bought");
                        }else{
                            ownedCards.add(index, cardName);
                            System.out.println("Card successfully bought");
                        }
                    }else{
                        System.out.println("Index out of range");
                    }
                    break;
            }
        }

        for (int i = 0; i < ownedCards.size(); i++) {
            System.out.print(ownedCards.get(i));
            if (i < ownedCards.size() - 1){
                System.out.print(", ");
            }
        }
    }
}
