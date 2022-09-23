package T19MidExamPreparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WizardPoker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> data = Arrays.stream(input.nextLine().split(":"))
                .collect(Collectors.toList());

        List<String> cards = new ArrayList<>();
        String expression;
        String[] command;

        while(!(expression = input.nextLine()).equals("Ready")){
            command = expression.split("\\s+");

            switch (command[0]){
                case "Add": addsCard(data, cards, command[1]); break;
                case "Insert": insertsCard(data, cards, command[1], Integer.parseInt(command[2])); break;
                case "Remove": removesCard(cards, command[1]); break;
                case "Swap": swapsCards(cards, command[1], command[2]);break;
                case "Shuffle": shufflesCards(cards); break;
                default: break;
            }
        }

        for(String card : cards){
            System.out.print(card + " ");
        }
    }


    public static void addsCard(List<String> data, List<String> cards, String card){
        boolean judge = false;

        for(int z = 0; z < data.size(); z++){
            if(data.get(z).equals(card)){
                judge = true;
                break;
            }
        }

        if(judge == true){
            cards.add(card);
        }
        else{
            System.out.println("Card not found.");
        }
    }


    public static void insertsCard(List<String> data, List<String> cards, String card, int index){
        boolean judge = false;

        for (int a = 0; a < data.size(); a++) {
            if(data.get(a).equals(card)){
                judge = true;
                break;
            }
        }

        if(judge == true && index >=0 && index <= cards.size() - 1){
            cards.add(index, card);
        }
        else{
            System.out.println("Error!");
        }
    }


    public static void removesCard(List<String> cards, String card){
        boolean judge = false;

        for (int b = 0; b < cards.size(); b++) {
            if(cards.get(b).equals(card)){
                judge = true;
                break;
            }

        }

        if(judge == true){
            cards.remove(card);
        }
        else{
            System.out.println("Card not found.");
        }
    }


    public static void swapsCards(List<String> cards, String card1, String card2){
        int firstIndex = cards.indexOf(card1);
        int secondIndex = cards.indexOf(card2);

        cards.set(firstIndex, card2);
        cards.set(secondIndex, card1);
    }


    public static void shufflesCards(List<String> cards){
        String[] result = new String[cards.size()];

        for (int i = 0; i < cards.size(); i++) {
            result[cards.size() - 1 - i] = cards.get(i);

        }

        for (int k = 0; k < result.length; k++) {
            cards.set(k, result[k]);
        }
    }
}
