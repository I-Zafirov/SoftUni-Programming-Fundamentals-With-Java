package T33FinExamPreparation;

import java.util.Scanner;

public class SecretChat2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();
        while (!input.equals("Reveal")) {
            String[] inputCommand = input.split(":\\|:");
            String command = inputCommand[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(inputCommand[1]);
                    text.insert(index, " ");
                    System.out.println(text);
                    break;
                case "Reverse":
                    String substring = inputCommand[1];
                    if (text.toString().contains(substring)) {
                        StringBuilder newWord = new StringBuilder();
                        newWord.append(substring).reverse();

                        String newText = text.toString().replaceFirst(substring, "");
                        newText = newText + newWord;
                        text.delete(0, text.length());
                        text.append(newText);
                        System.out.println(newText);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String currentSymbol = inputCommand[1];
                    String newSymbol = inputCommand[2];

                    if (text.toString().contains(currentSymbol)) {
                        String replaceString = text.toString().replaceAll(currentSymbol, newSymbol);
                        text.delete(0, text.length());
                        text.append(replaceString);
                        System.out.println(text);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", text);
    }
}
