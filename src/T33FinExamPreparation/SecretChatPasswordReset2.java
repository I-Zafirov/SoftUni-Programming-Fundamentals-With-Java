package T33FinExamPreparation;

import java.util.Scanner;

public class SecretChatPasswordReset2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        String commandLine = scanner.nextLine();
        while (!commandLine.equals("Reveal")) {
            String[] commands = commandLine.split(":\\|:");
            switch (commands[0]) {
                case "InsertSpace":
                    int index = Integer.parseInt(commands[1]);
                    input.insert(index, " ");
                    System.out.println(input);
                    break;
                case "Reverse":
                    String substring = commands[1];
                    if (input.toString().contains(substring)) {
                        int indexSubstring = input.toString().indexOf(substring);
                        input.delete(indexSubstring, indexSubstring + substring.length());
                        for (int i = substring.length() - 1; i >= 0; i--) {
                            input.append(substring.charAt(i));
                        }
                        System.out.println(input);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    substring = commands[1];
                    String replacement = commands[2];
                    String newString = "";
                    while (input.toString().contains(substring)) {
                        newString = input.toString().replace(substring, replacement);
                        input = new StringBuilder(newString);
                    }
                    System.out.println(input);
                    break;
            }
            commandLine = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", input);
    }
}
