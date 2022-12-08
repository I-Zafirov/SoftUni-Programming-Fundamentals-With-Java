package T33FinExamPreparation;

import java.util.Scanner;

public class TheImitationGame5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String input;
        while (!"Decode".equals(input = scanner.nextLine())) {
            String[] command = input.split("\\|");
            switch (command[0]) {
                case "Move":
                    text = new StringBuilder(text.substring(Integer.parseInt(command[1])) +
                            text.substring(0, Integer.parseInt(command[1])));
                    break;
                case "Insert":
                    text.insert(Integer.parseInt(command[1]), command[2]);
                    break;
                case "ChangeAll":
                    while (text.toString().contains(command[1])) {
                        text.replace(text.indexOf(command[1]), text.indexOf(command[1]) + command[1].length(), command[2]);
                    }
                    break;
            }
        }
        System.out.printf("The decrypted message is: %s", text);
    }
}

