package T33FinExamPreparation;

import java.util.Locale;
import java.util.Scanner;

public class DoneChangeIncludesEndUppercaseFindIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")){
            String[] commandParts = input.split(" ");
            String command = commandParts[0];

            switch (command){
                case "Change":
                    String charToBeReplaced = commandParts[1];
                    String replacement = commandParts[2];
                    text = text.replaceAll(charToBeReplaced, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String neededString = commandParts[1];
                    if (text.contains(neededString)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "End":
                    String endingString = commandParts[1];
                    String lastWord = text.substring(text.lastIndexOf(" ") + 1);
                    if (lastWord.equals(endingString)){
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase(Locale.ROOT);
                    System.out.println(text);
                    break;
                case "FindIndex":
                    String findIndex = commandParts[1];
                    char c = findIndex.charAt(0);
                    for(int i = 0; i < text.length(); i++){
                        if(text.charAt(i) == c){
                            System.out.println(i);
                            break;
                        }
                    }
                    break;
                case "Cut":
                    int startingIndex = Integer.parseInt(commandParts[1]);
                    int endingIndex = Integer.parseInt(commandParts[2]);
                    int count = 0;
                    for(int i = startingIndex; i < text.length(); i++){
                        if (count == endingIndex){
                            break;
                        }else {
                            char currentSymbol = text.charAt(i);
                            System.out.print(currentSymbol);
                            count++;
                        }

                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
